package models;

public class Transacao {
    private int idTransacao;
    private int idConta;
    private String tipoTransacao;  // Exemplo: "Depósito", "Saque", "Transferência"
    private double valor;
    private String dataTransacao;  // Pode usar LocalDate se preferir

    // construtor
    public Transacao(int idTransacao, int idConta, String tipoTransacao, double valor, String dataTransacao) {
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
    }

    // getters e setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "idTransacao=" + idTransacao +
                ", idConta=" + idConta +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", valor=" + valor +
                ", dataTransacao='" + dataTransacao + '\'' +
                '}';
    }
}

