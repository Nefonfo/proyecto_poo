/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Homework;
import Model.User;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Nefonfo
 */

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeworkControllerTest {
    
    public HomeworkController controller = new HomeworkController();
    
    @BeforeClass
    public static void setup() throws Exception {

        
        Homework filter_hw = new Homework();
        filter_hw.getObjects().all();
        List<Homework> hws = filter_hw.getObjects().execute();
        
        for(Homework hw: hws){
            hw.delete();
        }
        
        User filter = new User();
        filter.getObjects().all();
        List<User> users = filter.getObjects().execute();
        
        for(User user: users) {
            user.delete();
        }
        
        User sample1 = new User("Nefonfo", "victor@victor.com", "sample12345");
        User sample2 = new User("Arpa", "arpa@arpa.com", "sample123");
        
        sample1.create();
        sample2.create();
    }
    
    
    @Test
    public void test_a_create() throws Exception {
        
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        
        assertEquals(
                this.controller.create_hw(100000, "dasdsad", "sdasdsaads", new Date()), 
                "El usuario al que se le quiere registrar la tarea no existe");
        
        assertEquals(
                this.controller.create_hw(user.getId(), "d", "sdasdsaads", new Date()), 
                "El nombre debe ser alfanumérico con espacios de 3-50 caracteres");
        
        assertEquals(
                this.controller.create_hw(user.getId(), "dedo", "sdasdsaads", new Date()), 
                "Creado exitosamente");
    }
    
    @Test
    public void test_b_get_my_homework() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        
        assertEquals(1, this.controller.get_all_user_homeworks(user.getId()).size());
        assertEquals(0, this.controller.get_all_user_homeworks(user2.getId()).size());
    }
    
    @Test
    public void test_c_get_homework() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        
        Homework hw = new Homework();
        hw.getObjects().filter("user_id", user.getId());
        hw = hw.getObjects().execute().get(0);
        assertEquals(hw.getId(), this.controller.get_homework(hw.getId(), user.getId()).getId());
    
    }
    
    
    @Test
    public void test_d_update_name() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        Homework hw = this.controller.get_all_user_homeworks(user.getId()).get(0);
       
        assertEquals(this.controller.update_name(hw.getId(), user2.getId(), "dsdasdadas"), "La tarea que desea actualizar es de otro usuario");
        assertEquals(this.controller.update_name(hw.getId(), user.getId(), "dsdasdadas"), "Actualizado correctamente");
    }
    
    @Test
    public void test_e_update_content() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        Homework hw = this.controller.get_all_user_homeworks(user.getId()).get(0);
       
        assertEquals(this.controller.update_content(hw.getId(), user2.getId(), "dsdasdadas"), "La tarea que desea actualizar es de otro usuario");
        assertEquals(this.controller.update_content(hw.getId(), user.getId(), "dsdasdadas"), "Actualizado correctamente");
    }
    
    @Test
    public void test_f_update_expires() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        Homework hw = this.controller.get_all_user_homeworks(user.getId()).get(0);
       
        assertEquals(this.controller.update_expires(hw.getId(), user2.getId(), new Date()), "La tarea que desea actualizar es de otro usuario");
        assertEquals(this.controller.update_expires(hw.getId(), user.getId(), new Date()), "Actualizado correctamente");
    }
    
    @Test
    public void test_g_delete_homework() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        Homework hw = this.controller.get_all_user_homeworks(user.getId()).get(0);
        hw.delete();
        
        assertEquals(0, this.controller.get_all_user_homeworks(user.getId()).size());
    }
    
}
