/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;

/**
 *
 * @author Nefonfo
 * @param <T, O>
 */
public interface IModel<T, O> {
    public O getObjects();
    public T create() throws SQLException, Exception;
    public boolean delete() throws Exception;
}
