package projeto_pbd.com.br.control;

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
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Professor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaProfessor implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

        this.educandoTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2) {
                Stage stage = null;
                try {
                    stage = Main.genericaStage2 (Main.CADASTRO_PROFESSOR);
                    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent event) {
                            carregarTable ();
                        }});
                    stage.show ();
                    Main.changeScreen("AreaProfessor.fxml_atualzar", educandoTable.getSelectionModel().getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        });

        carregarTable ();


   }



    public void cadastrarNovoProfessor() throws IOException {
        Stage stage = null;
        stage = Main.genericaStage2 (Main.CADASTRO_PROFESSOR);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                carregarTable ();
            }});
        stage.show ();
        Main.changeScreen("AreaProfessor.fxml_Novo");
    }



    public void carregarTable( ){


        nomeColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        educandoTable.getItems().setAll(Facade.getInstance().findAllProfessor());

    }


}
