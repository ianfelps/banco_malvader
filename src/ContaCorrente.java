import java.time.LocalDate;

public class ContaCorrente extends Conta { // classe ContaCorrente que estende a classe abstrata Conta

    // atributos
    private double limite;
    private LocalDate data_vencimento;

    // metodos
    public ContaCorrente(int numero, String agencia, double saldo, Cliente cliente, double limite, LocalDate data_vencimento){
        super(numero, agencia, saldo, cliente);
        this.limite = limite;
        this.data_vencimento = data_vencimento;
    }

    public double consultarLimite(){
        // ...
    }
}