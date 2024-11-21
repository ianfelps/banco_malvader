package models;

public class Transacao {
    private int idConta;
    private String tipo;
    private double valor;

    public Transacao(int idConta, String tipo, double valor) {
        this.idConta = idConta;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getIdConta() {
        return idConta;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
