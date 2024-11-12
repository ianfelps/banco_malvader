package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.ClienteController;

public class PasswordDialogView {
    private JDialog dialogoSenha;

    public PasswordDialogView(ClienteController controller, String tipoUsuario) {
        dialogoSenha = new JDialog((Frame) null, "Autenticação - " + tipoUsuario, true);
        dialogoSenha.setSize(300, 150);
        dialogoSenha.setLayout(new FlowLayout());

        JLabel labelSenha = new JLabel("Digite sua senha:");
        JPasswordField campoSenha = new JPasswordField(15);
        JButton botaoConfirmar = new JButton("Confirmar");

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] senha = campoSenha.getPassword();
                controller.verificarSenha(tipoUsuario, new String(senha), PasswordDialogView.this); // Passando o objeto correto
            }
        });

        dialogoSenha.add(labelSenha);
        dialogoSenha.add(campoSenha);
        dialogoSenha.add(botaoConfirmar);

        dialogoSenha.setLocationRelativeTo(null);
        dialogoSenha.setVisible(true);
    }

    public void dispose() {
        dialogoSenha.dispose();
    }
}
