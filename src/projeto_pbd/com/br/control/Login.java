package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {


    @FXML
    private AnchorPane anchorPaneLoginLogin;
    @FXML
    private AnchorPane anchorPaneLoginRedefinirSenha;
    @FXML
    private TextField emailLoginText;
    @FXML
    private PasswordField senhaLoginText;
    @FXML
    private TextField emailRedefinirSenhaText;
    @FXML
    private TextField senhaPadraoRedefinirSenhaText;
    @FXML
    private TextField novaSenhaRedefinirSenhaText;

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void limparCampos(){
        emailRedefinirSenhaText.clear();
        senhaPadraoRedefinirSenhaText.clear();
        novaSenhaRedefinirSenhaText.clear();

    }

    //__________________________________________________________________________________________________________________

    public void fazerLogin()  {

        if (Facade.getInstance().findAllUsuario().isEmpty()) { // se não estiver vazia aí sim eu vou chamar isso aqui!
            try {
                Main.stageLogin().close();
                Main.stagePrincipal().show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {

            Usuario usuario = null;
            usuario = Facade.getInstance().validarLoginSenha(emailLoginText.getText(),
                    (senhaLoginText.getText()));

            if (usuario != null) {
                try {

                    Main.setUsuarioLogado(usuario);
                    Main.setTipoUsuario(usuario.getTipoDeAcesso()); // tipo de usuário que tá acessando o banco
                    Main.stageLogin().close();
                    Main.stagePrincipal().show();
                    Main.stagePrincipal().setMaximized(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else Mensagem.mensagemErro("Login o Senha Inválido, Por favor! Verifique os dados e tente novamente.");
        }

    }


    public void redefinirSenha(){
        Usuario usuario = null;
        usuario = Facade.getInstance().validarLoginSenha(emailRedefinirSenhaText.getText(),
                (senhaPadraoRedefinirSenhaText.getText()));

        if (usuario != null){
            // s ok!
            // vamos validar o campo da senha nova
            if (novaSenhaRedefinirSenhaText.getText().length()>=6){
                usuario.setSenha((novaSenhaRedefinirSenhaText.getText()));
                Facade.getInstance().saveUsuario(usuario);
                sairDeRecuperarSenha();
                Mensagem.mensagemSucesso("Senha Atualizada com sucesso");
                Main.setNotificatioSenhaUpdateUser(usuario);
                senhaPadraoRedefinirSenhaText.clear();
            }else {
                Mensagem.mensagemErro("A NOVA SENHA deve conter no mínimo 6 caracteres!");
            }
        }
        else{
            Mensagem.mensagemErro("Login o Senha Inválido, Por favor! Verifique os dados e tente novamente.");
        }
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


}
