package startpoint;

import javax.swing.*;

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class BancoMalvader {
    // Atributos
    private String nome;

    // Construtor
    public BancoMalvader(String nome) {
        this.nome = nome;
    }

    public void iniciarSistema() {
        // ...
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banco Malvader");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton buttonFuncionario = new JButton("1. Funcionario");
        JButton buttonCliente = new JButton("2. Cliente");
        JButton buttonSair = new JButton("3. Sair do Programa");

        JLabel label = new JLabel("Selecione uma das opções para começar.");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10)); // 4 linhas, 1 coluna para incluir os componentes extras
        panel.add(label);
        panel.add(buttonFuncionario);
        panel.add(buttonCliente);
        panel.add(buttonSair);

        buttonFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoSenha("Funcionario");
            }
        });

        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoSenha("Cliente");
            }
        });

        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }


    private static void abrirDialogoSenha(String tipoUsuario) {

        JDialog dialogoSenha = new JDialog((Frame) null, "Autenticação - " + tipoUsuario, true);
        dialogoSenha.setSize(300, 150);
        dialogoSenha.setLayout(new FlowLayout());

        JLabel labelSenha = new JLabel("Digite sua senha:");
        JPasswordField campoSenha = new JPasswordField(15);
        JButton botaoConfirmar = new JButton("Confirmar");

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] senha = campoSenha.getPassword();

                dao.ClienteDAO Cliente = new dao.ClienteDAO();

                models.Cliente ClienteLogado = Cliente.getUser(new String(senha));

                ClienteLogado.toString();


                dialogoSenha.dispose(); 
            }
        });


        dialogoSenha.add(labelSenha);
        dialogoSenha.add(campoSenha);
        dialogoSenha.add(botaoConfirmar);

        dialogoSenha.setLocationRelativeTo(null);
        dialogoSenha.setVisible(true); 
    }
}
