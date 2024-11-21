package models;

import startpoint.Usuario;

import java.util.Date;

public class Cliente extends Usuario {

    // Atributos adicionais do Cliente
    private String senha;
    private double saldo;
    private double limite;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Construtor
    public Cliente(int id, String nome, String email, String cpf, String telefone, String senha, boolean validado) {
        super(id, nome, cpf, telefone, validado);
        this.senha = senha;
        this.saldo = saldo;
        this.limite = limite;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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
