package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.*;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Telefone;
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
    private Button salvarUsuarioButton;
    @FXML
    private TextField email;
    @FXML
    private Button destivarUsuarioButton;
    @FXML
    private Button novoUsuarioButton;
    @FXML
    private TableView<Usuario> usuarioTable;
    @FXML
    private TableColumn<?, ?> statusColum;
    @FXML
    private TableColumn<?, ?> nomeColum;
    @FXML
    private TableColumn<?, ?> naturalidadeColum;
    @FXML
    private TableColumn<?, ?> tipoAcessoColum;
    @FXML
    private TextField pesquisaText;
    @FXML
    private Button pesquisarUsuarioButton;

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                // aqui a gente ver de onde é que vem o evento
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


    public void atualizarTabela(List<Usuario> usuarioList){
        statusColum.setCellValueFactory(new PropertyValueFactory("status"));
        nomeColum.setCellValueFactory(new PropertyValueFactory("nome"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory("naturalidade"));
        tipoAcessoColum.setCellValueFactory(new PropertyValueFactory("tipoDeAcesso"));
        usuarioTable.getItems().setAll(usuarioList);
    }


    //__________________________________________________________________________________________________________________

    @FXML
    public void action(ActionEvent event){


        if (event.getSource() ==  salvarUsuarioButton){
            Usuario usuario = new Usuario ();
            Endereco endereco = new Endereco ();
            Telefone telefone = new Telefone();
            Telefone telefone1 = new Telefone();

            usuario.setNome (nomeFuncionario.getText ());
            usuario.setNaturalidade (naturalidadeFuncionario.getText ());
            usuario.setDataNascimento ((Date) dataNasFuncionario.getUserData ());
            usuario.setCpf (cpfFuncionario.getText ());
            usuario.setSenha (senhaPadrao ());
            usuario.setTipoDeAcesso (comboboxTipoFunacionario.valueProperty ().get ().toString ());
            usuario.setEmail (email.getText ());

            endereco.setBairro (bairroFuncionario.getText ());
            endereco.setCep (cepFuncionario.getText ());
            endereco.setCidade (cidadeFuncionario.getText ());
            endereco.setComplemento (complementoLogradouroFuncionario.getText ());
            endereco.setLogradouro (logradouroFuncionario.getText ());
            endereco.setNumero (numeroLogragouroFuncionario.getText ());
            endereco.setUf (comboboxUF.valueProperty ().get ().toString ());

            telefone.setNumero(telefoneUmFuncionario.getText());
            telefone1.setNumero(telefoneDoisFuncionario.getText());
            usuario.setEndereco (endereco);

            usuario = Facade.getInstance ().saveUsuario (usuario);
            telefone.setPessoa(usuario);
            telefone1.setPessoa(usuario);
            Facade.getInstance().saveTelefone(telefone);
            Facade.getInstance().saveTelefone(telefone1);
            atualizarTabela(Facade.getInstance().findAllUsuario());
        }

        if (event.getSource() == novoUsuarioButton){

        }

        if (event.getSource() == destivarUsuarioButton){

        }

        if (event.getSource() == pesquisarUsuarioButton){

        }


    }



    public String senhaPadrao(){
        // primeiro nome da pessoa + dois ultimos digitos do cpf
        String[] senhatemp = this.nomeFuncionario.getText ().split (" ");
        String cpftemp = this.cpfFuncionario.getText ();
        String primeirosDisgitosCpf = cpftemp.substring (cpftemp.length ()-2);
        String senhaPadrao = senhatemp[0]+""+primeirosDisgitosCpf;
        return  senhaPadrao;
    }

}
