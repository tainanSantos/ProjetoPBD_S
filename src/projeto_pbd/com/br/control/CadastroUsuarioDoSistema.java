package projeto_pbd.com.br.control;


/*
* com retorno   PROSSIDURE
* sem retorno   FUNÇÃO
* */

/*
* a estory procidure é uma função que não esta assosciada a tabela
* gatilho é uma função assonciada a tabela que quando acontecer alguma coisa na tebela ele é invocado
*   o gatilho quando chama a função ele altera alguam coisa na tabela
*   o gatilho vai fazer o LOG e ALTERAÇÃO DO SISTEMA
*/


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.*;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.net.URL;
import java.util.*;


public class CadastroUsuarioDoSistema implements Initializable {


    @FXML
    private ComboBox comboboxTipoFunacionario;
    private List listTipoFuncionario = new ArrayList(Arrays.asList (new String[]{
            "Adiminstração","Direção","Coordenação Pedagogica", "Secretaria"}));


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
    private DatePicker dataNasFuncionario;
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
    private TextField novaSenhaGetText;
    @FXML
    private Button salvarUsuarioButton;
    @FXML
    private TextField email;
    @FXML
    private Button destivarUsuarioButton;
    @FXML
    private Button novoUsuarioButton;
    @FXML
    private TableView<Usuarioview> usuarioTable;
    @FXML
    private TableColumn<?, ?> statusColum;
    @FXML
    private TableColumn<?, ?> nomeColum;
    @FXML
    private TableColumn<?, ?> emailColum;
    @FXML
    private TableColumn<?, ?> cpfColum;
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

        //RESTRIÇÃO DE ACESSO
        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    break;
                case ("Direção"):
                    break;
                case ("Coordenação Pedagogica"):
                    break;
                case ("Secretaria"):
                    break;
            }
        }


        // já vai funcionara e a restrição de converção também não vai mais interferir
        cpfFuncionario.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    novaSenhaGetText.setText(senhaPadrao());
                }catch (StringIndexOutOfBoundsException e){
                }catch (IllegalArgumentException e){}
            }
        });


        nomeFuncionario.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    novaSenhaGetText.setText(senhaPadrao());
                }catch (StringIndexOutOfBoundsException e){
                }catch (IllegalArgumentException e){}
            }
        });


        atualizarTabela(Facade.getInstance().findAllUsuario());
        pesquisaText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (pesquisaText.getText().length() > 1)
                    atualizarTabela(Facade.getInstance().findAllUsuarioNome(pesquisaText.getText()));
                else atualizarTabela(Facade.getInstance().findAllUsuario());
            }
        });


        usuarioTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1){
                    if (usuarioTable.getSelectionModel().getSelectedItem() != null){
                        Usuarioview usuario = null;
                        usuario = usuarioTable.getSelectionModel().getSelectedItem();
                        logradouroFuncionario.setText(usuario.getLogradouro());
                        numeroLogragouroFuncionario.setText(usuario.getNumero());
                        complementoLogradouroFuncionario.setText(usuario.getComplemento());
                        bairroFuncionario.setText(usuario.getBairro());
                        cidadeFuncionario.setText(usuario.getCidade());
                        comboboxUF.setValue(usuario.getUf());
                        comboboxTipoFunacionario.setValue(usuario.getTipodeacesso());

                        email.setText(usuario.getEmail());
                        cepFuncionario.setText(usuario.getCep());
                        cpfFuncionario.setText(usuario.getCpf());

                        dataNasFuncionario.setValue(usuario.getDatanascimento()); // ainda não implementado

                        naturalidadeFuncionario.setText(usuario.getNaturalidade());
                        nomeFuncionario.setText(usuario.getNome());
                        List<Telefone> telefoneList = null;
                        telefoneList = Facade.getInstance().findAllIdTelefone(usuario.getPessoa_id());

                        telefoneUmFuncionario.setText(telefoneList.get(0).getNumero());
                        telefoneDoisFuncionario.setText(telefoneList.get(1).getNumero());
                    }
                }
            }
        });


        this.comboboxTipoFunacionario.setItems (FXCollections.observableArrayList (this.listTipoFuncionario));
        this.comboboxUF.setItems (FXCollections.observableArrayList (this.listUfs));

        MaskFieldUtil.foneField (telefoneUmFuncionario);
        MaskFieldUtil.foneField (telefoneDoisFuncionario);
        MaskFieldUtil.dateField (dataNasFuncionario.getEditor());
        MaskFieldUtil.cepField (cepFuncionario);
        MaskFieldUtil.cpfField (cpfFuncionario);
    }


    public void senhaPadraoAction(ActionEvent actionEvent){
        if (usuarioTable.getSelectionModel().getSelectedItem()!=null){

        }
    }


    public void atualizarTabela(List<Usuarioview> usuarioList){
        statusColum.setCellValueFactory(new PropertyValueFactory("status"));
        nomeColum.setCellValueFactory(new PropertyValueFactory("nome"));
        emailColum.setCellValueFactory(new PropertyValueFactory("email"));
        cpfColum.setCellValueFactory(new PropertyValueFactory("cpf"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory("naturalidade"));
        tipoAcessoColum.setCellValueFactory(new PropertyValueFactory("tipodeacesso"));
        usuarioTable.getItems().setAll(usuarioList);
    }


    public void limparaCampos(){
        nomeFuncionario.clear();
        naturalidadeFuncionario.clear();
        dataNasFuncionario.clipProperty();
        cpfFuncionario.clear();
        cepFuncionario.clear();
        telefoneUmFuncionario.clear();
        telefoneDoisFuncionario.clear();
        logradouroFuncionario.clear();
        numeroLogragouroFuncionario.clear();
        complementoLogradouroFuncionario.clear();
        bairroFuncionario.clear();
        cidadeFuncionario.clear();
        email.clear();
        dataNasFuncionario.setValue(null);
        usuarioTable.getSelectionModel().select(null);
        comboboxTipoFunacionario.setValue(null);
        comboboxUF.setValue(null);
    }


    //__________________________________________________________________________________________________________________


    @FXML
    public void action(ActionEvent event){

        if (event.getSource() ==  salvarUsuarioButton){
            Usuario usuario = new Usuario ();
            Endereco endereco = new Endereco ();
            Telefone telefone = new Telefone();
            Telefone telefone1 = new Telefone();
            String mensagem = "Salvo com Sucesso!";

            if (usuarioTable.getSelectionModel().getSelectedItem() != null){
                // atualizar o usuário de o usuário já estiver cadastrado
                usuario.setId(usuarioTable.getSelectionModel().getSelectedItem().getPessoa_id());
                endereco.setId(usuarioTable.getSelectionModel().getSelectedItem().getEndereco_id());
                mensagem = "Atualizado com Sucesso!";
                List<Telefone> telefoneList = null;
                telefoneList = Facade.getInstance().findAllIdTelefone(usuario.getId());
                telefone.setId(telefoneList.get(0).getId());
                telefone1.setId(telefoneList.get(1).getId());
            }

            usuario.setNome (nomeFuncionario.getText ());
            usuario.setNaturalidade (naturalidadeFuncionario.getText ());

            usuario.setCpf (cpfFuncionario.getText ());
            usuario.setEmail (email.getText ());
            usuario.setStatus(true);
            usuario.setSenha(novaSenhaGetText.getText());

            usuario.setDataNascimento(dataNasFuncionario.getValue());

            endereco.setBairro (bairroFuncionario.getText ());
            endereco.setCep (cepFuncionario.getText ());
            endereco.setCidade (cidadeFuncionario.getText ());
            endereco.setComplemento (complementoLogradouroFuncionario.getText ());
            endereco.setLogradouro (logradouroFuncionario.getText ());
            endereco.setNumero (numeroLogragouroFuncionario.getText ());
            try {
                endereco.setUf (comboboxUF.valueProperty ().get ().toString ());
                usuario.setTipoDeAcesso (comboboxTipoFunacionario.valueProperty ().get ().toString ());
            }catch (NullPointerException e){
                Mensagem.mensagemErro("Campo não Selecionado! ");
            }

            telefone.setNumero(telefoneUmFuncionario.getText());
            telefone1.setNumero(telefoneDoisFuncionario.getText());
            usuario.setEndereco (endereco);

            usuario = Facade.getInstance ().saveUsuario (usuario);
            telefone.setPessoa(usuario);
            telefone1.setPessoa(usuario);
            Facade.getInstance().saveTelefone(telefone);
            Facade.getInstance().saveTelefone(telefone1);
            atualizarTabela(Facade.getInstance().findAllUsuario());
            limparaCampos();
        }

        if (event.getSource() == novoUsuarioButton){
            limparaCampos();
        }

        if (event.getSource() == destivarUsuarioButton){

        }


    }




    @FXML
    public void redefinirSenhaAction(ActionEvent event){
        try {
            if(usuarioTable.getSelectionModel().getSelectedItem()!=null) {
                Main.genericaStage2(Main.REDEFINIR_SENHA_ADMIN).show();
                Main.changeScreen("", usuarioTable.getSelectionModel().getSelectedItem());
            }else
                Mensagem.mensagemErro("Usuário não Selecionado, Selecicne um usuário e tente novamente!");
        }catch (IOException e){
//            Mensagem.mensagemErro("Erro a carregar a tela de cadastro notas!");
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
