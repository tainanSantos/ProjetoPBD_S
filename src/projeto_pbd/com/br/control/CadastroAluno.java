package projeto_pbd.com.br.control;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.util.MaskFieldUtil;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class CadastroAluno implements Initializable {

    private Aluno aluno;

    @FXML
    private TextField nomeText;
    @FXML
    private TextField naturalidadedText;
    @FXML
    private TextField dataText;
    @FXML
    private TextField cepText;
    @FXML
    private TextField telefoneUmText;
    @FXML
    private TextField telefoneDoisText;
    @FXML
    private TextField numeroText;
    @FXML
    private TextField complementoText;
    @FXML
    private TextField bairroText;
    @FXML
    private TextField cidadeText;
    @FXML
    private TextField nomeMaeText;
    @FXML
    private TextField nomePaiText;
    @FXML
    private ComboBox comboboxUf;

    private List listUfsAlun = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    public CadastroAluno() {
        aluno = new Aluno ();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsAlun));

        // cpf só será obrigatório de o aluno também for responsável
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
        MaskFieldUtil.foneField (this.telefoneUmText);
    }


    public void cadastroAlunoTelaUmDois(){

    }


    public void  salvarAluno(){
        // GERAR BOLETO NO ATO DE SALVAMENTO


    }


    public void formatarPdf(){
        // todas as formatações do pdf devem ser feitas aqui
        // questões de tabelas, exibição de conteúdo, etc.
    }




}
