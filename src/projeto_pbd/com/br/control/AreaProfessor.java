package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.FacadePedagogo;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadePedagogo;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.util.ObjetctUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaProfessor implements Initializable {

    private IFacadeProfessor facadeProfessor;
    private IFacadePedagogo facadePedagogo;

    @FXML
    private TableView<Professor> educandoTable;
    @FXML
    private TableColumn nomeColum;
    @FXML
    private TableColumn graduacaoColum;
    @FXML
    private TableColumn naturalidadeColum;
    @FXML
    private TextField pesquisaText;


    List listEducando = new ArrayList (Arrays.asList ("Professores", "Pedagogos"));



    public AreaProfessor() {
        this.facadeProfessor = new FacadeProfessor ();
        this.facadePedagogo = new FacadePedagogo ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        educandoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> seteducandoTable(newValue));

   }



    public void cadastrarNovoProfessor() throws IOException {
        Stage stage = null;
        stage = Main.genericaStage (Main.CADASTRO_PROFESSOR);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                atualizarTabela ();
            }});
        stage.show ();
    }


    public void atualizarTabela(){
            carregarTable (this.facadeProfessor.findAll ()); //professores
    }


    public void carregarTable(List  arrayList){

        List<Professor> professors = new ArrayList<> ();
        professors.addAll (arrayList);
        nomeColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        educandoTable.setItems (FXCollections.observableArrayList (professors));

    }


    public void seteducandoTable(Professor professor){

        this.educandoTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2) {
                ObjetctUtil.setObject (professor);
                Stage stage = null;
                try {
                    stage = Main.genericaStage (Main.CADASTRO_PROFESSOR);
                    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent event) {
                            atualizarTabela ();
                        }});
                    stage.show ();
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        });
    }

}
