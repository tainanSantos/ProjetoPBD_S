package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Turma;
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TurmaGerenciamento implements Initializable {

    @FXML
    private TextField pesquisarTurmaText;
    @FXML
    private TableView<Turma> turmaCurriculoTable;
    @FXML
    private TableColumn<?, ?> nomeTurmaColumn;
    @FXML
    private TableColumn<?, ?> qtdAlunosColumn;
    @FXML
    private TextField nomeTurmaText;
    @FXML
    private Button salvarTurmaButton;
    @FXML
    private Button novaTurmaButton;
    @FXML
    private Button apagarTurmaButton;


    //__________________________________________________________________________________________________________________


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        atualizarTabelaTurmas(Facade.getInstance().findAllTurma());

        turmaCurriculoTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nomeTurmaText.setText(turmaCurriculoTable.getSelectionModel().getSelectedItem().getNomeTurma());
            }
        });


    }


    public  void atualizarTabelaTurmas(List<Turma> turmaList){
        nomeTurmaColumn.setCellValueFactory(new PropertyValueFactory<>("nomeTurma"));
        qtdAlunosColumn.setCellValueFactory(new PropertyValueFactory<>("qtdAlunos"));
        turmaCurriculoTable.getItems().setAll(turmaList);
    }


    //__________________________________________________________________________________________________________________

    @FXML
    void pesquisarTurmaAction(KeyEvent event) {

    }

    @FXML
    void salvarTurmaAction(ActionEvent event) {
        Turma turma = new Turma();
        if (turmaCurriculoTable.getSelectionModel().getSelectedItem()!= null)
            turma.setId(turmaCurriculoTable.getSelectionModel().getSelectedItem().getId());
        turma.setNomeTurma(nomeTurmaText.getText());
        Facade.getInstance().saveTurma(turma);
        atualizarTabelaTurmas(Facade.getInstance().findAllTurma());
        Mensagem.mensagemSucesso("Sucesso!");
        nomeTurmaText.clear();
    }

    @FXML
    void novaTurmaAction(ActionEvent event){
        nomeTurmaText.clear();
        turmaCurriculoTable.getSelectionModel().select(null);

    }

    @FXML
    void apagarTurmaAction(ActionEvent event){
        Facade.getInstance().removeTurma(turmaCurriculoTable.getSelectionModel().getSelectedItem().getId());
        Mensagem.mensagemSucesso("Sucesso!");

    }


}
