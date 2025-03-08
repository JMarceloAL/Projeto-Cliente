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

import projeto.view.Login;
import projeto.view.Principal;

public class LoginController implements Initializable {

    @FXML
    private Button Bentrar;

    @FXML
    private Button Bsair;

    @FXML
    private TextField CampoSenha;

    @FXML
    private TextField CampoUsuario;

    @FXML
    private Label mensagem;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        Bentrar.setOnMouseClicked((MouseEvent e) -> {
            if (CampoUsuario.getText().equals("root") && CampoSenha.getText().equals("root")) {

                openView();

            } else {
                mensagem.setText("Usuario e Senha Incorretos!");
            }

        });
        Bsair.setOnMouseClicked((MouseEvent e) -> {
            closeView();
        });

    }

    public void closeView() {

        Login.getStage().close();

    }

    public void openView() {
        Principal p = new Principal();
        closeView();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
