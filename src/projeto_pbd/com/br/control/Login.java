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
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
    }


    public void limparCampos(){
        emailRedefinirSenhaText.clear();
        senhaPadraoRedefinirSenhaText.clear();
        novaSenhaRedefinirSenhaText.clear();

    }


    //__________________________________________________________________________________________________________________


    public void fazerLogin()  {

//        emailLoginText.setText("tainan@gmail.com");
//        senhaLoginText.setText("tainan123");

        Usuario usuario = null;
        usuario = Facade.getInstance().validarLoginSenha(emailLoginText.getText(),
                functioCrip2(senhaLoginText.getText()));

        if ((usuario != null) || (Facade.getInstance().findAllUsuario().isEmpty())){
            try {
                Main.stageLogin().close();
                Main.stagePrincipal().show();
                Main.stagePrincipal ().setMaximized (true);

                // ATENAÇÃO
                // FALATA MANDA AQUI O TIPODE PESSOA QUE TA ACESSNAOD O SISTEMA
                // PARA EFETUAR AS RESTRIÇÕES NAS OUTRA TELAS

            } catch (IOException e) {
                e.printStackTrace();
            }        }
        else Mensagem.mensagemErro("Login o Senha Inválido, Por favor! Verifique os dados e tente novamente.");

    }



    public void redefinirSenha(){
        // verificando se realmente é o usuário que esta inserido no banco
        senhaPadraoRedefinirSenhaText.clear();
        Usuario usuario = null;
        usuario = Facade.getInstance().validarLoginSenha(emailRedefinirSenhaText.getText(),
                functioCrip2(senhaPadraoRedefinirSenhaText.getText()));

        if (usuario != null){
            // s ok!
            // vamos validar o campo da senha nova
            if (novaSenhaRedefinirSenhaText.getText().length()>=6){
                usuario.setSenha(functioCrip2(novaSenhaRedefinirSenhaText.getText()));
                Facade.getInstance().saveUsuario(usuario);
                sairDeRecuperarSenha();
                Mensagem.mensagemSucesso("Senha Atualizada com sucesso");
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


    public String functioCrip2(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }



}
