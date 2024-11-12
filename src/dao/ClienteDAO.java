package dao;

import java.sql.*;
import java.util.Optional;
import models.Cliente;

public class ClienteDAO {

    private static String sql;

    public Optional<Cliente> getUser(String senha) {
        setSql("SELECT * FROM usuarios WHERE senha = ?");

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, senha);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    int id = rs.getInt("id_usuario");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String cpf = rs.getString("cpf");
                    Date dataNascimento = rs.getDate("data_nascimento");
                    String telefone = rs.getString("telefone");

                    System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);

                    return Optional.of(new Cliente(id, nome, cpf, telefone, senha, true));
                } else {
                    System.out.println("Nenhum usuario encontrado.");
                    return Optional.empty();
                }

            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar os dados: " + e.getMessage());
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static void setSql(String sql) {
        ClienteDAO.sql = sql;
    }

    public static String getSql() {
        return sql;
    }
}
