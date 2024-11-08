public class ContaPoupanca extends Conta { // classe ContaPoupanca que estende a classe abstrata Conta

    // atributos
    private double taxa_rendimento;

    // metodos
    public ContaPoupanca(int numero, String agencia, double saldo, Cliente cliente, double taxa_rendimento){
        super(numero, agencia, saldo, cliente);
        this.taxa_rendimento = taxa_rendimento;
    }

    public double calcularRendimento(){
        // ...
    }
}