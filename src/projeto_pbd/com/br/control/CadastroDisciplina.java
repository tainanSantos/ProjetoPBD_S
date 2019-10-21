package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto_pbd.com.br.façade.FacadeDisciplina;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadeDisciplina;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroDisciplina implements Initializable {

    private IFacadeProfessor facadeProfessor;
    private IFacadeDisciplina facadeDisciplina;
    private Disciplina disciplina;
    private Professor professor;

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
        this.facadeProfessor = new FacadeProfessor ();
        this.facadeDisciplina = new FacadeDisciplina ();
        this.disciplina = new Disciplina ();
        this.professor = new Professor ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.disciplinasTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableDisciplina(newValue));

        this.professoresCadastradosTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableProfessor(newValue));
    }


    public void setCamposTableDisciplina(Disciplina disciplina){



        this.codigoText.setText (disciplina.getCodigo ());
        this.disciplinaText.setText (disciplina.getNome ());
        this.cargaHorariaText.setText (String.valueOf (disciplina.getCargaHoaria ()));
        if (disciplina.getProfessor () != null)
            this.professorPesquisaText.setText (disciplina.getProfessor ().getNome ());
        else this.professorPesquisaText.setText (null);
        setDisciplina (disciplina);
    }

    public void setCamposTableProfessor(Professor professor){

        this.professorPesquisaText.setText (professor.getNome ());
        setProfessor (professor);
    }


    public void carregraTabela(){

        codigoColumm.setCellValueFactory(new PropertyValueFactory<> ("codigo"));
        disciplinaColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        cargaHorariaColumm.setCellValueFactory(new PropertyValueFactory<> ("cargaHoaria"));
        disciplinasTable.setItems (FXCollections.observableArrayList (this.facadeDisciplina.findAll ()));

        professoresCadastradosColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        professoresCadastradosTable.setItems (FXCollections.observableArrayList (this.facadeProfessor.findAll ()));
    }


    public void salvarDisciplinas() {
        Disciplina d =  new Disciplina ();
        String mensagem = "Salvo com Sucesso!";
        if (getDisciplina ()!=null){
            d = getDisciplina ();
            if (getProfessor ()!=null) d.setProfessor (getProfessor ());
            mensagem = "Dados Atualizados com Sucesso!";
        }
        d.setNome (disciplinaText.getText ());
        d.setCargaHoaria (Double.parseDouble (cargaHorariaText.getText ()));
        d.setCodigo (codigoText.getText ());
        this.facadeDisciplina.save (d);
        novoCadastro ();
        Mensagem.mensagemSucesso (mensagem);
    }


    public void novoCadastro(){
        this.codigoText.setText (null);
        this.disciplinaText.setText (null);
        this.cargaHorariaText.setText (null);
        this.professorPesquisaText.setText (null);
        setDisciplina (null);
        setProfessor (null);
        carregraTabela ();
    }


    public void deletarDisciplina(){
        if(getDisciplina () != null) this.facadeDisciplina.remove (getDisciplina ().getId ());
        else Mensagem.mensagemErro ("Selecione Antes Uma Disciplina");
        novoCadastro ();
    }


    public void buscarProfessor(){

    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
