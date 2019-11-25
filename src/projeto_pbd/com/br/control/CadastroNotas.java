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
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.DisciplinaNotasView;
import projeto_pbd.com.br.modell.Nota;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


// AQUI TUDO OK

public class CadastroNotas implements Initializable {

    /*
        NO MOMENTO DE SALVAR AS DISCIPLINAS NO CURRÍCULO:
            VECÊ DEVE SETAR O ID DA TABELA NOTAS COM A O ID DA DISCIPLINA SELECIONADA PARA O CURRÍCULO
    */

    @FXML
    private TableView<DisciplinaNotasView> notasAlunoTable;
    @FXML
    private TableColumn vaUmComumn;
    @FXML
    private TableColumn nomeDisciplinaColumn;
    @FXML
    private TableColumn vaDoisComumn;
    @FXML
    private TableColumn vsTresComumn;
    @FXML
    private TableColumn vaQuatroComumn;
    @FXML
    private TableColumn finalComumn;
    @FXML
    private TableColumn mediaComumn;
    @FXML
    private TableColumn statusAprovacaoComumn;

    @FXML
    private Label nomeAlunoLabel;
    @FXML
    private Label matriculaAlunoLabel;
    @FXML
    private Label turmaAlunoLabel;
    @FXML
    private Label va4Label;

    @FXML
    private TextField va1Text;
    @FXML
    private TextField va2Text;
    @FXML
    private TextField va3Text;
    @FXML
    private TextField va4Text;
    @FXML
    private TextField vaFinalText;

    @FXML
    private Button buttonConfirmar;



    private void restricoesAcesso(){
        buttonConfirmar.setDisable(true);
    }

    //__________________________________________________________________________________________________________________


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (Facade.getInstance().findAllConfiguracao().get(0).getCurriculoPorTrimestre()){
            va4Text.setVisible(false);
            va4Label.setVisible(false);
        }

        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    break;
                case ("Direção"):
                    restricoesAcesso();
                    break;
                case ("Coordenação Pedagogica"):
                    restricoesAcesso();
                    break;
                case ("Secretaria"):
                    break;
            }
        }


        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                Aluno aluno = null;
                aluno = (Aluno) userData;
                nomeAlunoLabel.setText(aluno.getNome());
                matriculaAlunoLabel.setText(String.valueOf(aluno.getCurriculo().getId()));
                turmaAlunoLabel.setText(aluno.getTurma().getNomeTurma());
                carregarTabelaNotas(Facade.getInstance().findAllNotas(aluno.getId()));
            }
        });

        notasAlunoTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() >= 1){
                    va1Text.setText(""+notasAlunoTable.getSelectionModel().getSelectedItem().getPrimeirava());
                    va2Text.setText(""+notasAlunoTable.getSelectionModel().getSelectedItem().getSegundava());
                    va3Text.setText(""+notasAlunoTable.getSelectionModel().getSelectedItem().getTerceirava());
                    va4Text.setText(""+notasAlunoTable.getSelectionModel().getSelectedItem().getQuartava());
                    vaFinalText.setText(""+notasAlunoTable.getSelectionModel().getSelectedItem().getFinalva());
                }
            }
        });

    }


    //__________________________________________________________________________________________________________________


    public void adicionarNota() throws IOException {

    }


    public void carregarTabelaNotas (List<DisciplinaNotasView> notasAlunoVwList){
        // colocar as colunas que faltama aqui
        nomeDisciplinaColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        vaUmComumn.setCellValueFactory(new PropertyValueFactory<>("primeirava"));
        vaDoisComumn.setCellValueFactory(new PropertyValueFactory<>("segundava"));
        vsTresComumn.setCellValueFactory(new PropertyValueFactory<>("terceirava"));
        vaQuatroComumn.setCellValueFactory(new PropertyValueFactory<>("quartava"));
        finalComumn.setCellValueFactory(new PropertyValueFactory<>("finalva"));
        mediaComumn.setCellValueFactory(new PropertyValueFactory<>("media"));
        statusAprovacaoComumn.setCellValueFactory(new PropertyValueFactory<>("resultado"));

        notasAlunoTable.getItems().setAll(notasAlunoVwList);

        va1Text.clear();
        va2Text.clear();
        va3Text.clear();
        va4Text.clear();
        vaFinalText.clear();
    }


    @FXML
    void adicionarNota(ActionEvent event) {

        if (notasAlunoTable.getSelectionModel().getSelectedItem() !=null) {

            // as modificações devem ser alteradas de acordo com o tipo de currículo
            // selecionado nas configurações

            Nota nota = new Nota();
            nota.setId(notasAlunoTable.getSelectionModel().getSelectedItem().getId());
            Disciplina disciplina = new Disciplina();
            disciplina.setId(notasAlunoTable.getSelectionModel().getSelectedItem().getDisciplina_id());

            Aluno aluno = new Aluno();
            aluno.setId(notasAlunoTable.getSelectionModel().getSelectedItem().getPessoa_id());
            nota.setAluno(aluno)    ;
            nota.setDisciplina(disciplina);

            nota.setStatus(true);

            nota.setPrimeiraVa(validarIntegerCampoText(va1Text.getText()));
            nota.setSegundaVa(validarIntegerCampoText(va2Text.getText()));
            nota.setTerceiraVa(validarIntegerCampoText(va3Text.getText()));
            nota.setQuartaVa(validarIntegerCampoText(va4Text.getText()));
            nota.setFinalVa(validarIntegerCampoText(vaFinalText.getText()));
            disciplina.setStatus(true);

            List<Double> integerList = new ArrayList<>();
            integerList.add(nota.getPrimeiraVa());
            integerList.add(nota.getSegundaVa());
            integerList.add(nota.getTerceiraVa());
            integerList.add(nota.getQuartaVa());
            integerList.add(nota.getFinalVa());

            Integer caount = 0;
            Double soma = 0.0;
            for (Double integer : integerList) {
                if (integer != null) {
                    if (integer >= 0 && integer <=10) {
                        soma += integer;
                        caount += 1;
                    }else {
                        Mensagem.mensagemErro("Valores não permitidos, " +
                                "Os campos de notas devem ser preenchidos com valores entre 0 e 10");
                        return; // só para interromper o fluxo do método
                    }
                }
            }
            try {
                nota.setMedia((soma / caount));
            } catch (ArithmeticException a) {

            }

            if (caount >= 3) {
                if (nota.getMedia() >= 7)
                    nota.setResultado("AM");
                else{
                    if ((nota.getMedia()+ Double.parseDouble(vaFinalText.getText()))>=7){
                        nota.setResultado("AP");
                    }
                    else {
                        nota.setResultado("RP");
                    }
                }

            } else
                nota.setResultado("ND");

            Facade.getInstance().saveNota(nota);
            carregarTabelaNotas(Facade.getInstance().findAllNotas(
                    notasAlunoTable.getSelectionModel().getSelectedItem().getPessoa_id()));
        }else {
            Mensagem.mensagemErro("nenhuma linha da tabela selecionada. IMpossível salvar a NOTA");
        }
    }


    public Double validarIntegerCampoText(String string){
        try {
            return Double.parseDouble(string);
        }catch (NumberFormatException e){
            return null;
        }
    }

}