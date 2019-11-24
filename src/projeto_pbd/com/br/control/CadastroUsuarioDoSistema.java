package projeto_pbd.com.br.control;

/*
* com retorno   PROSSIDURE
* sem retorno   FUNÇÃO
* */

/*
* a estory procidure é uma função que não esta assosciada a tabela
* gatilho é uma função assonciada a tabela que quando acontecer alguma coisa na tebela ele é incocado
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
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

//    private List<Usuario> usuarioLis = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        setUsuarioLis(Facade.getInstance().findAllUsuario());
//        atualizarTabela(getUsuarioLis());

        //RESTRIÇÃO DE ACESSO
        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    break;
                case ("Direção"):
                    System.out.println("Direção");
                    break;
                case ("Coordenação Pedagogica"):
                    System.out.println("Cood Ped");
                    break;
                case ("Secretaria"):
                    System.out.println("Secretaria");
                    break;
            }
        }


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
                        Usuario usuario = null;
                        usuario = usuarioTable.getSelectionModel().getSelectedItem();
                        logradouroFuncionario.setText(usuario.getEndereco().getLogradouro());
                        numeroLogragouroFuncionario.setText(usuario.getEndereco().getNumero());
                        complementoLogradouroFuncionario.setText(usuario.getEndereco().getComplemento());
                        bairroFuncionario.setText(usuario.getEndereco().getBairro());
                        cidadeFuncionario.setText(usuario.getEndereco().getCidade());
                        comboboxUF.setValue(usuario.getEndereco().getUf());
                        comboboxTipoFunacionario.setValue(usuario.getTipoDeAcesso());

                        email.setText(usuario.getEmail());
                        cepFuncionario.setText(usuario.getEndereco().getCep());
                        cpfFuncionario.setText(usuario.getCpf());

                        dataNasFuncionario.setValue(usuario.getDataNascimento()); // ainda não implementado

                        naturalidadeFuncionario.setText(usuario.getNaturalidade());
                        nomeFuncionario.setText(usuario.getNome());
                        List<Telefone> telefoneList = null;
                        telefoneList = Facade.getInstance().findAllIdTelefone(usuario.getId());

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




    public void atualizarTabela(List<Usuario> usuarioList){
        statusColum.setCellValueFactory(new PropertyValueFactory("status"));
        nomeColum.setCellValueFactory(new PropertyValueFactory("nome"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory("naturalidade"));
        tipoAcessoColum.setCellValueFactory(new PropertyValueFactory("tipoDeAcesso"));
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
//                usuario.setId(usuarioTable.getSelectionModel().getSelectedItem().getId());
//                endereco.setId(usuarioTable.getSelectionModel().getSelectedItem().getEndereco().getId());
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
            usuario.setSenha(funcaoCript(senhaPadrao()));

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

        if (event.getSource() == pesquisarUsuarioButton){
            atualizarTabela(Facade.getInstance().findAllUsuarioNome(pesquisaText.getText()));
        }
    }


    public String funcaoCript(String string){
        String plaintext = string;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        return hashtext;
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
