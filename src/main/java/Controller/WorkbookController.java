/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Workbook;
import java.util.List;

/**
 *
 * @author Nefonfo
 */
public class WorkbookController {
    
    public String create_wb(int user_id, String name, String content){
        String message;
       try {
           Workbook workbook = new Workbook(user_id, name, content);
           workbook = workbook.create();
           if(workbook != null) {
               message = "Creado exitosamente";
           } else {
               message = "Error al crear";
           }
       } catch(Exception e) {
           message = e.getMessage();
       }
       
       return message;
    
    }
    
    public List<Workbook> get_all_user_workbooks(int user_id) throws Exception{
    
        Workbook filter = new Workbook();
        filter.getObjects().filter("user_id", user_id);
        return filter.getObjects().execute();
        
    }
    
    public Workbook get_workbook(int id, int user_id) throws Exception{
    
        Workbook workbook = new Workbook().getObjects().get(id);
        
        if(workbook.getUser_id() != user_id) {
            workbook = null;
        }
        
        return workbook;
        
    }
    
    public String update_name(int id, int user_id, String new_name) throws Exception{
        String message = "";
        Workbook workbook = new Workbook().getObjects().get(id);
        if(workbook.getUser_id() == user_id) {
            workbook.name = new_name;
            try {
                workbook = workbook.create();
                if(workbook.name.equals(new_name)){ 
                    message = "Actualizado correctamente";
                } else {
                    message = "No se ha logrado actualizar";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        } else {
            message = "La libreta que desea actualizar es de otro usuario";
        }
        
        return message;
        
    }
    
    public String update_content(int id, int user_id, String new_content) throws Exception{
        String message = "";
        Workbook workbook = new Workbook().getObjects().get(id);
        if(workbook.getUser_id() == user_id) {
            workbook.content = new_content;
            try {
                workbook = workbook.create();
                if(workbook.content.equals(new_content)){ 
                    message = "Actualizado correctamente";
                } else {
                    message = "No se ha logrado actualizar";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        } else {
            message = "La libreta que desea actualizar es de otro usuario";
        }
        
        return message;
    }
    
    public String delete_wb(int id, int user_id) throws Exception{
    
        String message = "";
        
        Workbook workbook = new Workbook().getObjects().get(id);
        if(workbook.getUser_id() == user_id){
            workbook.delete();
            workbook = new Workbook().getObjects().get(id);
            if(workbook == null) {
                message = "Borrado correctamente";
            } else {
                message = "Error al Borrar";
            }
        } else {
            message = "No se puede borrar la libreta de otro usuario";
        }
        
        return message;
    
    }
    
}
