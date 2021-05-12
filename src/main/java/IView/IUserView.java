/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

/**
 *
 * @author Nefonfo
 */
public interface IUserView {
    public void clear_window();
    public void welcome();
    public void login(String error);
    public void register();
    public void recover_step_1();
    public void recover_step_2(int id);
    public void profile_menu(int id);
    public void update(int id, int type);
}
