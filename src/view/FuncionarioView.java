package view;

import controllers.UsuarioController;
import models.Cliente;

import javax.swing.*;
import java.awt.*;

public class FuncionarioView extends JFrame {

    private final JLabel iconeLabel;
    private final JLabel tituloLabel;
    private final JButton aberturaButton;
    private final JButton encerramentoButton;
    private final JButton consultaButton;
    private final JButton alteracaoButton;
    private final JButton cadastroButton;
    private final JButton relatorioButton;
    private final JButton sairButton;

    public FuncionarioView(Cliente usuario) {
        super("Bem vindo " + usuario.getNome());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // layout da tela

        Font primariaFont = new Font("SansSerif", Font.BOLD, 30); // fonte
        Font secundariaFont = new Font("SansSerif", Font.BOLD, 15);

        // label de titulo
        tituloLabel = new JLabel("Area do Funcionario");
        tituloLabel.setFont(primariaFont); // setar fonte
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // botoes
        aberturaButton = new JButton("Abrir Conta");
        aberturaButton.setFont(secundariaFont);
        aberturaButton.setPreferredSize(new Dimension(200, 50));
        aberturaButton.setMaximumSize(new Dimension(200, 50));
        aberturaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aberturaButton.addActionListener(e -> abrirConta());

        encerramentoButton = new JButton("Encerrar Conta");
        encerramentoButton.setFont(secundariaFont);
        encerramentoButton.setPreferredSize(new Dimension(200, 50));
        encerramentoButton.setMaximumSize(new Dimension(200, 50));
        encerramentoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        encerramentoButton.addActionListener(e -> encerrarConta());

        consultaButton = new JButton("Consultar Dados");
        consultaButton.setFont(secundariaFont);
        consultaButton.setPreferredSize(new Dimension(200, 50));
        consultaButton.setMaximumSize(new Dimension(200, 50));
        consultaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultaButton.addActionListener(e -> consultarDados());

        alteracaoButton = new JButton("Alterar Dados");
        alteracaoButton.setFont(secundariaFont);
        alteracaoButton.setPreferredSize(new Dimension(200, 50));
        alteracaoButton.setMaximumSize(new Dimension(200, 50));
        alteracaoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        alteracaoButton.addActionListener(e -> alterarDados());

        cadastroButton = new JButton("Cadastrar Funcionario");
        cadastroButton.setFont(secundariaFont);
        cadastroButton.setPreferredSize(new Dimension(200, 50));
        cadastroButton.setMaximumSize(new Dimension(200, 50));
        cadastroButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cadastroButton.addActionListener(e -> cadastrarFuncionario());

        relatorioButton = new JButton("Gerar Relatório");
        relatorioButton.setFont(secundariaFont);
        relatorioButton.setPreferredSize(new Dimension(200, 50));
        relatorioButton.setMaximumSize(new Dimension(200, 50));
        relatorioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        relatorioButton.addActionListener(e -> gerarRelatorio());

        sairButton = new JButton("Sair");
        sairButton.setFont(secundariaFont);
        sairButton.setPreferredSize(new Dimension(200, 50));
        sairButton.setMaximumSize(new Dimension(200, 50));
        sairButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        sairButton.addActionListener(e -> {
            dispose(); // fecha a TelaCliente
            // volta para a TelaInicial
            MainView mainView = new MainView(new UsuarioController());
            mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainView.setSize(500, 500);
            mainView.setVisible(true);
            mainView.setLocationRelativeTo(null);
        });

        // icone
        ImageIcon icone = new ImageIcon(getClass().getResource("/Logo.png"));
        Image img = icone.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        iconeLabel = new JLabel(new ImageIcon(img));
        iconeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // adicionar elementos
        add(iconeLabel);
        add(Box.createVerticalStrut(20));
        add(tituloLabel);
        add(Box.createVerticalStrut(20));
        add(aberturaButton);
        add(Box.createVerticalStrut(20));
        add(encerramentoButton);
        add(Box.createVerticalStrut(20));
        add(consultaButton);
        add(Box.createVerticalStrut(20));
        add(alteracaoButton);
        add(Box.createVerticalStrut(20));
        add(cadastroButton);
        add(Box.createVerticalStrut(20));
        add(relatorioButton);
        add(Box.createVerticalStrut(20));
        add(sairButton);
        add(Box.createVerticalStrut(20));
    }

    // Eventos dos botões
    private void abrirConta() {
        String[] tiposConta = {"Poupança", "Corrente"};
        String tipoConta = (String) JOptionPane.showInputDialog(this, "Selecione o tipo de conta:", "Abertura de Conta",
                JOptionPane.PLAIN_MESSAGE, null, tiposConta, tiposConta[0]);

        if (tipoConta != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

            panel.add(new JLabel("Agência:"));
            JTextField agenciaField = new JTextField();
            panel.add(agenciaField);

            panel.add(new JLabel("Número da conta:"));
            JTextField numeroContaField = new JTextField();
            panel.add(numeroContaField);

            panel.add(new JLabel("Nome do cliente:"));
            JTextField nomeClienteField = new JTextField();
            panel.add(nomeClienteField);

            panel.add(new JLabel("CPF:"));
            JTextField cpfField = new JTextField();
            panel.add(cpfField);

            panel.add(new JLabel("Data de nascimento:"));
            JTextField dataNascimentoField = new JTextField();
            panel.add(dataNascimentoField);

            panel.add(new JLabel("Telefone:"));
            JTextField telefoneField = new JTextField();
            panel.add(telefoneField);

            panel.add(new JLabel("Endereço:"));
            JTextField enderecoField = new JTextField();
            panel.add(enderecoField);

            panel.add(new JLabel("Senha:"));
            JTextField senhaField = new JTextField();
            panel.add(senhaField);

            if (tipoConta.equals("Corrente")) {
                panel.add(new JLabel("Limite da conta:"));
                JTextField limiteField = new JTextField();
                panel.add(limiteField);

                panel.add(new JLabel("Data de vencimento:"));
                JTextField dataVencimentoField = new JTextField();
                panel.add(dataVencimentoField);
            }

            int result = JOptionPane.showConfirmDialog(this, panel, "Abertura de Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, "Conta " + tipoConta + " criada com sucesso!");
            }
        }
    }

    private void encerrarConta() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        panel.add(new JLabel("Senha do Administrador:"));
        JPasswordField senhaAdminField = new JPasswordField();
        panel.add(senhaAdminField);

        panel.add(new JLabel("Número da conta:"));
        JTextField numeroContaField = new JTextField();
        panel.add(numeroContaField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Encerrar Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String senhaAdmin = new String(senhaAdminField.getPassword());
            if (senhaAdmin.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Conta " + numeroContaField.getText() + " encerrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
            }
        }
    }


    private void consultarDados() {
        String[] opcoes = {"Conta", "Funcionário", "Cliente"};
        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha uma opção para consultar:", "Consulta de Dados",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != null) {
            JOptionPane.showMessageDialog(this, "Exibindo dados de " + escolha + ".");
        }
    }

    private void alterarDados() {
        String[] opcoes = {"Conta", "Funcionário", "Cliente"};
        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha uma opção para alterar:", "Alteração de Dados",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

            switch (escolha) {
                case "Conta" -> {
                    panel.add(new JLabel("Novo limite:"));
                    JTextField limiteField = new JTextField();
                    panel.add(limiteField);

                    panel.add(new JLabel("Nova data de vencimento:"));
                    JTextField vencimentoField = new JTextField();
                    panel.add(vencimentoField);
                }
                case "Funcionário" -> {
                    panel.add(new JLabel("Novo cargo:"));
                    JTextField cargoField = new JTextField();
                    panel.add(cargoField);

                    panel.add(new JLabel("Novo telefone:"));
                    JTextField telefoneField = new JTextField();
                    panel.add(telefoneField);

                    panel.add(new JLabel("Novo endereço:"));
                    JTextField enderecoField = new JTextField();
                    panel.add(enderecoField);
                }
                case "Cliente" -> {
                    panel.add(new JLabel("Novo telefone:"));
                    JTextField telefoneField = new JTextField();
                    panel.add(telefoneField);

                    panel.add(new JLabel("Novo endereço:"));
                    JTextField enderecoField = new JTextField();
                    panel.add(enderecoField);
                }
            }

            int result = JOptionPane.showConfirmDialog(this, panel, "Alteração de Dados", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, escolha + " atualizado com sucesso!");
            }
        }
    }


    private void cadastrarFuncionario() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        panel.add(new JLabel("Código do funcionário:"));
        JTextField codigoField = new JTextField();
        panel.add(codigoField);

        panel.add(new JLabel("Cargo:"));
        JTextField cargoField = new JTextField();
        panel.add(cargoField);

        panel.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Data de nascimento:"));
        JTextField dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Endereço completo:"));
        JTextField enderecoField = new JTextField();
        panel.add(enderecoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastro de Funcionário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String senhaAdmin = JOptionPane.showInputDialog(this, "Digite a senha do administrador:");
            if (senhaAdmin != null && senhaAdmin.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
            }
        }
    }

    private void gerarRelatorio() {
        String senhaAdmin = JOptionPane.showInputDialog(this, "Digite a senha do administrador:");
        if (senhaAdmin != null && senhaAdmin.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Senha incorreta.");
        }
    }
}