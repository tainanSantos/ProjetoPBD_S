package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.*;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.*;

public class CadastroUsuarioDoSistema implements Initializable {


    @FXML
    private ComboBox comboboxTipoFunacionario;
    private List listTipoFuncionario = new ArrayList(Arrays.asList (new String[]{
            "Adiminstração","Direção ","Coordenação Pedagogica", "Secretaria"}));

    @FXML
    private ComboBox comboboxUF;
    private List listUfs = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));

    @FXML
    private TextField nomeFuncionario;
    @FXML
    private TextField naturalidadeFuncionario;
    @FXML
    private TextField dataNasFuncionario;
    @FXML
    private TextField cpfFuncionario;
    @FXML
    private TextField cepFuncionario;
    @FXML
    private TextField telefoneUmFuncionario;
    @FXML
    private TextField telefoneDoisFuncionario;
    @FXML
    private TextField logradouroFuncionario;
    @FXML
    private TextField numeroLogragouroFuncionario;
    @FXML
    private TextField complementoLogradouroFuncionario;
    @FXML
    private TextField bairroFuncionario;
    @FXML
    private TextField cidadeFuncionario;
    @FXML
    private TextField email;



    public CadastroUsuarioDoSistema(){


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

        this.comboboxTipoFunacionario.setItems (FXCollections.observableArrayList (this.listTipoFuncionario));
        this.comboboxUF.setItems (FXCollections.observableArrayList (this.listUfs));

        MaskFieldUtil.foneField (telefoneUmFuncionario);
        MaskFieldUtil.foneField (telefoneDoisFuncionario);
        MaskFieldUtil.dateField (dataNasFuncionario);
        MaskFieldUtil.cepField (cepFuncionario);
        MaskFieldUtil.cpfField (cpfFuncionario);



    }


    public void salvarCaradastroUsuario(){

        Usuario usuario = new Usuario ();

//        usuario.setNome (nomeFuncionario.getText ());
//        usuario.setNaturalidade (naturalidadeFuncionario.getText ());
//        usuario.setDataNascimento ((Date) dataNasFuncionario.getUserData ());
//        usuario.setCpf (cpfFuncionario.getText ());
//        usuario.setSenha (senhaPadrao ());
//        usuario.setTipoDeAcesso (comboboxTipoFunacionario.valueProperty ().get ().toString ());
//        usuario.setEmail (email.getText ());

        Endereco endereco = new Endereco ();
//        endereco.setBairro (bairroFuncionario.getText ());
//        endereco.setCep (cepFuncionario.getText ());
//        endereco.setCidade (cidadeFuncionario.getText ());
//        endereco.setComplemento (complementoLogradouroFuncionario.getText ());
//        endereco.setLogradouro (logradouroFuncionario.getText ());
//        endereco.setNumero (numeroLogragouroFuncionario.getText ());
//        endereco.setUf (comboboxUF.valueProperty ().get ().toString ());

        usuario.setEndereco (endereco);

        usuario = Facade.getInstance ().saveUsuario (usuario);
    }



    public String senhaPadrao(){
        String[] senhatemp = this.nomeFuncionario.getText ().split (" ");
        String cpftemp = this.cpfFuncionario.getText ();
        String primeirosDisgitosCpf = cpftemp.substring (cpftemp.length ()-2);

        String senhaPadrao = senhatemp[0]+""+primeirosDisgitosCpf;

        return  senhaPadrao;
    }

}
