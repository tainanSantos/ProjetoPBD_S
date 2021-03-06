package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.Nota;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CadastroCurriculoEDisciplina implements Initializable {

    @FXML
    private TableView<Disciplina> disiplinaCurriculoTable;
    @FXML
    private TableColumn disiplinaCurriculoColumn;
    @FXML
    private TableView<Disciplina> disciplinasTable;
    @FXML
    private TableColumn selecionarDisciplinaColum;
    @FXML
    private TableColumn nomeDisciplinaColumm;
    @FXML
    private TableColumn cargaHorariaDisciplinaColumm;
    @FXML
    private TextField nomeCurriculoText;
    @FXML
    private Button novoTipoCurriculoButton;
    @FXML
    private Button salvarDisciplinaNOCurriculoButton;
    @FXML
    private TextField pequisarPorDisciplinaText;
    @FXML
    private Button pesquisarDisciplinaButton;
    @FXML
    private TextField disciplinaText;
    @FXML
    private TextField cargaHorariaText;
    @FXML
    private Button apagarDisciplinaButton;
    @FXML
    private Button salvarDisciplinaButton;
    @FXML
    private Button novaDiplinaButton;
    @FXML
    private ComboBox<Curriculo> tiposCurriculoCombobox;

//    private List listUfsEnsino = new ArrayList(Arrays.asList (new String[]{"- EF-AI-1", "- EF-AI-2a5",
//            "- EF-AF-6a8", "- EF-AI-9", "- EM-1", "- EM-2", "- EM-3", } ));

    private void restricoesAcesso(){
        pesquisarDisciplinaButton.setDisable(true);
        apagarDisciplinaButton.setDisable(true);
        novaDiplinaButton.setDisable(true);
        novoTipoCurriculoButton.setDisable(true);
        salvarDisciplinaButton.setDisable(true);
        salvarDisciplinaNOCurriculoButton.setDisable(true);
    }


    //__________________________________________________________________________________________________________________


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

            }
        });

        carregarTable(Facade.getInstance().findAllDisciplina());

        pequisarPorDisciplinaText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("evento aqui!");
                if (pequisarPorDisciplinaText.getText().length() >=1){
                    carregarTable(Facade.getInstance().findAllNomeDisciplina(pequisarPorDisciplinaText.getText()));
                }else carregarTable(Facade.getInstance().findAllDisciplina());
            }
        });

        disciplinasTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1){
                    disciplinaText.setText(disciplinasTable.getSelectionModel().getSelectedItem().getNome());
                    cargaHorariaText.setText(disciplinasTable.getSelectionModel().getSelectedItem().getCargaHoaria()+""); // gambiarra aqui
                }
            }
        });

        tiposCurriculoCombobox.setItems(FXCollections.observableArrayList(Facade.getInstance().findAllCurriculo()));
    }



    public void carregarTableDisciplinasDoCurriculo(List<Disciplina> disciplinasList){
        disiplinaCurriculoColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        disiplinaCurriculoTable.getItems().setAll(disciplinasList);
    }



    public void carregarTable(List<Disciplina> disciplinas){

        nomeDisciplinaColumm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cargaHorariaDisciplinaColumm.setCellValueFactory(new PropertyValueFactory<>("cargaHoaria"));
        selecionarDisciplinaColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        disciplinasTable.getItems().setAll(disciplinas);
    }



    public void limparCampos(){
        disciplinasTable.getSelectionModel().select(null);
        disciplinaText.clear();
        pequisarPorDisciplinaText.clear();
        cargaHorariaText.setText("60"); // deixando como padrão
    }


    //__________________________________________________________________________________________________________________



    @FXML
    void actionSaveDisciplina(ActionEvent event) {
        Disciplina disciplina =  new Disciplina();
        String mensagem = "Salvo com Sucesso!";
        if(disciplinasTable.getSelectionModel().getSelectedItem()!=null){
            disciplina.setId(disciplinasTable.getSelectionModel().getSelectedItem().getId());
            mensagem= "Atualizado com Sucesso!";
        }
        disciplina.setNome(disciplinaText.getText());
        disciplina.setCargaHoaria(Double.parseDouble(cargaHorariaText.getText()));
        disciplina.setStatus(false);

        disciplina = Facade.getInstance().saveDisciplina(disciplina);

        Nota nota = new Nota();
        nota.setDisciplina(disciplina);
        Facade.getInstance().saveNota(nota);

        limparCampos();
        Mensagem.mensagemSucesso(mensagem);
        carregarTable(Facade.getInstance().findAllDisciplina());
    }



    @FXML
    void actionSaveDisciplinaCurriculo(ActionEvent event) {
        Curriculo curriculo =  new Curriculo();
        Disciplina disciplina = null;
        String mensagem = "Salvo com Sucesso!";
        curriculo = Facade.getInstance().findByIdCurriculo(
                tiposCurriculoCombobox.getSelectionModel().getSelectedItem().getId());
        // fazer a parada lá de atualizar Curriculo

        try {
            disciplina = disciplinasTable.getSelectionModel().getSelectedItem();
            disciplina.setCurriculo(curriculo);
        }catch (NullPointerException e){
            Mensagem.mensagemErro("Nenhuma Disciplina Selecionanda! Selecione antes a disciplina");
        }
        Facade.getInstance().saveDisciplina(disciplina);
        Mensagem.mensagemSucesso(mensagem);
    }



    @FXML
    void action(ActionEvent event) {

        //EVENTOS PARA DISCIPLINA
        if (event.getSource() == novaDiplinaButton){
            limparCampos();
        }

        if (event.getSource() == apagarDisciplinaButton){
            Facade.getInstance().removeDisciplina(disciplinasTable.getSelectionModel().getSelectedItem().getId());
            Mensagem.mensagemSucesso("Excluido com Sucesso!");
            carregarTable(Facade.getInstance().findAllDisciplina());
        }

        if (event.getSource() == pesquisarDisciplinaButton ){
            carregarTable(Facade.getInstance().findAllNomeDisciplina(pequisarPorDisciplinaText.getText()));
        }

        //EVENTOS PARA CURRICULO
        if (event.getSource() == novoTipoCurriculoButton){
            try {
                Main.genericaStage(Main.CADASTRAR_TIPO_CURRICULO).show();
            } catch (IOException e) {
                Mensagem.mensagemErro("ERRO AO CARREGAR TELA!");
            }
            Main.changeScreen("CadastroCurriculoEDisciplina.fxml");
            limparCampos();
        }

        if (event.getSource() == tiposCurriculoCombobox){
            //carregar a tabela com as disciplinas do combobox selecionado
            carregarTableDisciplinasDoCurriculo(Facade.getInstance().findAllNomeCurriculoDisiplina(
                    tiposCurriculoCombobox.valueProperty().get().toString()
            ));
        }}

}
