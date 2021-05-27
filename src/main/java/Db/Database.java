package Db;

import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Connection conn = null;
    private String dir;

    public Database() {
        this.dir = System.getProperty("user.dir") + "\\src\\main\\resources";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:javasample.db");
            conn.createStatement().executeQuery("SELECT * FROM User;");
        } catch(SQLException e){
            try {
                Connection connhelp = DriverManager.getConnection("jdbc:sqlite:javasample.db");
                ScriptRunner runner = new ScriptRunner(connhelp, false, false);
                runner.runScript(new BufferedReader(new FileReader(this.dir+"\\database.sql")));
                new Database();
            } catch(Exception i) {
                System.out.println("ERROR CRITICO");
                i.printStackTrace();
            }
        }
    }

    public static Connection getConnection(){
        if(conn == null) {
            new Database();
        }

        return conn;
    }

    public static void killConection() throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }

    
}