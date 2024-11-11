package models;
public abstract class Conta { // classe Conta

    // atributos
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    // metodos
    public Conta(int numero, String agencia, double saldo, Cliente cliente){
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

//    public void depositar(double valor){
//        // ...
//    }
//
//    public boolean sacar(double valor){
//        // ...
//    }
//
//    public double consultarSaldo(){
//        // ...
//    }
}