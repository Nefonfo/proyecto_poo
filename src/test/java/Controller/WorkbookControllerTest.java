/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.Workbook;
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
public class WorkbookControllerTest {
    
    public WorkbookController controller = new WorkbookController();
    
    @BeforeClass
    public static void setup() throws Exception {

        
        Workbook filter_wb = new Workbook();
        filter_wb.getObjects().all();
        List<Workbook> wbs = filter_wb.getObjects().execute();
        
        for(Workbook wb: wbs){
            wb.delete();
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
                this.controller.create_wb(100000, "dasdsad", "sdasdsaads"), 
                "El usuario al que se le quiere registrar la libreta no existe");
        
        assertEquals(
                this.controller.create_wb(user.getId(), "d", "sdasdsaads"), 
                "El nombre debe ser alfanumérico con espacios de 3-50 caracteres");
        
        assertEquals(
                this.controller.create_wb(user.getId(), "dedo", "sdasdsaads"), 
                "Creado exitosamente");
    }
    
    @Test
    public void test_b_get_my_workbook() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        
        assertEquals(1, this.controller.get_all_user_workbooks(user.getId()).size());
        assertEquals(0, this.controller.get_all_user_workbooks(user2.getId()).size());
    }
    
    @Test
    public void test_c_get_homework() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        
        Workbook wb = new Workbook();
        wb.getObjects().filter("user_id", user.getId());
        wb = wb.getObjects().execute().get(0);
        assertEquals(wb.getId(), this.controller.get_workbook(wb.getId(), user.getId()).getId());
    
    }
    
    
    @Test
    public void test_d_update_name() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        Workbook wb = this.controller.get_all_user_workbooks(user.getId()).get(0);
       
        assertEquals(this.controller.update_name(wb.getId(), user2.getId(), "dsdasdadas"), "La libreta que desea actualizar es de otro usuario");
        assertEquals(this.controller.update_name(wb.getId(), user.getId(), "dsdasdadas"), "Actualizado correctamente");
    }
    
    @Test
    public void test_e_update_content() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        User user2 = user_controller.get_user_by_name("Arpa");
        Workbook wb = this.controller.get_all_user_workbooks(user.getId()).get(0);
       
        assertEquals(this.controller.update_content(wb.getId(), user2.getId(), "dsdasdadas"), "La libreta que desea actualizar es de otro usuario");
        assertEquals(this.controller.update_content(wb.getId(), user.getId(), "dsdasdadas"), "Actualizado correctamente");
    }
    
    @Test
    public void test_f_delete_homework() throws Exception {
        UserController user_controller = new UserController();
        User user = user_controller.get_user_by_name("Nefonfo");
        Workbook wb = this.controller.get_all_user_workbooks(user.getId()).get(0);
        wb.delete();
        
        assertEquals(0, this.controller.get_all_user_workbooks(user.getId()).size());
    }
    
}
