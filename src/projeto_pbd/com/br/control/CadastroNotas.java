package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Nota;
import projeto_pbd.com.br.modell.NotasAlunoVw;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroNotas implements Initializable {


    @FXML
    private TableView<NotasAlunoVw> notasAlunoTable;
    @FXML
    private TableColumn<?, ?> vaUmComumn;
    @FXML
    private TableColumn<?, ?> vaDoisComumn;
    @FXML
    private TableColumn<?, ?> vsTresComumn;
    @FXML
    private TableColumn<?, ?> vaQuatroComumn;
    @FXML
    private TableColumn<?, ?> finalComumn;
    @FXML
    private TableColumn<?, ?> mediaComumn;
    @FXML
    private TableColumn<?, ?> statusAprovacaoComumn;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private TextField codigoDisciplinaText;
    @FXML
    private Label nomeAlunoLabel;
    @FXML
    private Label matriculaAlunoLabel;
    @FXML
    private Label turmaAlunoLabel;
    @FXML
    private ComboBox disciplinaComboBox;



    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        //RESTRIÇÃO DE ACESSO
//        switch (Main.getTipoUsuario()){
//            case ("Adiminstração"):
//                System.out.println("Adm");
//                break;
//            case ("Direção"):
//                System.out.println("Direção");
//                break;
//            case("Coordenação Pedagogica"):
//                System.out.println("Cood Ped");
//                break;
//            case ("Secretaria"):
//                System.out.println("Secretaria");
//                break;
//        }


        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                Aluno aluno = null;
                aluno = (Aluno) userData;
                System.out.println("aquie stamos");
                System.out.println(newScene);
                System.out.println("________________________________________________________");
                nomeAlunoLabel.setText(aluno.getNome());
                matriculaAlunoLabel.setText(String.valueOf(aluno.getCurriculo().getId()));
                turmaAlunoLabel.setText(aluno.getTurma().getNomeTurma());
                disciplinaComboBox.setItems(FXCollections.observableArrayList(Facade.getInstance().findAllIdCurriculo(
                        aluno.getCurriculo().getId()
                )));
                codigoDisciplinaText.setText(aluno.getCurriculo().getId()+"");
            }
        });
    }
    //__________________________________________________________________________________________________________________


    public void adicionarNota() throws IOException {


    }


    public void carregarTabelaNotas (List<NotasAlunoVw> notasAlunoVwList){
        // colocar as colunas que faltama aqui
        notasAlunoTable.getItems().setAll(notasAlunoVwList);

    }


    @FXML
    void adicionarNota(ActionEvent event) {

        Nota nota = new Nota();

        if (notasAlunoTable.getSelectionModel().getSelectedItem() != null){
//           nota.setId(); = notasAlunoTable.getSelectionModel().getSelectedItem();
        }

    }

}