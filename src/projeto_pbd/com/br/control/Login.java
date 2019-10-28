package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private AnchorPane anchorPaneLoginLogin;

    @FXML
    private AnchorPane anchorPaneLoginRedefinirSenha;


    public void fazerLogin() throws IOException {
        Main.stageLogin().close();
        Main.stagePrincipal().show();
        Main.stagePrincipal ().setMaximized (true);
    }

    public void recuperarSenha(){
        this.anchorPaneLoginLogin.setVisible (false);
        this.anchorPaneLoginRedefinirSenha.setVisible (true);
    }

    public void sairDeRecuperarSenha(){
        this.anchorPaneLoginLogin.setVisible (true);
        this.anchorPaneLoginRedefinirSenha.setVisible (false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
    }
}
