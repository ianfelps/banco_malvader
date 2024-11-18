package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import dao.ClienteDAO;
import models.Endereco;

public class CadastroView {
    private JFrame telaCadastro;

    public CadastroView() {
        telaCadastro = new JFrame("Cadastro de Usuário");
        telaCadastro.setSize(400, 600); // Aumentei o tamanho para incluir mais campos
        telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaCadastro.setLayout(new GridBagLayout());

        // Configuração do layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos do formulário
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JLabel labelCpf = new JLabel("CPF:");
        JTextField campoCpf = new JTextField();

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();

        JLabel labelDataNascimento = new JLabel("Data de Nascimento (dd/MM/yyyy):");
        JTextField campoDataNascimento = new JTextField();

        JLabel labelTipoCliente = new JLabel("Tipo de Cliente:");
        JComboBox<String> comboTipoCliente = new JComboBox<>(new String[]{"CLIENTE", "FUNCIONARIO"});

        // Campo para cargo, só visível quando o tipo de cliente for FUNCIONARIO
        JLabel labelCargo = new JLabel("Cargo:");
        JComboBox<String> comboCargo = new JComboBox<>(new String[]{"ADMINISTRADOR", "GERENTE", "ATENDENTE", "DESENVOLVEDOR"});
        comboCargo.setEnabled(false); // Desabilita o combo de cargos inicialmente

        // Campos de endereço
        JLabel labelCep = new JLabel("CEP:");
        JTextField campoCep = new JTextField();

        JLabel labelLogradouro = new JLabel("Logradouro:");
        JTextField campoLogradouro = new JTextField();

        JLabel labelNumero = new JLabel("Número:");
        JTextField campoNumero = new JTextField();

        JLabel labelBairro = new JLabel("Bairro:");
        JTextField campoBairro = new JTextField();

        JLabel labelCidade = new JLabel("Cidade:");
        JTextField campoCidade = new JTextField();

        JLabel labelEstado = new JLabel("Estado:");
        JTextField campoEstado = new JTextField();

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoCancelar = new JButton("Cancelar");

        // Adiciona os componentes à tela com alinhamento
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        telaCadastro.add(labelNome, gbc);
        gbc.gridx = 1; // Coluna 1
        telaCadastro.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelEmail, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelSenha, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelCpf, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelTelefone, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelDataNascimento, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelTipoCliente, gbc);
        gbc.gridx = 1;
        telaCadastro.add(comboTipoCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelCargo, gbc);
        gbc.gridx = 1;
        telaCadastro.add(comboCargo, gbc);

        // Adiciona os campos de endereço
        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelCep, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoCep, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelLogradouro, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoLogradouro, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelNumero, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoNumero, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelBairro, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoBairro, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelCidade, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        telaCadastro.add(labelEstado, gbc);
        gbc.gridx = 1;
        telaCadastro.add(campoEstado, gbc);

        // Adiciona os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoCancelar);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; // Botões ocupam duas colunas
        telaCadastro.add(painelBotoes, gbc);

        // Ação do botão Cadastrar
        botaoCadastrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());
            String cpf = campoCpf.getText();
            String telefone = campoTelefone.getText();
            String dataNascimentoStr = campoDataNascimento.getText();
            String tipoCliente = (String) comboTipoCliente.getSelectedItem();
            String cargo = null;

            // Obtendo os valores dos campos de endereço
            String cep = campoCep.getText();
            String logradouro = campoLogradouro.getText();
            int numero = Integer.parseInt(campoNumero.getText());
            String bairro = campoBairro.getText();
            String cidade = campoCidade.getText();
            String estado = campoEstado.getText();

            if (tipoCliente.equals("FUNCIONARIO")) {
                cargo = (String) comboCargo.getSelectedItem();
            }

            // Verificando se os campos obrigatórios estão preenchidos
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || dataNascimentoStr.isEmpty() ||
                    cep.isEmpty() || logradouro.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                JOptionPane.showMessageDialog(telaCadastro,
                        "Por favor, preencha todos os campos.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                // Chama o DAO para inserir o cliente
                ClienteDAO clienteDAO = new ClienteDAO();
                Endereco enderecoCliente = new Endereco(cep, logradouro, numero, bairro, cidade, estado);
                clienteDAO.inserirCliente(nome, email, senha, cpf, telefone, dataNascimento.toString(), enderecoCliente, tipoCliente, cargo);

                JOptionPane.showMessageDialog(telaCadastro,
                        "Cadastro realizado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                telaCadastro.dispose(); // Fecha a tela de cadastro
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(telaCadastro,
                        "Data de nascimento inválida. Use o formato dd/MM/yyyy.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(telaCadastro,
                        "Erro ao realizar o cadastro: " + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ação do botão Cancelar
        botaoCancelar.addActionListener(e -> telaCadastro.dispose());

        // Ação para mostrar ou ocultar o campo de Cargo
        comboTipoCliente.addActionListener(e -> {
            if (comboTipoCliente.getSelectedItem().equals("FUNCIONARIO")) {
                labelCargo.setVisible(true);
                comboCargo.setEnabled(true);
            } else {
                labelCargo.setVisible(false);
                comboCargo.setEnabled(false);
            }
        });

        // Inicialmente o campo de Cargo está oculto
        labelCargo.setVisible(false);
        comboCargo.setEnabled(false);

        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    }
}
