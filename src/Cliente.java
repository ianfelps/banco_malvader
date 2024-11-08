public class Cliente extends Usuario { // classe Cliente que estende a classe abstrata Usuario

    // atributos
    private String senha;

    // metodos
    public Cliente(int id, String nome, String cpf, LocalDate data_nascimento, String telefone, Endereco endereco, String senha) {
        super(id, nome, cpf, data_nascimento, telefone, endereco);
        this.senha = senha;
    }

    public double consultarSaldo(){
        // ...
    }

    public void depositar(double valor){
        // ...
    }

    public boolean sacar(double valor){
        // ...
    }

    public String consultarExtrato(){
        // ...
    }

    public double consultarLimite(){
        // ...
    }
}