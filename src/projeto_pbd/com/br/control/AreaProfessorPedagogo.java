package projeto_pbd.com.br.control;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaProfessorPedagogo implements Initializable {

    private IFacadeProfessor facadeProfessor;

    @FXML
    private TableView educandoTable;
    @FXML
    private TableColumn nomeColum;
    @FXML
    private TableColumn graduacaoColum;
    @FXML
    private TableColumn naturalidadeColum;
    @FXML
    private TextField pesquisaText;
    @FXML
    private ComboBox comboboxProfessorPedagogo;

    List listEducando = new ArrayList (Arrays.asList ("Professores", "Pedagogos"));



    public AreaProfessorPedagogo() {
        this.facadeProfessor = new FacadeProfessor ();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboboxProfessorPedagogo.setItems (FXCollections.observableArrayList (this.listEducando));
        carregarTable ();

    }


    public void cadastrarNovoProfessor() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_PROFESSOR);
        stage.show ();
    }


    public void carregarTable(){

        List<Professor> professors = new ArrayList<> ();
        professors.addAll ( this.facadeProfessor.findAll ());

        for(Professor professor : professors){
            System.out.println (professor.getNome () );

//            for (Telefone telefone : professor.getTelefones ()){
//                System.out.println (telefone.getNumero ());
//
//            }

//            System.out.println (professor.getEndereco ().getCidade ());
//            System.out.println (professor.getEndereco ().getCep ());

        }

        nomeColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        educandoTable.setItems (FXCollections.observableArrayList (professors));


    }
}
