package models;

import startpoint.Usuario;

import java.util.Date;

public class Cliente extends Usuario {

    // Atributos adicionais do Cliente
    private String senha;
    private double saldo;
    private double limite;

    // Construtor
    public Cliente(int id, String nome, String cpf, String telefone, String senha, boolean validado) {
        super(id, nome, cpf, telefone, validado);
        this.senha = senha;
        this.saldo = saldo;
        this.limite = limite;
    }

    // Getter e Setter para a senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Getter e Setter para o saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter e Setter para o limite
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    // Método para consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    // Método para sacar
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    // Método para consultar extrato (apenas exemplo)
    public String consultarExtrato() {
        return "Extrato de " + getNome() + ": Saldo atual = " + saldo + " | Limite = " + limite;
    }

    // Método para calcular e retornar a idade do cliente com base na data de nascimento
    public int calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) return 0;

        // Obtém a data atual
        Date dataAtual = new Date();

        // Calcula a diferença de anos (simples, sem considerar meses e dias exatos)
        int idade = dataAtual.getYear() - dataNascimento.getYear();

        // Retorna a idade
        return idade;
    }

    // Método para imprimir informações do cliente (simplificado)
    @Override
    public String toString() {
        return "Cliente: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() +
               ", Saldo: " + saldo + ", Limite: " + limite;
    }
}
