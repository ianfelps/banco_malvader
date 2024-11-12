package controllers;

import dao.ClienteDAO;
import models.Cliente;
import view.MainView;
import view.PasswordDialogView;
import view.WelcomeView;

import javax.swing.*;
import java.util.Optional;

public class ClienteController {
    private MainView mainView;

    public ClienteController() {
        mainView = new MainView(this);
    }

    public void abrirDialogoSenha(String tipoUsuario) {
        new PasswordDialogView(this, tipoUsuario);
    }

    public void verificarSenha(String tipoUsuario, String senha, PasswordDialogView passwordDialogView) {
        if (tipoUsuario.equals("Cliente")) {
            ClienteDAO clienteDAO = new ClienteDAO();
            Optional<Cliente> clienteLogado = clienteDAO.getUser(senha);

            if (clienteLogado.isPresent()) {
                passwordDialogView.dispose();
                mainView.getFrame().dispose();
                new WelcomeView(clienteLogado.get());
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta ou usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tipoUsuario.equals("Funcionario")) {

        } else {
            System.out.println("Erro ao identificar usuario.");
            System.exit(0);
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}
