package dao;

import java.sql.*;
import java.time.LocalDate;

import models.*;

public class ClienteDAO {

    private static String sql;

    public Cliente getUser(String senha) {
        setSql("SELECT * FROM usuarios WHERE senha = ?");
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionFactory.getConnection()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, senha);

            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("data_nascimento");
                String telefone = rs.getString("telefone");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);

                return new Cliente(id, nome, cpf, telefone, senha, true);
            }
            return new Cliente(0, "", "", "", null, false);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Cliente(0, "", "", "", null, false);
        }
    }

    public static void setSql(String sql) {
        ClienteDAO.sql = sql;
    }

    public static String getSql() {
        return sql;
    }
}
