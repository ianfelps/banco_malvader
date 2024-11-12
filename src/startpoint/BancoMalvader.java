package startpoint;

import controllers.ClienteController;

import javax.swing.*;

public class BancoMalvader {
    private String nome;
    private static JFrame frame;

    public BancoMalvader(String nome) {
        this.nome = nome;
    }

    public void iniciarSistema() {
        // ...
    }

    public static void main(String[] args) {
        ClienteController controller = new ClienteController();
    }
}
