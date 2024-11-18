package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.UsuarioController;

public class MainView {
    private JFrame frame;
    private UsuarioController controller;

    public MainView(UsuarioController controller) {
        this.controller = controller;
        frame = new JFrame("Banco Malvader");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton buttonFuncionario = new JButton("1. Funcionario");
        JButton buttonCliente = new JButton("2. Cliente");
        JButton buttonSair = new JButton("3. Sair do Programa");

        JLabel label = new JLabel("Selecione uma das opções para começar.");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(label);
        panel.add(buttonFuncionario);
        panel.add(buttonCliente);
        panel.add(buttonSair);

        buttonFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.abrirDialogoSenha("Funcionario");
            }
        });

        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.abrirDialogoSenha("Cliente");
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

    public JFrame getFrame() {
        return frame;
    }
}
