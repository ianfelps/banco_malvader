import java.time.LocalDate;

public abstract class Usuario { // classe abstrata Usuario

    // atributos
    private int id;
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private String telefone;
    private Endereco endereco;

    // metodos
    public Usuario(int id, String nome, String cpf, LocalDate data_nascimento, String telefone, Endereco endereco){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public boolean login(String senha){
        // ...
    }

    public void logout(){
        // ...
    }

    public String consultarDados(){
        // ...
    }
}