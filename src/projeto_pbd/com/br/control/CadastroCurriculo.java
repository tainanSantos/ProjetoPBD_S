package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroCurriculo  implements Initializable {


    @FXML
    private TableView<Disciplina> disciplinasTable;
    @FXML
    private TableColumn<Disciplina, Boolean> selecionarDisciplinaColum;
    @FXML
    private TableColumn<?, ?> nomeDisciplinaColumm;
    @FXML
    private TableColumn<?, ?> cargaHorariaDisciplinaColumm;
    @FXML
    private TextField nomeCurriculoText;
    @FXML
    private Button novoCurriculoButton;
    @FXML
    private Button salvarCurriculoButton;
    @FXML
    private TextField pequisarDisciplinaText;
    @FXML
    private Button pesquisarDisciplinaButton;
    @FXML
    private TextField disciplinaText;
    @FXML
    private TextField cargaHorariaText;
    @FXML
    private Button apagarDisciplinaButton;
    @FXML
    private Button salvarDisciplinaButton;
    @FXML
    private Button novaDiplinaButton;
    @FXML
    private Button professorPesquisaButton;
    @FXML
    private TextField professorPesquisaText;


    private CheckBoxTableCell<Disciplina, Boolean> comCheckBoxTableCell;


    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        carregarTable(Facade.getInstance().findAllDisciplina());

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                if (newScene.equalsIgnoreCase("AreaPorfessor.fxml")){
                    Professor professor = null;
                    professor = (Professor)userData;
                    professorPesquisaText.setText(professor.getNome());
                }
            }
        });
    }


    public void carregarTable(List<Disciplina> disciplinas){
        nomeDisciplinaColumm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cargaHorariaDisciplinaColumm.setCellValueFactory(new PropertyValueFactory<>("cargaHoaria"));
        selecionarDisciplinaColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        selecionarDisciplinaColum.setCellFactory(comCheckBoxTableCell.forTableColumn((selecionarDisciplinaColum)));

        disciplinasTable.getItems().setAll(disciplinas);
    }


    public void limparCampos(){
        disciplinasTable.getSelectionModel().select(null);
        disciplinaText.clear();
        cargaHorariaText.clear();
    }

    //__________________________________________________________________________________________________________________


    @FXML
    void action(ActionEvent event) {


        //EVENTOS PARA DISCIPLINA

        if (event.getSource() == salvarDisciplinaButton){

            Disciplina disciplina =  new Disciplina();

            disciplina.setNome(disciplinaText.getText());
            disciplina.setCargaHoaria(Integer.parseInt(cargaHorariaText.getText()));
            disciplina.setStatus(true);
            Facade.getInstance().saveDisciplina(disciplina);
            limparCampos();
            Mensagem.mensagemSucesso("Salvo com Sucesso!");
            carregarTable(Facade.getInstance().findAllDisciplina());

        }

        if (event.getSource() == novaDiplinaButton){
            limparCampos();
        }

        if (event.getSource() == apagarDisciplinaButton){
            Facade.getInstance().removeDisciplina(disciplinasTable.getSelectionModel().getSelectedItem().getId());
            Mensagem.mensagemSucesso("Excluido com Sucesso!");
            carregarTable(Facade.getInstance().findAllDisciplina());
        }

        if (event.getSource() == pesquisarDisciplinaButton){

        }


        //EVENTOS PARA CURRICULO

        if (event.getSource() == salvarCurriculoButton){

        }

        if (event.getSource() == novoCurriculoButton){

        }

        //PESQUISA PROFESSOR
        if (event.getSource() == professorPesquisaButton){
            try {
                Main.genericaStage(Main.AREA_PROFESSOR).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.changeScreen("CadastroCurriculo.fxml", null);
        }
    }





    //__________________________________________________________________________________________________________________


}
