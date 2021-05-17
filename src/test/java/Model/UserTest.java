/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.User;
import java.io.File;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
/**
 *
 * @author Nefonfo
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
    
    @BeforeClass
    @AfterClass
    public static void setup() throws Exception {
        User filter = new User();
        filter.getObjects().all();
        List<User> users = filter.getObjects().execute();
        
        for(User user: users) {
            user.delete();
        }
        
        filter.getObjects().all();
        assertEquals(0, filter.getObjects().execute().size());
    }
    
    @Test
    public void test_a_create() {
        try {
            User user = new User("nefo", "victor@gmail.com", "Asterisk321");
            User user_2 = new User("arpa", "arpa@gmail.com", "SaMPLE1234");
            User created_user = user.create();
            User created_user_2 = user_2.create();
            assertNotNull(created_user.getId());
            assertNotNull(created_user_2.getId());
            
        } catch(Exception e) {
            e.printStackTrace();
            fail("Cannot Create user");
        }
    }
    
    @Test(expected = Exception.class)
    public void test_b_cannot_create() throws Exception {
        User user = new User("dsadasdas", "victor@gmail.com", "Asterisk321");
        user.create();
    }
    
    @Test
    public void test_c_find_all() {
        try {
            User user_manager = new User();
            user_manager.getObjects().all();
            List<User> users = user_manager.getObjects().execute();
            assertEquals(users.size(), 2);
        }catch(Exception e) {
            e.printStackTrace();
            fail("Cannot find user");
        }
    }
    
    @Test
    public void test_d_find() {
        try {
            User user = new User().getObjects().get(2);
            assertNotNull(user);
        }catch(Exception e) {
            e.printStackTrace();
            fail("Cannot find user");
        }
    }
    
    @Test
    public void test_e_filter() {
        User filter = new User();
        try {
            filter.getObjects().filter("name", "nefo");
            assertEquals(filter.getObjects().execute().get(0).name, "nefo");
        } catch(Exception e) {
            e.printStackTrace();
            fail("Cannot filter users");
        }
    }
    
    @Test
    public void test_f_delete() {
        User filter = new User();
        try {
            filter.getObjects().filter("name", "nefo");
            User going_to_delete = filter.getObjects().execute().get(0);
            assertEquals(going_to_delete.name, "nefo");
            going_to_delete.delete();
            
            filter.getObjects().filter("name", "nefo");
            assertEquals(filter.getObjects().execute().size(), 0);
        } catch(Exception e) {
            e.printStackTrace();
            fail("Cannot filter users");
        }
    }
  
    
}
