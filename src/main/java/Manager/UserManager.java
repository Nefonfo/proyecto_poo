/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Db.Database;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

/**
 *
 * @author Nefonfo
 */
public class UserManager implements IManager<User> {
    
    private String query;
    private final String table_name = "User";
    private final Connection conn;
    
    private Map<String, Object> query_values = new HashMap<String, Object>();;
    private final Map<String, String> valid_values = Map.ofEntries(
            entry("id", "Integer"),
            entry("name", "String"),
            entry("email", "String")
    );
    
    public UserManager() {
        this.query = "";
        this.conn = Database.getConnection();
    }
    
    @Override
    public User get(int id) throws SQLException, Exception {
        User query_user = null;
        this.query = "SELECT * FROM "+this.table_name+" WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(this.query);
        pstmt.setInt(1, id);
        ResultSet res = pstmt.executeQuery();
        if(res.next()) {
            query_user = new User(
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("email"),
                        res.getString("password"));
        }
        this.query = null;
        this.query_values = null;
        return query_user;
    }

    @Override
    public void all() {
        this.query = "SELECT * FROM "+this.table_name+"";
    }

    @Override
    public void filter(String key, Object value) throws Exception {
        boolean valid = false;
        boolean first_time;
        
        if(!this.query.contains("WHERE")) {
            this.query = "SELECT * FROM "+this.table_name+" WHERE ";
            first_time = true;
        } else {
            this.query = this.query + " ";
            first_time = false;
        }
        
        for(Map.Entry<String, String> valid_value: this.valid_values.entrySet()) {
                if(key.equals(valid_value.getKey())) {
                    valid = true;
                    break;
                }
        }
        
        if(!valid) {
                this.query = null;
                throw new Exception("The filter key is not valid: " + key);
        } else {
            this.query_values.put(key, value);
            this.query += (!first_time ? ", ": "") + key + " = ? ";
        }
        
    }

    @Override
    public List<User> execute() throws Exception{
        this.query += ";";
        List<User> users = new ArrayList<>();
        PreparedStatement pstmt = this.conn.prepareStatement(this.query);
        int loop = 1;

        if(!this.query.isEmpty()) {
            for(Map.Entry<String, Object> query: this.query_values.entrySet()) {
                String value = this.valid_values.get(query.getKey());
                if(value.equals("String")) {
                    pstmt.setString(loop, (String)query.getValue());
                } else if(value.equals("Integer")) {
                    pstmt.setInt(loop, (Integer)query.getValue());
                }
                loop++;
            }
        }
        
        ResultSet res = pstmt.executeQuery();
        while(res.next()) {
            users.add(
                new User(
                res.getInt("id"),
                res.getString("name"),
                res.getString("email"),
                res.getString("password"))
            );
        }
        return users;
    }
    
}
