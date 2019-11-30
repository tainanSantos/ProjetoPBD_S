package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;
import projeto_pbd.com.br.msg.Mensagem;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class RedefinirSenha implements Initializable {


    @FXML
    private TextField emailRedefinirSenhaText;
    @FXML
    private TextField senhaPadraoRedefinirSenhaText;
    @FXML
    private TextField novaSenhaRedefinirSenhaText;
    @FXML
    private Button redefiniSenhaButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                //lógicamente eu nem precisaria disso aqui
                try {
                    Usuarioview usuario = (Usuarioview) userData;
                    System.out.println(usuario);
                    emailRedefinirSenhaText.setText(usuario.getEmail());
                } catch (ClassCastException e){

                }

            }
        });
    }


    @FXML
    void redefinirSenha(ActionEvent event) {

        Usuarioview usuario = null;
        usuario = Facade.getInstance().validarLoginSenha(emailRedefinirSenhaText.getText(),
                (senhaPadraoRedefinirSenhaText.getText()));
        Usuario user = new Usuario();
        user.setSenha(usuario.getSenha());
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
}
