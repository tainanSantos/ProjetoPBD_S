package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Disciplina;

import java.io.IOException;

public class CadastroCurriculo  {

    private Disciplina disciplina;
    private Curriculo curriculo;


    @FXML
    private TableView<Curriculo> curriculoTable;

    @FXML
    private TableColumn codigoCurriculoColumm;

    @FXML
    private TableColumn nomeCurriculoColumm;

    @FXML
    private TextField codigoText;

    @FXML
    private TextField nomeCurriculoText;

    @FXML
    private TextField disciplinaText;

    @FXML
    private TableView<Disciplina> disciplinasTable;

    @FXML
    private TableColumn deisciplinasCadastradasColumm;



    public CadastroCurriculo() {

       this.disciplina = new Disciplina ();
       this.curriculo = new Curriculo ();

    }


    // se der erro foi aqui que eu modifiquei
    // so implmentar a Interface Initializabel novamente e sobreescrever o método
    @FXML
    public void initialize() {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

        carregarTabelas ();

        this.disciplinasTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableDisciplina(newValue));

        this.curriculoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCamposTableCurriculo(newValue));
    }


    public void setCamposTableDisciplina(Disciplina disciplina){
        this.disciplinaText.setText (disciplina.getNome ());
        if (disciplina.getCurriculo ()!=null) {
//            this.codigoText.setText (disciplina.getCurriculo ( ).getCodigo ( ));
            this.nomeCurriculoText.setText (disciplina.getCurriculo ( ).getNome ( ));
        }else{
            this.codigoText.setText (null);
            this.nomeCurriculoText.setText (null);
        }
        setDisciplina (disciplina);
    }


    public void setCamposTableCurriculo(Curriculo curriculo){
//        this.codigoText.setText (curriculo.getCodigo ());
        this.nomeCurriculoText.setText (curriculo.getNome ());
        setCurriculo (curriculo);
    }

    public void carregarTabelas(){
        deisciplinasCadastradasColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        disciplinasTable.setItems (FXCollections.observableArrayList (Facade.getInstance ().findAllDisciplina ()));

        codigoCurriculoColumm.setCellValueFactory(new PropertyValueFactory<> ("codigo"));
        nomeCurriculoColumm.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        curriculoTable.setItems (FXCollections.observableArrayList (Facade.getInstance ().findAllCurriculo ()));
    }


    @FXML
    void apagarCurriculo() {
        carregarTabelas ();
    }

    @FXML
    void salvarCurriculo() {
        Curriculo curriculo_novo = new Curriculo ();
        if (getCurriculo ()!=null) {
            curriculo_novo = getCurriculo ();
            if (getDisciplina ()!=null){
                getDisciplina ().setCurriculo (curriculo_novo);
            }
        }
//        curriculo_novo.setCodigo (codigoText.getText ());
        curriculo_novo.setNome (nomeCurriculoText.getText ());
        Facade.getInstance ().saveCurriculo (curriculo_novo);
        Facade.getInstance ().saveDisciplina (getDisciplina ());
        novoCurriculo ();
    }

    @FXML
    void novoCurriculo() {

        this.codigoText.setText (null);
        this.nomeCurriculoText.setText (null);
        this.disciplinaText.setText (null);
        setCurriculo (null);
        setDisciplina (null);
        carregarTabelas ();
    }

    public void cadastrarNovaDisciplina() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_DISCIPLINA);
        stage.show ();
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }


}
