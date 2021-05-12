/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IManager;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nefonfo
 * @param <T>
 */
public interface IManager<T> {
    public T get(int id) throws SQLException, Exception;
    public void all();
    public void filter(String key, Object value) throws Exception;
    public List<T> execute() throws Exception;
}
