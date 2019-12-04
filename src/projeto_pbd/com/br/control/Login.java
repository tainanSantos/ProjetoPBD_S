package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.UsuarioLogado;
import projeto_pbd.com.br.modell.Usuarioview;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {


    @FXML
    private AnchorPane anchorPaneLoginLogin;
    @FXML
    private AnchorPane panel;
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
    @FXML
    private ProgressIndicator carregandoProgressIndicator;
    @FXML
    private Button entrarButton;


    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregandoProgressIndicator.setVisible(false);

    }


    public void limparCampos(){
        emailRedefinirSenhaText.clear();
        senhaPadraoRedefinirSenhaText.clear();
        novaSenhaRedefinirSenhaText.clear();

    }

    //__________________________________________________________________________________________________________________

    @FXML
    public void fazerLogin(ActionEvent event) throws InterruptedException {
        panel.setVisible(true);

        if (event.getSource() == entrarButton) {
            panel.setVisible(true);


            if (Facade.getInstance().findAllUsuario().isEmpty()) { // se não estiver vazia aí sim eu vou chamar isso aqui!
                try {
                    Main.stageLogin().close();
                    Main.stagePrincipal().show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Usuarioview usuario = null;
                usuario = Facade.getInstance().validarLoginSenha(emailLoginText.getText(),
                        (senhaLoginText.getText()));

                if (usuario != null) {
                    try {

                        UsuarioLogado usuarioLogado = new UsuarioLogado();
                        usuarioLogado.setId(4);
                        usuarioLogado.setCpf(usuario.getCpf());
                        usuarioLogado.setEmail(usuario.getEmail());
                        usuarioLogado.setNome(usuario.getNome());
                        usuarioLogado.setPessoa_id(usuario.getPessoa_id());
                        usuarioLogado.setTipodeacesso(usuario.getTipodeacesso());

                        Facade.getInstance().saveUsuarioLogado(usuarioLogado);

                        Main.setUsuarioLogado(usuario);
                        Main.setTipoUsuario(usuario.getTipodeacesso()); // tipo de usuário que tá acessando o banco
                        Main.stageLogin().close();
                        Main.stagePrincipal().show();
                        Main.stagePrincipal().setMaximized(true);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    Mensagem.mensagemErro("Login o Senha Inválido, Por favor! Verifique os dados e tente novamente.");
            }
        }

    }


    @FXML
    void redefinirSenha(ActionEvent event) {

        Usuarioview usuario = null;
        usuario = Facade.getInstance().validarLoginSenha(emailRedefinirSenhaText.getText(),
                (senhaPadraoRedefinirSenhaText.getText()));
        Usuario user = new Usuario();
        try {
            user.setSenha(usuario.getSenha());
        }catch (NullPointerException e){
            Mensagem.mensagemErro("Campos não informados!");
            return;
        }
        user.setEmail(usuario.getEmail());
        user.setId(usuario.getPessoa_id());
        user.setTipoDeAcesso(usuario.getTipodeacesso());
        if (user != null){
            // s ok!
            // vamos validar o campo da senha nova
            if (novaSenhaRedefinirSenhaText.getText().length()>=6){
                usuario.setSenha((novaSenhaRedefinirSenhaText.getText()));
                Facade.getInstance().saveUsuario(user);
                Mensagem.mensagemSucesso("Senha Atualizada com sucesso");
                Main.setNotificatioSenhaUpdateUser(user);
                senhaPadraoRedefinirSenhaText.clear();
            }else {
                Mensagem.mensagemErro("A NOVA SENHA deve conter no mínimo 6 caracteres!");
            }
        }else{
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
