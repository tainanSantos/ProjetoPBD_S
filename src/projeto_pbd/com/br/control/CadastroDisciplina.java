package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroDisciplina implements Initializable {

    @FXML
    private TextField codigoText;
    @FXML
    private TextField disciplinaText;
    @FXML
    private TextField cargaHorariaText;
    @FXML
    private TextField professorPesquisaText;
    @FXML
    private TableView<Disciplina> disciplinasTable;
    @FXML
    private TableColumn codigoColumm;
    @FXML
    private TableColumn disciplinaColumm;
    @FXML
    private TableColumn cargaHorariaColumm;
    @FXML
    private TableView<Professor> professoresCadastradosTable;
    @FXML
    private TableColumn professoresCadastradosColumm;



    public CadastroDisciplina() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

        carregraTabela ();

        this.disciplinasTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableDisciplina(newValue));

        this.professoresCadastradosTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableProfessor(newValue));
    }


    public void setCamposTableDisciplina(Disciplina disciplina){

        this.disciplinaText.setText (disciplina.getNome ());
        this.cargaHorariaText.setText (String.valueOf (disciplina.getCargaHoaria ()));

    }

    public void setCamposTableProfessor(Professor professor){
        this.professorPesquisaText.setText (professor.getNome ());
    }


    public void carregraTabela(){

        codigoColumm.setCellValueFactory(new PropertyValueFactory<> ("codigo"));
        disciplinaColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        cargaHorariaColumm.setCellValueFactory(new PropertyValueFactory<> ("cargaHoaria"));
        disciplinasTable.setItems (FXCollections.observableArrayList (Facade.getInstance ().findAllDisciplina ()));

        professoresCadastradosColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        professoresCadastradosTable.setItems (FXCollections.observableArrayList (Facade.getInstance ().findAllProfessor ()));
    }


    public void salvarDisciplinas() {
        Disciplina d =  new Disciplina ();
        String mensagem = "Salvo com Sucesso!";
        d.setNome (disciplinaText.getText ());
        d.setCargaHoaria (Double.parseDouble (cargaHorariaText.getText ()));
        Facade.getInstance ().saveDisciplina (d);
        novoCadastro ();
        Mensagem.mensagemSucesso (mensagem);
    }


    public void novoCadastro(){
        this.disciplinaText.clear();
        this.cargaHorariaText.clear();
        this.professorPesquisaText.clear();
        carregraTabela ();
    }


    public void deletarDisciplina(){
        novoCadastro ();
    }


    public void buscarProfessor(){

    }

}
