package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.FacadePedagogo;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadePedagogo;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.util.ObjetctUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaPedagogo implements Initializable {

    private IFacadePedagogo facadePedagogo;

    @FXML
    private Button novoCadastroButton;
    @FXML
    private Button atualizarButton;
    @FXML
    private TableView<Pedagogo> educandoTable;
    @FXML
    private TableColumn nomeColum;
    @FXML
    private TableColumn logradouroColum;
    @FXML
    private TableColumn graduacaoColum;
    @FXML
    private TableColumn naturalidadeColum;
    @FXML
    private TextField pesquisaText;


    public AreaPedagogo() {
        this.facadePedagogo = new FacadePedagogo ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        carregarTable ();

        educandoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> seteducandoTable(newValue));
   }



    public void cadastrarNovoProfessor() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_PEDAGOGO);
        stage.show ();
    }





    public void carregarTable(){

        nomeColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        this.educandoTable.setItems (FXCollections.observableArrayList (this.facadePedagogo.findAll ()));

    }


    public void seteducandoTable(Pedagogo pedagogo){

        this.educandoTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2) {
                ObjetctUtil.setObject (pedagogo);
                Stage stage = null;
                try {
                    stage = Main.genericaStage (Main.CADASTRO_PEDAGOGO);
                    stage.show ();
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        });
    }

    public void atualizarTabela() {
        carregarTable ();
    }
}
