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
import java.util.ResourceBundle;

public class CadastroProfessor implements Initializable {

    @FXML
    private AnchorPane anchorpaneCadastroAluno;
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
    private TextField cpfFuncionario;
    @FXML
    private TextField orgaoEspeditoRgFuncionario;
    @FXML
    private TextField reFuncionario;
    @FXML
    private TextField numeroMatriculaFuncionario;
    @FXML
    private TextField emailAcademicoFuncionario;
    @FXML
    private TextField areaDeFormacaoFuncionario;
    @FXML



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }






    public void salvarCadastroFuncionario(){
        Mensagem.mensagemSucesso ("Cadastro Realizado com sucesso!");
    }


}
