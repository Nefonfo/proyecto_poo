package App;


import Controller.HomeworkController;
import Controller.UserController;
import Model.User;
import View.User.WelcomeView;
import java.util.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nefonfo
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new WelcomeView().setVisible(true);
    }
    
}
