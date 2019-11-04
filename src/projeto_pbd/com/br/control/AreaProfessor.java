package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.*;

public class AreaProfessor implements Initializable {

    @FXML
    private TextField nomeProfessorText;
    @FXML
    private TextField naturalidadeProfessorText;
    @FXML
    private TextField dataProfessorText;
    @FXML
    private TextField cpfProfessorText;
    @FXML
    private TextField telefoneUmProfessorText;
    @FXML
    private TextField telefoneDoisProfessorText;
    @FXML
    private TextField logradouroProfessorText;
    @FXML
    private TextField numeroProfessorText;
    @FXML
    private TextField complementoProfessorText;
    @FXML
    private TextField cepProfessorText;
    @FXML
    private TextField bairroProfessorText;
    @FXML
    private TextField cidadeProfessorText;
    @FXML
    private ComboBox comboBoxPorfUf;
    @FXML
    private TextField graduacaoProfessorText;
    @FXML
    private Button apagarButton;
    @FXML
    private Button salvarProfessorButton;
    @FXML
    private Button apagarProfessorButton;
    @FXML
    private Button novoProfessorButton;
    @FXML
    private TableView<Professor> professorTable;
    @FXML
    private TableColumn<?, ?> nomeProfessorColum;
    @FXML
    private TableColumn<?, ?> graduacaoPorfessorColum;
    @FXML
    private TableColumn<?, ?> naturalidadeProfessorColum;
    @FXML
    private TextField pesquisaProfessorText;
    @FXML
    private Button pesquisaProfessorButton;
    @FXML

    private List listUfsProf = new ArrayList(Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
        carregarTable ();

        this.professorTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    if (professorTable.getSelectionModel().getSelectedItem()!=null){
                        if (professorTable.getSelectionModel().getSelectedItem()!=null){
                            Professor professor = null;
                            professor = professorTable.getSelectionModel().getSelectedItem();
                            logradouroProfessorText.setText(professor.getEndereco().getLogradouro());
                            numeroProfessorText.setText(professor.getEndereco().getNumero());
                            complementoProfessorText.setText(professor.getEndereco().getComplemento());
                            bairroProfessorText.setText(professor.getEndereco().getBairro());
                            cidadeProfessorText.setText(professor.getEndereco().getBairro());
                            cepProfessorText.setText(professor.getEndereco().getCep());
                            cpfProfessorText.setText(professor.getCpf());
                            dataProfessorText.clear(); // ainda não implementado
                            naturalidadeProfessorText.setText(professor.getNaturalidade());
                            nomeProfessorText.setText(professor.getNome());
                            graduacaoProfessorText.setText(professor.getGraduacao());
                            telefoneDoisProfessorText.clear(); // ainda não implementado
                            telefoneUmProfessorText.clear(); // ainda não implementado
                        }
                    }
                }
            }
        });

        this.comboBoxPorfUf.getItems().setAll(this.listUfsProf);

        MaskFieldUtil.dateField (this.dataProfessorText);
        MaskFieldUtil.cpfField (this.cpfProfessorText);
        MaskFieldUtil.cepField (this.cepProfessorText);
        MaskFieldUtil.foneField (this.telefoneUmProfessorText);
        MaskFieldUtil.foneField (this.telefoneDoisProfessorText);
    }


    public void carregarTable( ){

        nomeProfessorColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoPorfessorColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeProfessorColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        professorTable.getItems().setAll(Facade.getInstance().findAllProfessor());
    }


    public void limparaCampos(){
        logradouroProfessorText.clear();
        numeroProfessorText.clear();
        complementoProfessorText.clear();
        bairroProfessorText.clear();
        cidadeProfessorText.clear();
        cepProfessorText.clear();
        cpfProfessorText.clear();
        dataProfessorText.clear();
        naturalidadeProfessorText.clear();
        nomeProfessorText.clear();
        graduacaoProfessorText.clear();
        telefoneDoisProfessorText.clear();
        telefoneUmProfessorText.clear();
        carregarTable();
    }

    //__________________________________________________________________________________________________________________

    @FXML
    void anction(ActionEvent event) {
        if (event.getSource() == novoProfessorButton){
            limparaCampos();
        }

        if (event.getSource() == salvarProfessorButton){
            Professor professor = new Professor ();
            Endereco endereco = new Endereco ();
            String mensagem = "Salvo com Sucesso!";

            if (professorTable.getSelectionModel().getSelectedItem()!=null){
                professor.setId(professorTable.getSelectionModel().getSelectedItem().getId());
                endereco.setId(professorTable.getSelectionModel().getSelectedItem().getEndereco().getId());
                mensagem = "Atualizado com sucesso!";
            }

            endereco.setLogradouro (logradouroProfessorText.getText ());
            endereco.setNumero (numeroProfessorText.getText ());
            endereco.setComplemento (complementoProfessorText.getText ());
            endereco.setBairro (bairroProfessorText.getText ());
            endereco.setCidade (cidadeProfessorText.getText ());
            endereco.setCep (cepProfessorText.getText ());
            endereco.setUf (comboBoxPorfUf.valueProperty ().get ().toString ());

            professor.setCpf (cpfProfessorText.getText ());
            professor.setDataNascimento ((Date) dataProfessorText.getUserData ());
            professor.setNaturalidade (naturalidadeProfessorText.getText ());
            professor.setNome (nomeProfessorText.getText ());
            professor.setGraduacao (graduacaoProfessorText.getText ());

            professor.setEndereco (endereco);
            professor = Facade.getInstance ().saveProfessor (professor);
            Mensagem.mensagemSucesso (mensagem);
            limparaCampos();
        }
        if (event.getSource() == apagarButton){

        }
        if (event.getSource() == pesquisaProfessorButton){

        }
    }




}
