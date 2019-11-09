package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import projeto_pbd.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.util.MaskFieldUtil;

public class AreaDiscente implements Initializable {

    @FXML
    private Tab pequisaMenu;
    @FXML
    private Button pesquisaAlunoButton;
    @FXML
    private Tab novoMenu;
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
    private ComboBox comboboxUf;
    @FXML
    private ComboBox ensinoComboBox;
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
    private Button salvarAlunoButton;
    @FXML
    private Button apagraAlunoButton;
    @FXML
    private Label cadastroAlunoResponsávelLabes1;
    @FXML
    private Label maiorDeIdadeMensagemLabel1;
    @FXML
    private RadioButton maiorDeIdadeRadioButton;

    private List listUfsAlun = new ArrayList(Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    private List listUfsEnsino = new ArrayList(Arrays.asList (new String[]{"- EF-AI-1", "- EF-AI-2a5",
            "- EF-AF-6a8", "- EF-AI-9", "- EF-AI-1", "- EM-1", "- EM-2", "- EM-3", } ));
    //____
    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                //??
            }
        });

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsAlun));
        this.comboboxUf1Resp.setItems(FXCollections.observableArrayList (this.listUfsAlun));
        this.ensinoComboBox.setItems(FXCollections.observableArrayList(this.listUfsEnsino));
        // cpf só será obrigatório de o aluno também for responsável
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
        MaskFieldUtil.foneField (this.telefoneUmText);
    }

    //__________________________________________________________________________________________________________________

    public void carregarTabela(){

    }


    public void limparCampos(){

    }

    //__________________________________________________________________________________________________________________


    @FXML
    public void action(ActionEvent event){

        if (event.getSource() ==  salvarAlunoButton){

        }
        if (event.getSource() == apagraAlunoButton){

        }
        if (event.getSource() == pesquisaAlunoButton){

        }
        if (event.getSource() == pequisaMenu){

        }
        if (event.getSource() == novoMenu){
            limparCampos();
        }

    }

}
