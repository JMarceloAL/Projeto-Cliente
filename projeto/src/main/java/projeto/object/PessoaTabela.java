package projeto.object;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PessoaTabela {
    // Atributos Objeto Pessoatabela
    private final SimpleIntegerProperty codigo;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty email;
    private final SimpleStringProperty cpf;
    private final SimpleStringProperty numeroTelefone;

    // Construtor
    public PessoaTabela(Integer codigo, String nome, String email, String cpf, String numeroTelefone) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.cpf = new SimpleStringProperty(cpf);
        this.numeroTelefone = new SimpleStringProperty(numeroTelefone);
    }

    // get e set
    public Integer getId() {
        return codigo.get();
    }

    public String getNome() {
        return nome.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getCpf() {
        return cpf.get();
    }

    public String getNumeroTelefone() {
        return numeroTelefone.get();
    }

    public void setCodigo(Integer codigo) {
        this.codigo.set(codigo);
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone.set(numeroTelefone);
    }

    // Propriedades (opcional, para bindings no JavaFX)
    @SuppressWarnings("exports")
    public SimpleIntegerProperty codigoProperty() {
        return codigo;
    }

    @SuppressWarnings("exports")
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    @SuppressWarnings("exports")
    public SimpleStringProperty emailProperty() {
        return email;
    }

    @SuppressWarnings("exports")
    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    @SuppressWarnings("exports")
    public SimpleStringProperty numeroTelefoneProperty() {
        return numeroTelefone;
    }
}
