/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Homework;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nefonfo
 */
public class HomeworkController {
    
    public String create_hw(int user_id, String name, String content, Date expires){
        String message;
       try {
           Homework homework = new Homework(user_id, name, content, expires);
           homework = homework.create();
           if(homework != null) {
               message = "Creado exitosamente";
           } else {
               message = "Error al crear";
           }
       } catch(Exception e) {
           message = e.getMessage();
       }
       
       return message;
    
    }
    
    public List<Homework> get_all_user_homeworks(int user_id) throws Exception{
    
        Homework filter = new Homework();
        filter.getObjects().filter("user_id", user_id);
        return filter.getObjects().execute();
        
    }
    
    public Homework get_homework(int id, int user_id) throws Exception{
    
        Homework homework = new Homework().getObjects().get(id);
        
        if(homework.getUser_id() != user_id) {
            homework = null;
        }
        
        return homework;
        
    }
    
    public String update_name(int id, int user_id, String new_name) throws Exception{
        String message = "";
        Homework homework = new Homework().getObjects().get(id);
        if(homework.getUser_id() == user_id) {
            homework.name = new_name;
            try {
                homework = homework.create();
                if(homework.name.equals(new_name)){ 
                    message = "Actualizado correctamente";
                } else {
                    message = "No se ha logrado actualizar";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        } else {
            message = "La tarea que desea actualizar es de otro usuario";
        }
        
        return message;
        
    }
    
    public String update_content(int id, int user_id, String new_content) throws Exception{
        String message = "";
        Homework homework = new Homework().getObjects().get(id);
        if(homework.getUser_id() == user_id) {
            homework.content = new_content;
            try {
                homework = homework.create();
                if(homework.content.equals(new_content)){ 
                    message = "Actualizado correctamente";
                } else {
                    message = "No se ha logrado actualizar";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        } else {
            message = "La tarea que desea actualizar es de otro usuario";
        }
        
        return message;
    }
    
    public String update_expires(int id, int user_id, Date new_date) throws Exception{
        String message = "";
        Homework homework = new Homework().getObjects().get(id);
        if(homework.getUser_id() == user_id) {
            homework.setExpires(new_date);
            try {
                homework = homework.create();
                
                Date date = homework.getExpires();
                if(date.toString().equals(new_date.toString())){ 
                    message = "Actualizado correctamente";
                } else {
                    message = "No se ha logrado actualizar";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        } else {
            message = "La tarea que desea actualizar es de otro usuario";
        }
        
        return message;
    }
    
    public String delete_hw(int id, int user_id) throws Exception{
    
        String message = "";
        
        Homework homework = new Homework().getObjects().get(id);
        if(homework.getUser_id() == user_id){
            homework.delete();
            homework = new Homework().getObjects().get(id);
            if(homework == null) {
                message = "Borrado correctamente";
            } else {
                message = "Error al Borrar";
            }
        } else {
            message = "No se puede borrar una tarea de otro usuario";
        }
        
        return message;
    
    }
    
}
