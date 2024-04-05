public class Empregador {
    private String nome;
    private String cnpj;

    // Construtor
    public Empregador(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
