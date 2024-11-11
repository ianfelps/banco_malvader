package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://localhost:3306/banco_malvader";
    private static final String usuario = "root";
    private static final String senha = "";

    private static Connection conn;

        public static Connection getConnection(){
            try{
                if(conn == null) {
                 conn = DriverManager.getConnection(url, usuario, senha);
                 return conn;
                }
                else{
                    return conn;
                }
            }
            catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        
    }
    
}
