/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Nefonfo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.User;
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
public class UserControllerTest {
    
    public UserController controller = new UserController();
    
    @AfterClass
    @BeforeClass
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
    public void test_a_login() {
        User user;
        try {
            user = new User("Nefonfo", "victor@victor.com", "contrasena123");
            user.create();
        } catch (Exception ex) {
            fail("Error al crear el usuario");
        }
        
        assertTrue(this.controller.login("Nefonfo", "contrasena123"));
        assertFalse(this.controller.login("Nefonfo", "malacontrasena"));
        assertFalse(this.controller.login("mario", "contrasena123"));
    }
    
    @Test
    public void test_b_register() {
        assertEquals("Registrado Exitosamente", this.controller.register("Mariano", "sample@sample.com", "Sampllee123", "Sampllee123"));
        assertEquals("Las contraseñas no coinciden", this.controller.register("OWO", "sample@sample.com", "dsadassdasew", "Sampllee123"));
        assertEquals("El correo ya existe", this.controller.register("Uwu", "victor@victor.com", "Sampllee123", "Sampllee123"));
        assertEquals("Nombre de usuario ya existe", this.controller.register("Nefonfo", "victor@victdasor.com", "Sampllee123", "Sampllee123"));
        assertEquals("EL NOMBRE DEBE SER ALFANUMERICO DE 3-50 CARACTERES", this.controller.register("ww", "victor@321.com", "Sampllee123", "Sampllee123"));
        assertEquals("EL CORREO NO ES VALIDO", this.controller.register("wwdsasd", "victor321.com", "Sampllee123", "Sampllee123"));
        assertEquals("LA CONTRASEÑA DEBE SER ALFANUMERICA DE 8-50 CARACTERES", this.controller.register("wxgfw", "victor@321.com", "12", "12"));
    }
    
    @Test
    public void test_c_recover() {
        assertTrue(this.controller.recover_password("Nefonfo", "victor@victor.com"));
        assertFalse(this.controller.recover_password("Nefonfo", "victor@dsa.com"));
    }

    @Test
    public void test_d_update_email() throws Exception {
        
        User filter = new User();
        filter.getObjects().all();
        int id = filter.getObjects().execute().get(0).getId();
        
        assertEquals("El correo ya esta en uso", this.controller.update_email(id, "sample@sample.com"));
        assertEquals("EL CORREO NO ES VALIDO", this.controller.update_email(id, "samplesample.com"));
        assertEquals("Cambiado Correctamente", this.controller.update_email(id, "paquita@paquita.com"));
        
        try {
            User user = new User().getObjects().get(id);    
            assertEquals("paquita@paquita.com", user.email);
        }catch(Exception e) {
            fail("Error al obtener usuario");
        }
    }
    
    @Test
    public void test_e_update_name() throws Exception {
        
        User filter = new User();
        filter.getObjects().all();
        int id = filter.getObjects().execute().get(0).getId();
        
        assertEquals("El nombre ya esta en uso", this.controller.update_name(id, "Nefonfo"));
        assertEquals("EL NOMBRE DEBE SER ALFANUMERICO DE 3-50 CARACTERES", this.controller.update_name(id, "w"));
        assertEquals("Cambiado Correctamente", this.controller.update_name(id, "Paquita"));
        
        try {
            User user = new User().getObjects().get(id);    
            assertEquals("Paquita", user.name);
        }catch(Exception e) {
            fail("Error al obtener usuario");
        }
    }
    
    @Test
    public void test_f_update_password() throws Exception {
        
        User filter = new User();
        filter.getObjects().all();
        int id = filter.getObjects().execute().get(0).getId();
        
        assertEquals("Las contraseñas no coinciden", this.controller.update_password(id, "Saaaaa32", "eqwwq212"));
        assertEquals("LA CONTRASEÑA DEBE SER ALFANUMERICA DE 8-50 CARACTERES", this.controller.update_password(id, "w", "w"));
        assertEquals("Cambiado Correctamente", this.controller.update_password(id, "MonitaChina0w0", "MonitaChina0w0"));
        
        try {
            User user = new User().getObjects().get(id);    
            assertEquals("Paquita", user.name);
        }catch(Exception e) {
            fail("Error al obtener usuario");
        }
    }
    

}
