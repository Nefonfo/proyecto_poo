/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Db.Database;
import IModel.IUser;
import Manager.UserManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Nefonfo
 */
public class User implements IUser<User, UserManager> {
    
    private Connection conn;
    
    private int id;
    public String name;
    public String email;
    private String password;
    
    private final UserManager objects = new UserManager();
    private final String table_name = "User";
    private boolean can_save;
    private boolean is_pristine;
    
    public User() {
        this.can_save = false;
    }
    
    public User(int id, String name, String email, String password) throws Exception {
        String validation = this.validate(name, email, password, false);
        if(validation != null) {
            throw new Exception(validation);
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        
        this.can_save = true;
        this.is_pristine = false;
        
        this.conn = Database.getConnection();
    }

    public User(String name, String email, String password) throws Exception {
        String validation = this.validate(name, email, password, true);
        if(validation != null) {
            throw new Exception(validation);
        }
        this.name = name;
        this.email = email;
        setPassword(password);
       
        this.can_save = true;
        this.is_pristine = true;
        
        this.conn = Database.getConnection();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        PasswordEncryptor encryptor = new BasicPasswordEncryptor();
        this.password = encryptor.encryptPassword(password);
    }
    
    public int getId() {
        return this.id;
    }

    @Override
    public UserManager getObjects() {
      return this.objects;
    }
    
    @Override
    public boolean compare_password(String password) {
        PasswordEncryptor encryptor = new BasicPasswordEncryptor();
        return encryptor.checkPassword(password, this.getPassword());
    }
    
    @Override
    public String validate(String name, String email, String password, boolean creating) {
        String text = null;
        Pattern name_regex = Pattern.compile("^[A-Za-z0-9]{3,50}");
        Pattern email_regex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Pattern password_regex = Pattern.compile("^[A-Za-z0-9]{8,50}");
        
        if(!name_regex.matcher(name).matches()){
            text = "EL NOMBRE DEBE SER ALFANUMERICO DE 3-50 CARACTERES";
        } else if(!email_regex.matcher(email).matches()) {
            text = "EL CORREO NO ES VALIDO";
        } else if (!password_regex.matcher(password).matches() && creating) {
            text = "LA CONTRASEÑA DEBE SER ALFANUMERICA DE 8-50 CARACTERES";
        }
        
        return text;
    }

    @Override
    public User create() throws SQLException, Exception {
        String query;
        if(!this.can_save) throw new Exception("Cannot save without arguments");
        
        if (!this.is_pristine) {
            query = "UPDATE "+this.table_name+" SET name = ?, email = ?, password = ? WHERE id = ?";
        } else {
            query = "INSERT INTO "+this.table_name+" VALUES (NULL, ?, ?, ?)";
        }
        
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, this.name);
        pstmt.setString(2, this.email);
        pstmt.setString(3, this.password);
        if(!this.is_pristine) {
            pstmt.setInt(4, this.id);
        }
        boolean save = pstmt.execute();
        this.getObjects().filter("email", email);
        User user = this.getObjects().execute().get(0);
        return user;
    }

    @Override
    public boolean delete() throws Exception {
        if(!this.can_save) throw new Exception("Cannot delete without arguments");
        String query = "DELETE FROM "+this.table_name+" WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, this.id);
        return pstmt.execute();
    }

   

}
