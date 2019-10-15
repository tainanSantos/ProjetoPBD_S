package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroProfessorPedagogo implements Initializable {

    private AnchorPane salvarCadastroFuncionario;

    @FXML
    private AnchorPane graduacaoText;

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
    private ComboBox<?> comboboxUf;

    @FXML
    private TextField areaDeFormacaoFuncionario;

    @FXML
    private ComboBox comboboxTipoCadastro;

    private List listUfsProf = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));
    private List listTipoCadastro = new ArrayList(Arrays.asList (new String[]{"Professor", "Pedagogo"}));


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));
        this.comboboxTipoCadastro.setItems (FXCollections.observableArrayList (this.listTipoCadastro));

    }






    public void salvarCadastro(){



        Mensagem.mensagemSucesso ("Cadastro Realizado com sucesso!");

    }




}
