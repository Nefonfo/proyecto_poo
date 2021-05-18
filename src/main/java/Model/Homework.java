/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Db.Database;
import Manager.HomeworkManager;
import java.sql.Connection;
import java.sql.SQLException;
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
        
        
        this.conn = Database.getConnection();
    }

    public Homework(int user_id, String name, String content, Date expires) throws Exception {
        
        this.can_save = true;
        this.is_pristine = true;
        
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

    public void setExpires(Date expires) {
        this.expires = expires;
    }
    
    public String validate(int user_id, String name, String content, Object expires) throws Exception {
        String response = null;
        Pattern name_validation = Pattern.compile("");
        
        User user = new User().getObjects().get(user_id);
        if(user.name == null) {
            response = "El usuario al que se le quiere registrar la tarea no existe";
        } else if(!name_validation.matcher(name).matches()) {
            response = "El nombre debe ser de al menos 3 caracteres";
        }
        
        if(!(expires instanceof Date)) {
            
        }
        
        return response;
    }

    @Override
    public HomeworkManager getObjects() {
        return this.objects;
    }

    @Override
    public Homework create() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
