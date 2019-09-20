package projeto_pbd.com.br.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Pesquisa implements Initializable {


    @FXML
    private ComboBox comboBoxAlunosOutro;
    @FXML
    private TableView tableViewAluno;
    @FXML
    private TableView tableViewOutros;

    private ArrayList alunoOutroList = new ArrayList();


    public void setarTabelaPesquisa() {
        if(comboBoxAlunosOutro.getSelectionModel().getSelectedIndex() == 0){
            this.tableViewOutros.setVisible(false);
            this.tableViewAluno.setVisible(true);
        }
        if(comboBoxAlunosOutro.getSelectionModel().getSelectedIndex() != 0){
            this.tableViewAluno.setVisible(false);
            this.tableViewOutros.setVisible(true);
        }
    }

    public void carregarComboBox(){
        alunoOutroList.add("aluno");
        alunoOutroList.add("pedagogo");
        alunoOutroList.add("pessoa");
        alunoOutroList.add("professor");
        alunoOutroList.add("responsável");
        comboBoxAlunosOutro.setItems(FXCollections.observableArrayList(alunoOutroList));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBox();
    }

}
