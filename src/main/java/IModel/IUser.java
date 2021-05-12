/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import java.sql.SQLException;

/**
 *
 * @author Nefonfo
 * @param <T, O>
 */
public interface IUser<T, O> {
    public O getObjects();
    public boolean compare_password(String password);
    public String validate(String name, String email, String password, boolean creating);
    public T create() throws SQLException, Exception;
    public boolean delete() throws Exception;
}
