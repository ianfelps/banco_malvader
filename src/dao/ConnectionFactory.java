package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://localhost:3306/banco_malvader";
    private static final String usuario = "root";
    private static final String senha = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha); // Garante nova conexão
    }
    
}
