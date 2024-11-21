package dao;

import java.sql.*;
import java.util.Optional;
import models.Cliente;

import utils.DBUtils;

public class FuncionarioDAO {

    private static String sql;

    public Optional<Cliente> getUser(String email, String senha) {
        setSql("SELECT * FROM usuario WHERE email = ?");

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    String senhaQuery = rs.getString("senha");

                    if(senhaQuery.equals(senha)){
                        int id = rs.getInt("id_usuario");
                        String nome = rs.getString("nome");
                        String cpf = rs.getString("cpf");
                        Date dataNascimento = rs.getDate("data_nascimento");
                        String telefone = rs.getString("telefone");
                        String tipoUser = rs.getString("tipo_usuario");

                        if(tipoUser.equals("funcionario")){
                            System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
                            return Optional.of(new Cliente(id, nome, email, cpf, telefone, senhaQuery, true));
                        }
                        else{
                            System.out.println("Nenhum usuario encontrado.");
                            return Optional.empty();
                        }
                    }
                    else{
                        System.out.println("Nenhum usuario encontrado.");
                        return Optional.empty();
                    }
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
        FuncionarioDAO.sql = sql;
    }

    public static String getSql() {
        return sql;
    }
}
