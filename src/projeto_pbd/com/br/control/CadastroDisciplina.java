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
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroDisciplina implements Initializable {

    private IFacadeProfessor facadeProfessor;
    private IFacadeDisciplina facadeDisciplina;
    private Disciplina disciplina;

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
    private TableColumn professorColumm;

    @FXML
    private ComboBox comboboxProfessoresCadastrados;

    @FXML
    private Spinner iconeAtualizar;




    public CadastroDisciplina() {
        this.facadeProfessor = new FacadeProfessor ();
        this.facadeDisciplina = new FacadeDisciplina ();
        this.disciplina = new Disciplina ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.disciplinasTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTable(newValue));
    }


    public void setCamposTable(Disciplina disciplina){

        this.codigoText.setText (disciplina.getCodigo ());
        this.disciplinaText.setText (disciplina.getNome ());
        this.cargaHorariaText.setText (String.valueOf (disciplina.getCargaHoaria ()));

        setDisciplina (disciplina);
    }


    public void carregraTabela(){

        codigoColumm.setCellValueFactory(new PropertyValueFactory<> ("codigo"));
        disciplinaColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        cargaHorariaColumm.setCellValueFactory(new PropertyValueFactory<> ("cargaHoaria"));
//        professorColumm.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        disciplinasTable.setItems (FXCollections.observableArrayList (this.facadeDisciplina.findAll ()));
    }


    public void salvarDisciplinas() {
        Disciplina disciplina =  new Disciplina ();
        if (getDisciplina ()!=null)disciplina = getDisciplina ();
        disciplina.setNome (disciplinaText.getText ());
        disciplina.setCargaHoaria (Double.parseDouble (cargaHorariaText.getText ()));
        disciplina.setCodigo (codigoText.getText ());
//        disciplina.setProfessor (???)
        this.facadeDisciplina.save (disciplina);
        novoCadastro ();

    }

    public void novoCadastro(){
        this.codigoText.setText (null);
        this.disciplinaText.setText (null);
        this.cargaHorariaText.setText (null);
        setDisciplina (null);
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
}
