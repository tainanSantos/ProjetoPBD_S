package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;
import projeto_pbd.com.br.util.ObjetctUtil;

import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.*;


public class CadastroProfessor implements Initializable {


    private IFacadeProfessor facadeProfessor;


    @FXML
    private TextField graduacaoText;
    @FXML
    private TextField nomeText;
    @FXML
    private TextField naturalidadeText;
    @FXML
    private TextField dataText;
    @FXML
    private TextField cpfText;
    @FXML
    private TextField cepText;
    @FXML
    private TextField telefoneUmText;
    @FXML
    private TextField telefoneDoisText;
    @FXML
    private TextField logradouroText;
    @FXML
    private TextField numeroText;
    @FXML
    private TextField complementoText;
    @FXML
    private TextField bairroText;
    @FXML
    private TextField cidadeText;
    @FXML
    private ComboBox comboboxUf;
    @FXML
    private Button apagarButton;


    private List listUfsProf = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    public CadastroProfessor() {
        this.facadeProfessor = new FacadeProfessor ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));

        if (ObjetctUtil.getObject () != null){
            apagarButton.setVisible (true);
           carregarObjetoSelecioando ();
        }
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
    }



    public void carregarObjetoSelecioando(){

        Professor professor = null;
        professor = (Professor) ObjetctUtil.getObject ();

        logradouroText.setText (professor.getEndereco ().getLogradouro ());
        numeroText.setText (professor.getEndereco ().getNumero ());
        complementoText.setText (professor.getEndereco ().getComplemento ());
        bairroText.setText (professor.getEndereco ().getBairro ());
        cidadeText.setText (professor.getEndereco ().getCidade ());
        cepText.setText (professor.getEndereco ().getCep ());

        comboboxUf.getSelectionModel().select(professor.getEndereco ().getUf ());

        telefoneUmText.setText (professor.getTelefones ().get (0).getNumero ());
        telefoneDoisText.setText (professor.getTelefones ().get (1).getNumero ());

        nomeText.setText (professor.getNome ());
        dataText.setText (String.valueOf (professor.getDataNascimento ()));
        naturalidadeText.setText (professor.getNaturalidade ());
        cpfText.setText (professor.getCpf ());
        graduacaoText.setText (professor.getGraduacao ());

    }



    public void salvarCadastro() {
        Professor professor = new Professor ();
        Endereco endereco = new Endereco ();
        Telefone telefone = new Telefone ();
        Telefone telefone1 = new Telefone ();

        String mensagem = "Salvo com Sucesso!";


        if (ObjetctUtil.getObject () != null){

            mensagem = "Atualizado com Sucesso!";
            professor = (Professor) ObjetctUtil.getObject ();

            System.out.println (professor.getId ());
            endereco = professor.getEndereco ();
            telefone = professor.getTelefones ().get (0);
            telefone1 = professor.getTelefones ().get (1);

        }

        endereco.setLogradouro (logradouroText.getText ());
        endereco.setNumero (numeroText.getText ());
        endereco.setComplemento (complementoText.getText ());
        endereco.setBairro (bairroText.getText ());
        endereco.setCidade (cidadeText.getText ());
        endereco.setCep (cepText.getText ());
        endereco.setUf (comboboxUf.valueProperty ().get ().toString ());


        telefone.setNumero (telefoneUmText.getText ());
        telefone1.setNumero (telefoneDoisText.getText ());

        List<Telefone> telefones = new ArrayList (Arrays.asList (new Telefone[]{telefone, telefone1}));

        professor.setCpf (cpfText.getText ());
        professor.setDataNascimento ((Date) dataText.getUserData ());
        professor.setNaturalidade (naturalidadeText.getText ());
        professor.setNome (nomeText.getText ());
        professor.setGraduacao (graduacaoText.getText ());

        professor.setEndereco (endereco);
        telefone.setProfessor (professor);
        telefone1.setProfessor (professor);
        professor.setTelefones (telefones);

        this.facadeProfessor.save (professor);

        Stage stage = null;
        stage = Main.STAGE;
        stage.getOnCloseRequest ().handle (
                new javafx.stage.WindowEvent (
                        stage, javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST));
        stage.close ();

        ObjetctUtil.setObject (null);
        Mensagem.mensagemSucesso (mensagem);
    }


    public void deletarCadastro(){
        Professor professor = (Professor) ObjetctUtil.getObject ();
        this.facadeProfessor.remove (professor.getId ());
        Stage stage = null;
        stage = Main.STAGE;
        stage.getOnCloseRequest ().handle (
                new javafx.stage.WindowEvent (
                        stage, javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST));
        stage.close ();
        Mensagem.mensagemSucesso ("Removido com sucesso!");

    }

}
