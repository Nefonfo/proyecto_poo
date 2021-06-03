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
public class HomeworkTest {
    
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
            Homework hw = new Homework(user.getId(), "Matematicas", "Realizar trabajo pag 46", new Date());
            Homework created = hw.create();
            assertNotNull(created.getId());
            assertEquals(created.getUser_id(), user.getId());
            hw = new Homework(user2.getId(), "Espanol", "Pag 20", new Date());
            created = hw.create();
            assertNotNull(created.getId());
            assertEquals(created.getUser_id(), user2.getId());
        }catch(Exception e) {
            fail("Cannot create hw");
        }
    }
    
    @Test(expected = Exception.class)
    public void test_b_cannot_create() throws Exception {
        Homework hw = new Homework(321321, "Matematicas", "Realizar trabajo pag 46", new Date());
        hw.create();
    }
    
    @Test
    public void test_c_find_all() {
        try {
            Homework hw = new Homework();
            hw.getObjects().all();
            List<Homework> hws = hw.getObjects().execute();
            assertEquals(hws.size(), 2);
        } catch(Exception e) {
            fail("Cannot find all hw");
        }
    }
    

    @Test
    public void test_d_filter(){
        try {
            User user = new User();
            user.getObjects().filter("name", "Nefonfo");
            
            user = user.getObjects().execute().get(0);
            
            Homework filter = new Homework();
            filter.getObjects().filter("user_id", user.getId());
            assertEquals(1, filter.getObjects().execute().size());
        }catch(Exception e) {
            fail("Cannot filter hw");
        }
    }
    
    @Test
    public void test_e_find() {
        try {
            int id, id2;
            
            User filter = new User();
            filter.getObjects().all();
            List<User> u = filter.getObjects().execute();
            
            Homework filter_hw = new Homework();
            filter_hw.getObjects().filter("user_id", u.get(0).getId());
            id = filter_hw.getObjects().execute().get(0).getId();
            
            filter_hw.getObjects().filter("user_id", u.get(1).getId());
            id2 = filter_hw.getObjects().execute().get(0).getId();
            
            Homework hw = new Homework().getObjects().get(id);
            Homework hw2 = new Homework().getObjects().get(id2);

            assertEquals(hw.name, "Matematicas");
            assertEquals(hw2.name, "Espanol");
        }catch(Exception e) {
            fail("Cannot find one hw");
        }
    }
    
    @Test
    public void test_f_delete() {
    
        try {
            User user = new User(); 
            user.getObjects().filter("name", "Arpa");
            user = user.getObjects().execute().get(0);

            Homework hw = new Homework();
            hw.getObjects().filter("user_id", user.getId());
            hw = hw.getObjects().execute().get(0);
            hw.delete();

            hw.getObjects().filter("user_id", user.getId());
            List<Homework> hws = hw.getObjects().execute();
            assertEquals(hws.size(), 0);
        } catch(Exception e) {
            fail("Cannot delete hw");
        }
    }
    
}
