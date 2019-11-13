package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
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


    public void fazerLogin()  {

        try {
            Main.stageLogin().close();
            Main.stagePrincipal().show();
            Main.stagePrincipal ().setMaximized (true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // mandar por aqui qual tipo de USUARIO que logou no sistema
        // lembrando que esse método só pode ser implementado depois
        // que a stage for exibida

    }

    public void recuperarSenha(){
        this.anchorPaneLoginLogin.setVisible (false);
        this.anchorPaneLoginRedefinirSenha.setVisible (true);
    }

    public void sairDeRecuperarSenha(){
        this.anchorPaneLoginLogin.setVisible (true);
        this.anchorPaneLoginRedefinirSenha.setVisible (false);
    }

    @FXML
    void sairButton(MouseEvent event) {
        try {
            Main.stageLogin().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
