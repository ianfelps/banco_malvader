package startpoint;

import controllers.UsuarioController;

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
        UsuarioController controller = new UsuarioController();
    }
}
