/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Db.Database;
import Manager.HomeworkManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Nefonfo
 */
public class Homework implements IModel<Homework, HomeworkManager>{
    
    private Connection conn;
    
    private int id;
    private int user_id;
    public String name;
    public String content;
    private Date expires;
    
    private final HomeworkManager objects = new HomeworkManager();
    private final String table_name = "Homework";
    private boolean can_save;
    private boolean is_pristine;
    
    public Homework() {
        this.can_save = false;
    }
    
    public Homework(int id, int user_id, String name, String content, String expires) throws Exception {
       
        this.can_save = true;
        this.is_pristine = false;
        
        String validation = this.validate(user_id, name, content, expires);
        if(validation != null) {
            throw new Exception(validation);
        }
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.content = content;
        this.setExpires(expires);
        
        this.conn = Database.getConnection();
    }

    public Homework(int user_id, String name, String content, Date expires) throws Exception {

        this.can_save = true;
        this.is_pristine = true;
        
        String validation = this.validate(user_id, name, content, expires);
        if(validation != null) {
            throw new Exception(validation);
        }
        
        this.user_id = user_id;
        this.name = name;
        this.content = content;
        this.expires = expires;
        
        this.conn = Database.getConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(String expires) throws ParseException {
        this.expires = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expires);
    }
    
    public void setExpires(Date expires) {
        this.expires = expires;
    }
    
    public String validate(int user_id, String name, String content, Object expires) throws Exception {
        String response = null;
        Pattern name_validation = Pattern.compile("^[A-Za-z0-9 ]{3,50}");
        
        User user = new User().getObjects().get(user_id);
        if(user == null && this.is_pristine) {
            response = "El usuario al que se le quiere registrar la tarea no existe";
        } else if(!name_validation.matcher(name).matches()) {
            response = "El nombre debe ser alfanumérico con espacios de 3-50 caracteres";
        }
        
        if(!(expires instanceof Date)) {
            try {
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) expires);
            } catch(ParseException e) {
                response = "La fecha esta corrompida";
            }
        }
        
        return response;
    }

    @Override
    public HomeworkManager getObjects() {
        return this.objects;
    }

    @Override
    public Homework create() throws SQLException, Exception {
        String query;
        Homework hw;
        if(!this.can_save) throw new Exception("Cannot save without arguments");
        
        if (!this.is_pristine) {
            query = "UPDATE "+this.table_name+" SET user_id = ?, name = ?, content = ?, expires = ? WHERE id = ?";
        } else {
            query = "INSERT INTO "+this.table_name+" VALUES (NULL, ?, ?, ?, ?)";
        }
        PreparedStatement pstmt = this.conn.prepareStatement(query, new String[]{"id"});
        pstmt.setInt(1, this.user_id);
        pstmt.setString(2, this.name);
        pstmt.setString(3, this.content);
        pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expires));
        if(!this.is_pristine) {
            pstmt.setInt(5, this.id);
        }
        pstmt.execute();
        int row_id = 0;
        if(this.is_pristine) {
            try (ResultSet res = pstmt.getGeneratedKeys()){
                if(res.next()){ 
                    long sample = res.getLong(1);
                    row_id = (int) sample;
                    
                } else {
                    hw = null;
                }
            } catch(Exception e) {
                hw = null;
            } 
        } else {
            row_id = this.id;
        }
        hw = this.getObjects().get(row_id);
        return hw;
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
