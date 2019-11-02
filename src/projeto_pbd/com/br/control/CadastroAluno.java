package projeto_pbd.com.br.control;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.util.MaskFieldUtil;


import java.io.IOException;
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
    private TextField cpfResponsavelText;

    @FXML
    private Label cpfLabel;

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
    private ComboBox<?> comboboxUf;

    @FXML
    private Label cadastroAlunoResponsávelLabes;

    @FXML
    private AnchorPane filiacaoPane;

    @FXML
    private TextField nomeMaeText;

    @FXML
    private TextField nomePaiText;

    @FXML
    private Label maiorDeIdadeMensagemLabel;

    @FXML
    private TextField nomeText1Resp;

    @FXML
    private TextField naturalidadedText1Resp;

    @FXML
    private TextField dataText1Resp;

    @FXML
    private TextField cpfResponsavelText1Resp;

    @FXML
    private Label cpfLabel1;

    @FXML
    private TextField cepText1Resp;

    @FXML
    private TextField telefoneUmText1Resp;

    @FXML
    private TextField telefoneDoisText1Resp;

    @FXML
    private TextField logradouroText1Resp;

    @FXML
    private TextField numeroText1Resp;

    @FXML
    private TextField complementoText1Resp;

    @FXML
    private TextField bairroText1Resp;

    @FXML
    private TextField cidadeText1Resp;

    @FXML
    private ComboBox<?> comboboxUf1Resp;

    @FXML
    private Button salvarButton;

    @FXML
    private Label cadastroAlunoResponsávelLabes1;

    @FXML
    private Label maiorDeIdadeMensagemLabel1;

    @FXML
    private RadioButton maiorDeIdadeRadioButton;




    private List listUfsAlun = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    public CadastroAluno() {
        aluno = new Aluno ();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });


        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsAlun));
        this.comboboxUf1Resp.setItems(FXCollections.observableArrayList (this.listUfsAlun));

        // cpf só será obrigatório de o aluno também for responsável
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
        MaskFieldUtil.foneField (this.telefoneUmText);
    }


    @FXML
    void actionEvente(ActionEvent event) {

        if (event.getSource() == salvarButton){
            // SALVAR ALUNO E RESPONÁVELA
        }
        /*
        * se o aluno for maior de idade ele
        * disponibilizar a opção para ele escolher se quer ser responsável financeira por ele mesmo
        * se ele selecionar a opção, então setar o texto dos campos do aluno para o responsável finanaceiro
        */
    }


    public void limparCampos(){

        // aluno
        nomeText.clear();
        naturalidadedText.clear();
        dataText.clear();
        cpfResponsavelText.clear();
        cepText.clear();
        telefoneUmText.clear();
        telefoneDoisText.clear();
        logradouroText.clear();
        numeroText.clear();
        complementoText.clear();
        bairroText.clear();
        cidadeText.clear();
        comboboxUf.getClip();
        nomeMaeText.clear();
        nomePaiText.clear();

        // responsável
        nomeText1Resp.clear();
        naturalidadedText1Resp.clear();
        dataText1Resp.clear();
        cpfResponsavelText1Resp.clear();
        cepText1Resp.clear();
        telefoneUmText1Resp.clear();
        telefoneDoisText1Resp.clear();
        logradouroText1Resp.clear();
        numeroText1Resp.clear();
        complementoText1Resp.clear();
        bairroText1Resp.clear();
        cidadeText1Resp.clear();
        comboboxUf1Resp.getClip();
        maiorDeIdadeRadioButton.setVisible(false);
    }

}
