package projeto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projeto.Connect.ConnectBD;
import projeto.view.Cadastrar;
import projeto.view.Principal;
import projeto.view.Tabela;

public class PrincipalController implements Initializable {

    @FXML
    private Button Btestar;

    @FXML
    private Label mensagem;

    @FXML
    private Button Bsair;

    @FXML
    private Button Vcadastrar;

    @FXML
    private Button Vtabela;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Vcadastrar.setOnMouseClicked((MouseEvent e) -> {
            Cadastrar p = new Cadastrar();
            closeView();
            try {
                p.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Vtabela.setOnMouseClicked((MouseEvent e) -> {
            Tabela p = new Tabela();
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
        // Verifica a Conexão com o Banco de Dados
        Btestar.setOnMouseClicked((MouseEvent e) -> {

            if (ConnectBD.getConnect() != null) {
                mensagem.setText("Conectado!");
            } else {
                mensagem.setText("Erro na Conexão!");
            }

        });

    }

    public void closeView() {

        Principal.getStage().close();

    }
}
