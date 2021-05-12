/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IController;

/**
 *
 * @author Nefonfo
 */
public interface IUserController<T> {
    public boolean login(String user, String password);
    public String register(String name, String email, String password, String cpassword);
    public boolean recover_password(String name, String email);
    public String update_email(int id, String email);
    public String update_name(int id, String name);
    public String update_password(int id, String password, String cpassword);
    public T get_user_by_name(String name);
    public T get_user_by_id(int id);
}
