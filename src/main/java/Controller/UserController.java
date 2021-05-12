/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import IController.IUserController;
import Model.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nefonfo
 */
public class UserController implements IUserController<User> {

    @Override
    public boolean login(String user, String password) {
        User filter = new User();
        boolean passed;
        try{
            filter.getObjects().filter("name", user);
            List<User> get_user = filter.getObjects().execute();
            passed = (get_user.size() == 1) && (get_user.get(0).compare_password(password));
        } catch(Exception e ){
            String eee = e.toString();
            passed = false;
        }
        
        return passed;
    }

    @Override
    public String register(String name, String email, String password, String cpassword) {
        String info;

        
        if(password.equals(cpassword)) {
            User by_name = new User();
            User by_email = new User();
            
            try {
                
                by_name.getObjects().filter("name", name);
                by_email.getObjects().filter("email", email);
                if(by_name.getObjects().execute().size() > 0) {
                    info = "Nombre de usuario ya existe";
                } else if(by_email.getObjects().execute().size() > 0) {
                    info = "El correo ya existe";
                } else {
                    
                    try {
                        User create_user = new User(name, email, password);

                        if(create_user.create() != null) {
                            info = "Registrado Exitosamente";
                        } else {
                            info = "Usuario no creado";
                        }
                    } catch (Exception ex) {
                        info = ex.getMessage();
                    }
                    
                }
            }catch(Exception e) {
                info = "Error, intente más tarde";
            }
        } else {
            info = "Las contraseñas no coinciden";
        }
        
        return info;
    }

    @Override
    public boolean recover_password(String name, String email) {
        boolean can_recover;
        User filter = new User();
        try {
            filter.getObjects().filter("name", name);
            can_recover = filter.getObjects().execute().get(0).email.equals(email);
        } catch (Exception ex) {
            can_recover = false;
        }
        
        return can_recover;
    }

    @Override
    public String update_email(int id, String email) {
        String message;
        try{
            User get_user = new User().getObjects().get(id);
            
            User filter = new User();
            filter.getObjects().filter("email", email);
            boolean is_unique = filter.getObjects().execute().isEmpty();
            String validation = get_user.validate(get_user.name, email, get_user.getPassword(), false);
            
            if(validation == null && is_unique) {
                get_user.email = email;
                get_user.create();
                message = "Cambiado Correctamente";
            } else {
                message = (validation == null) ? "El correo ya esta en uso": validation;
            }
        }catch(Exception e) {
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public String update_name(int id, String name) {
        String message;
        try{
            User get_user = new User().getObjects().get(id);
            
            User filter = new User();
            filter.getObjects().filter("name", name);
            boolean is_unique = filter.getObjects().execute().isEmpty();
            String validation = get_user.validate(name, get_user.email, get_user.getPassword(), false);
            
            if(validation == null && is_unique) {
                get_user.name = name;
                get_user.create();
                message = "Cambiado Correctamente";
            } else {
                message = (validation == null) ? "El nombre ya esta en uso": validation;
            }
        }catch(Exception e) {
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public String update_password(int id, String password, String cpassword) {
        String message;
        if(password.equals(cpassword)){
            try{
                User get_user = new User().getObjects().get(id);

                String validation = get_user.validate(get_user.name, get_user.email, password, true);

                if(validation == null) {
                    get_user.setPassword(password);
                    get_user.create();
                    message = "Cambiado Correctamente";
                } else {
                    message = validation;
                }
            }catch(Exception e) {
                message = e.getMessage();
            }
        } else {
          message = "Las contraseñas no coinciden";  
        }
        
        return message;
    }

    @Override
    public User get_user_by_name(String name) {
        User user;
        User filter;
        try {
            filter = new User();
            filter.getObjects().filter("name", name);
            user = filter.getObjects().execute().get(0);
        } catch(Exception e) {
            user = null;
        }
        
        return user;
    }

    @Override
    public User get_user_by_id(int id) {
        User user;
        try {
            user = new User().getObjects().get(id);
        }catch(Exception e){ 
            user = null;
        }
        
        return user;
    }
    
    
    
}
