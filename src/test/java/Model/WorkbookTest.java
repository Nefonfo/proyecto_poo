/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
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
public class WorkbookTest {
    
    @BeforeClass
    public static void setup() throws Exception {

        
        Workbook filter_wb = new Workbook();
        filter_wb.getObjects().all();
        List<Workbook> wbs = filter_wb.getObjects().execute();
        
        Homework filter_hw = new Homework();
        filter_hw.getObjects().all();
        List<Homework> hws = filter_hw.getObjects().execute();
        
        for(Homework hw: hws) {
            hw.delete();
        }
        
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
    public void test_a_create() {
        try {
            User filter = new User();
            filter.getObjects().all();
            List<User> u = filter.getObjects().execute();
            
            User user = u.get(0);
            User user2 = u.get(1);
            Workbook wb = new Workbook(user.getId(), "Matematicas", "Realizar trabajo pag 46");
            Workbook created = wb.create();
            assertNotNull(created.getId());
            assertEquals(created.getUser_id(), user.getId());
            wb = new Workbook(user2.getId(), "Espanol", "Pag 20");
            created = wb.create();
            assertNotNull(created.getId());
            assertEquals(created.getUser_id(), user2.getId());
        }catch(Exception e) {
            e.printStackTrace();
            fail("Cannot create wb");
        }
    }
    
    @Test(expected = Exception.class)
    public void test_b_cannot_create() throws Exception {
        User user = new User().getObjects().get(1);
        Workbook wb = new Workbook(321321, "Matematicas", "Realizar trabajo pag 46");
        Workbook created = wb.create();
    }
    
    @Test
    public void test_c_find_all() {
        try {
            Workbook wb = new Workbook();
            wb.getObjects().all();
            List<Workbook> wbs = wb.getObjects().execute();
            assertEquals(wbs.size(), 2);
        } catch(Exception e) {
            e.printStackTrace();
            fail("Cannot find all wb");
        }
    }
    

    @Test
    public void test_d_filter(){
        try {
            User user = new User();
            user.getObjects().filter("name", "Nefonfo");
            
            user = user.getObjects().execute().get(0);
            
            Workbook filter = new Workbook();
            filter.getObjects().filter("user_id", user.getId());
            assertEquals(1, filter.getObjects().execute().size());
        }catch(Exception e) {
            e.printStackTrace();
            fail("Cannot filter wb");
        }
    }
    
    @Test
    public void test_e_find() {
        try {
            int id, id2;
            
            User filter = new User();
            filter.getObjects().all();
            List<User> u = filter.getObjects().execute();
            
            Workbook filter_wb = new Workbook();
            filter_wb.getObjects().filter("user_id", u.get(0).getId());
            id = filter_wb.getObjects().execute().get(0).getId();
            
            filter_wb.getObjects().filter("user_id", u.get(1).getId());
            id2 = filter_wb.getObjects().execute().get(0).getId();
            
            Workbook wb = new Workbook().getObjects().get(id);
            Workbook wb2 = new Workbook().getObjects().get(id2);

            assertEquals(wb.name, "Matematicas");
            assertEquals(wb2.name, "Espanol");
        }catch(Exception e) {
            e.printStackTrace();
            fail("Cannot find one wb");
        }
    }
    
    @Test
    public void test_f_delete() {
    
        try {
            User user = new User(); 
            user.getObjects().filter("name", "Arpa");
            user = user.getObjects().execute().get(0);

            Workbook wb = new Workbook();
            wb.getObjects().filter("user_id", user.getId());
            wb = wb.getObjects().execute().get(0);
            wb.delete();

            wb.getObjects().filter("user_id", user.getId());
            List<Workbook> hws = wb.getObjects().execute();
            assertEquals(hws.size(), 0);
        } catch(Exception e) {
            e.printStackTrace();
            fail("Cannot delete wb");
        }
    }
    
}
