package projeto_pbd.com.br.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadastroAluno implements Initializable {



    @FXML
    private AnchorPane anchorpaneCadastroAluno;
    @FXML
    private AnchorPane anchorpaneCadastroAlunoDependente;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void cadastroAlunoTelaUmDois(){
        this.anchorpaneCadastroAluno.setVisible(false);
        this.anchorpaneCadastroAlunoDependente.setVisible(true);
    }


    public void cadastroAlunoTelaDoisUm(){
        this.anchorpaneCadastroAluno.setVisible(true);
        this.anchorpaneCadastroAlunoDependente.setVisible(false);
    }


    public void salvar(){
        // GERAR BOLETO NO ATO DE SALVAMENTO
        System.out.println("Salvo com sucesso!");
    }







}
