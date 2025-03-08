package projeto.object;

public class Cliente {
    // Atributos Objeto Cliente!
    public int codigo;
    public String nome;
    public String email;
    public String cpf;
    public String numeroTelefone;

    public Cliente() {

    }

    // Constructor!
    public Cliente(int codigo, String nome, String email, String cpf, String numeroTelefone) {

        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;

    }

    // get e set
    public int getId() {

        return codigo;
    }

    public void setId(int codigo) {

        this.codigo = codigo;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getNumero() {

        return numeroTelefone;
    }

    public void setNumero(String numeroTelefone) {

        this.numeroTelefone = numeroTelefone;
    }

    public Cliente(PessoaTabela pessoaTabela) {

        this.codigo = pessoaTabela.getId();
        this.nome = pessoaTabela.getNome();
        this.email = pessoaTabela.getEmail();
        this.cpf = pessoaTabela.getCpf();
        this.numeroTelefone = pessoaTabela.getNumeroTelefone();

    }
}
