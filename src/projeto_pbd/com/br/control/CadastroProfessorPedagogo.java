package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroProfessorPedagogo implements Initializable {


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
    private ComboBox comboboxTipoCadastro;


    private List listUfsProf = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));
    private List listTipoCadastro = new ArrayList(Arrays.asList (new String[]{"Professor", "Pedagogo"}));


    public CadastroProfessorPedagogo() {
        this.facadeProfessor = new FacadeProfessor ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));
        this.comboboxTipoCadastro.setItems (FXCollections.observableArrayList (this.listTipoCadastro));


        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);

    }


    public void salvarCadastro(){

        Endereco endereco = new Endereco ();
        endereco.setLogradouro (logradouroText.getText ());
        endereco.setNumero (numeroText.getText ());
        endereco.setComplemento (complementoText.getText ());
        endereco.setBairro (bairroText.getText ());
        endereco.setCidade (cidadeText.getText ());
        endereco.setCep (cepText.getText ());
        endereco.setUf (comboboxUf.valueProperty ().get ().toString ());

        Telefone telefone = new Telefone ();
        Telefone telefone1 = new Telefone ();
        telefone.setNumero (telefoneUmText.getText ());
        telefone1.setNumero (telefoneDoisText.getText ());

        List<Telefone> telefones = new ArrayList (Arrays.asList (new Telefone[]{telefone,telefone1}));

        if (comboboxTipoCadastro.getSelectionModel ().getSelectedIndex () == 0){
            // SALVAR PROFESSOR
            Professor professor = new Professor ();
            professor.setCpf (cpfText.getText ());
            professor.setDataNascimento (dataText.getText ());
            professor.setNaturalidade (naturalidadeText.getText ());
            professor.setNome (nomeText.getText ());
            professor.setGraduacao (graduacaoText.getText ());


            professor.setEndereco (endereco);
            telefone.setProfessor (professor);
            telefone1.setProfessor (professor);
            professor.setTelefones (telefones);

            this.facadeProfessor.save (professor);

        }else if(comboboxTipoCadastro.getSelectionModel ().getSelectedIndex () == 1){
            // SALVAR PEDAGOGO
            Pedagogo pedagogo = new Pedagogo ();
            pedagogo.setCpf (cpfText.getText ());
            pedagogo.setDataNascimento (dataText.getText ());
            pedagogo.setNaturalidade (naturalidadeText.getText ());
            pedagogo.setNome (nomeText.getText ());
            pedagogo.setGraduacao (graduacaoText.getText ());


            pedagogo.setEndereco (endereco);
            telefone.setPedagogo (pedagogo);
            telefone1.setPedagogo (pedagogo);
            pedagogo.setTelefones (telefones);
        }
    }




}
