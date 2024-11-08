public class Endereco { // classe Endereco
    
    // atributos
    private String cep;
    private String local;
    private int numero_casa;
    private String bairro;
    private String cidade;
    private String estado;

    // metodos
    public Endereco(String cep, String local, int numero_casa, String bairro, String cidade, String estado){
        this.cep = cep;
        this.local = local;
        this.numero_casa = numero_casa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String toString(){
        // ...
    }
}