package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.fachada.FachadaUsuario;
import projeto_pbd.com.br.fachada.IFachadaUsuario;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.modell.Usuario;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroUsuarioDoSistema implements Initializable {

    private IFachadaUsuario fachadaUsuario;

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
    private AnchorPane anchorpaneCadastroUser1;
    @FXML
    private TextField nomeFuncionario;
    @FXML
    private TextField naturalidadeFuncionario;
    @FXML
    private TextField dataNasFuncionario;
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
    private TextField ufFuncionario;
    @FXML
    private AnchorPane anchorpaneCadastroUser2;
    @FXML
    private TextField email;
    @FXML
    private TextField senhaUm;
    @FXML
    private TextField senhaDoisConfirmar;


    public CadastroUsuarioDoSistema(){
        this.fachadaUsuario = new FachadaUsuario ();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboboxTipoFunacionario();
        carregarComboboXListUF ();
    }


    public void carregarComboboxTipoFunacionario(){
        this.comboboxTipoFunacionario.setItems (FXCollections.observableArrayList (this.listTipoFuncionario));
    }

    private void carregarComboboXListUF() {
        this.comboboxUF.setItems (FXCollections.observableArrayList (this.listUfs));
    }



    public void salvarCaradastroUsuario(){

        Usuario usuario = new Usuario ();

        usuario.setNome (nomeFuncionario.getText ());
        usuario.setNaturalidade (naturalidadeFuncionario.getText ());
        usuario.setDataNascimento (dataNasFuncionario.getText ());

        Endereco endereco = new Endereco ();
        endereco.setBairro (bairroFuncionario.getText ());
        endereco.setCep (cepFuncionario.getText ());
        endereco.setCidade (cidadeFuncionario.getText ());
        endereco.setComplemento (complementoLogradouroFuncionario.getText ());
        endereco.setLogradouro (logradouroFuncionario.getText ());
        endereco.setNumero (numeroLogragouroFuncionario.getText ());
        endereco.setUf (comboboxUF.getPromptText ());

        usuario.setEndereco (endereco);

        Telefone telefone = new Telefone ();
        telefone.setNumeroUm (telefoneUmFuncionario.getText ());
        telefone.setNumeroDois (telefoneDoisFuncionario.getText ());

        usuario.setTelefone (telefone);

        usuario.setEmail (email.getText ());
        usuario.setSenha (senhaUm.getText ());


        this.fachadaUsuario.salvarUsuario (usuario);



    }

}
