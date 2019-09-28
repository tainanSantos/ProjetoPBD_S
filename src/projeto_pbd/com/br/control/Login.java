package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;

import java.io.IOException;

public class Login {

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

}
