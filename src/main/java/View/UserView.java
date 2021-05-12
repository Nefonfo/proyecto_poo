/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserController;
import IView.IUserView;
import Model.User;
import java.util.Scanner;

/**
 *
 * @author Nefonfo
 */
public class UserView implements IUserView {
    
    private final Scanner sc;
    private final UserController controller;
    
    public UserView() {
        this.controller = new UserController();
        this.sc = new Scanner(System.in);
        this.welcome();
    }
    
    @Override
    public void clear_window() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    @Override
    public void welcome() {
        int menu;
        this.clear_window();
        System.out.println("--------- BIENVENIDO AL SISTEMA ---------");
        System.out.println("ESCRIBA EL NUMERO DE OPCIÓN QUE DESEA");
        System.out.println("1 - INICIAR SESIÓN");
        System.out.println("2 - REGISTRARSE");
        System.out.println("3 - RECUPERAR CONTRASEÑA");
        System.out.println("Cualquier otra cosa - SALIR");
        try {
            menu = this.sc.nextInt();
            this.sc.nextLine();
            switch(menu) {
                case 1 -> this.login(null);

                case 2 -> this.register();

                case 3 -> this.recover_step_1();

                default -> System.exit(0);
            }
        } catch(Exception e){ 
            this.welcome();
        }
    }

    @Override
    @SuppressWarnings("InfiniteRecursion")
    public void login(String error) {
        String name;
        String password;
        int return_menu;
        
        this.clear_window();
        
  
        if(error != null) {
            System.out.println(error);
            System.err.println("¿DESEA REGRESAR AL MENU PRINCIPAL? PRESIONE 1 SI NO CUALQUIER NUMERO");
            return_menu = this.sc.nextInt();
            this.sc.nextLine();
            if(return_menu == 1) this.welcome();
        }
        System.out.println("--------- LOGIN ---------");
        System.out.println("INGRESE SU USUARIO:");
        name = this.sc.nextLine();
        System.out.println("INGRESE SU CONTRASEÑA");
        password = this.sc.nextLine();
        if(this.controller.login(name, password)) {
            this.profile_menu(this.controller.get_user_by_name(name).getId());
        } else {
            this.login("Usuario o contraseña incorrectos");
        }

    }

    @Override
    public void register() {
        String name;
        String email;
        String password;
        String cpassword;
        String response;
        
        System.out.println("--------- REGISTRO ---------");
        System.out.println("INGRESE SU USUARIO:");
        name = this.sc.nextLine();
        System.out.println("INGRESE SU CORREO");
        email = this.sc.nextLine();
        System.out.println("INGRESE SU CONTRASEÑA");
        password = this.sc.nextLine();
        System.out.println("CONFIRME SU CONTRASEÑA");
        cpassword = this.sc.nextLine();
        
        response = this.controller.register(name, email, password, cpassword);
        System.err.println(response);
        this.welcome();
    }

    @Override
    public void recover_step_1() {
        String name;
        String email;
        System.out.println("--------- RECUPERAR CUENTA ---------");
        System.out.println("INGRESE SU NOMBRE DE USUARIO");
        name = this.sc.nextLine();
        System.out.println("INGRESE SU CORREO");
        email = this.sc.nextLine();
        if(this.controller.recover_password(name, email)) {
            this.recover_step_2(this.controller.get_user_by_name(name).getId());
        } else {
            System.err.println("No se encontro usuario con ese correo y contraseña");
        }
    }

    @Override
    public void recover_step_2(int id) {
        String password;
        String cpassword;
        System.out.println("--------- RECUPERAR CUENTA PASO 2 ---------");
        System.out.println("INGRESE SU CONTRASEÑA NUEVA");
        password = this.sc.nextLine();
        System.out.println("CONFIRME SU CONTRASEÑA");
        cpassword = this.sc.nextLine();
        System.err.println(this.controller.update_password(id, password, cpassword));
        this.welcome();
    }

    @Override
    public void profile_menu(int id) {
        int menu;
        
        User user = this.controller.get_user_by_id(id);
        System.out.println("--------- BIENVENIDO ---------");
        System.out.println("USUARIO: "+user.name);
        System.out.println("CORREO: "+user.email);
        
        System.out.println("--------- MENU DE PERFIL ---------");
        System.out.println("1 - ACTUALIZAR USUARIO");
        System.out.println("2 - ACTUALIZAR CORREO");
        System.out.println("3 - ACTUALIZAR CONTRASEÑA");
        System.err.println("4 - LOGOUT");
        menu = this.sc.nextInt();
        this.sc.nextLine();
        switch(menu) {
            case 1 -> this.update(user.getId(), menu);
            case 2 -> this.update(user.getId(), menu);
            case 3 -> this.update(user.getId(), menu);
            case 4 -> this.welcome();
        }
    }

    @Override
    public void update(int id, int type) {
        String value;
        String cvalue;
        switch(type) {
            case 1:
                System.out.println("Ingrese el nuevo usuario");
                value = this.sc.nextLine();
                System.out.println(this.controller.update_name(id, value));
                break;
            
            case 2:
                System.out.println("Ingrese el nuevo correo");
                value = this.sc.nextLine();
                System.out.println(this.controller.update_email(id, value));
                break;
                
            case 3:
                System.out.println("Ingrese la contraseña");
                value = this.sc.nextLine();
                System.out.println("Confirme la contraseña");
                cvalue = this.sc.nextLine();
                System.out.println(this.controller.update_password(id, value, cvalue));
                break;
                
        }
        
        this.profile_menu(id);
    }
    
}
