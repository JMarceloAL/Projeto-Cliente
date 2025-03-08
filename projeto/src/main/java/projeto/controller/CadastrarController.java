package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projeto.dao.ClienteDao;
import projeto.object.Cliente;
import projeto.view.Cadastrar;
import projeto.view.Principal;
import projeto.view.Tabela;

public class CadastrarController implements Initializable {

    @FXML
    private Button Vinicio;

    @FXML
    private Button Benviar;

    @FXML
    private Button Bsair;

    @FXML
    private TextField CampoCpf;

    @FXML
    private TextField CampoEmail;

    @FXML
    private TextField CampoNome;

    @FXML
    private TextField CampoTelefone;

    @FXML
    private Button Vtabela;

    @FXML
    private Label mensagem;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Vtabela.setOnMouseClicked((MouseEvent e) -> {
            Tabela p = new Tabela();
            closeView();
            try {
                p.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Benviar.setOnMouseClicked((MouseEvent e) -> {

            ClienteDao dao = new ClienteDao();
            Cliente cliente = new Cliente();
            if (CampoNome.getText() == "" || CampoEmail.getText() == "" || CampoCpf.getText() == ""
                    || CampoTelefone.getText() == "") {
                mensagem.setText("Erro ! Insira os Dados em Todos os Campos!");
            } else {

                cliente.setNome(CampoNome.getText());
                cliente.setEmail(CampoEmail.getText());
                cliente.setCpf(CampoCpf.getText());
                cliente.setNumero(CampoTelefone.getText());
                dao.incluir(cliente);
                limpar();
            }
        });
        Vinicio.setOnMouseClicked((MouseEvent e) -> {
            Principal p = new Principal();
            closeView();
            try {
                p.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        Bsair.setOnMouseClicked((MouseEvent e) -> {

            closeView();
        });
    }

    public void limpar() {

        CampoNome.setText("");
        CampoCpf.setText("");
        CampoEmail.setText("");
        CampoTelefone.setText("");
        mensagem.setText("");
    }

    public void closeView() {

        Cadastrar.getStage().close();

    }
}
