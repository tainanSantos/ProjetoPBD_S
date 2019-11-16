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
import projeto_pbd.com.br.modell.Professor;
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
    private Button professorPesquisaButton;
    @FXML
    private TextField professorPesquisaText;
    @FXML
    private ComboBox tiposCurriculoCombobox;

//    private List listUfsEnsino = new ArrayList(Arrays.asList (new String[]{"- EF-AI-1", "- EF-AI-2a5",
//            "- EF-AF-6a8", "- EF-AI-9", "- EM-1", "- EM-2", "- EM-3", } ));

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                if (newScene.equalsIgnoreCase("AreaPorfessor.fxml")){
                    professorPesquisaText.setText(((Professor) userData).getNome());
                    // PODE DAR ERRO COSO EU QUEIRA ADD LOGO DIRETO
                    disciplinasTable.getSelectionModel().getSelectedItem().setProfessor((Professor) userData);
                }
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
                    try {
                        professorPesquisaText.setText(disciplinasTable.getSelectionModel().getSelectedItem().getProfessor().getNome());
                    }catch (NullPointerException u){
                        professorPesquisaText.clear();
                    }
                }
            }
        });
        tiposCurriculoCombobox.setItems(FXCollections.observableArrayList(
                carregarCurriculoBox(Facade.getInstance().findAllCurriculo())
        ));
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
        professorPesquisaText.clear();
        cargaHorariaText.setText("60"); // deixando como padrão
    }

    public List<String> carregarCurriculoBox(List<Curriculo> curriculoList){
        List<String> stringList = new ArrayList<>();
        for(Curriculo curriculo: curriculoList){
            stringList.add(curriculo.getNome());
        }
        return stringList;
    }

    //__________________________________________________________________________________________________________________

    @FXML
    void action(ActionEvent event) {

        //EVENTOS PARA DISCIPLINA

        if (event.getSource() == salvarDisciplinaButton){

            Disciplina disciplina =  new Disciplina();
            String mensagem = "Salvo com Sucesso!";
            if(disciplinasTable.getSelectionModel().getSelectedItem()!=null){
                //ATUALIZAR
                disciplina.setId(disciplinasTable.getSelectionModel().getSelectedItem().getId());
                if (disciplinasTable.getSelectionModel().getSelectedItem().getProfessor() != null)
                    disciplina.setProfessor(disciplinasTable.getSelectionModel().getSelectedItem().getProfessor());
                mensagem= "Atualizado com Sucesso!";
            }
            disciplina.setNome(disciplinaText.getText());
            disciplina.setCargaHoaria(Double.parseDouble(cargaHorariaText.getText()));
            disciplina.setStatus(true);
            Facade.getInstance().saveDisciplina(disciplina);
            limparCampos();
            Mensagem.mensagemSucesso(mensagem);

            carregarTable(Facade.getInstance().findAllDisciplina());
        }

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

        if (event.getSource() == salvarDisciplinaNOCurriculoButton){

            Curriculo curriculo =  new Curriculo();
            String mensagem = "Salvo com Sucesso!";
            curriculo = Facade.getInstance().findByNomeCurriculo(tiposCurriculoCombobox.valueProperty().get().toString());
            // fazer a parada lá de atualizar Curriculo

            disciplinasTable.getSelectionModel().getSelectedItem().setCurriculo(curriculo);
            Facade.getInstance().saveDisciplina(disciplinasTable.getSelectionModel().getSelectedItem());
            Mensagem.mensagemSucesso(mensagem);
        }

        if (event.getSource() == novoTipoCurriculoButton){
            try {
                Main.genericaStage(Main.CADASTRAR_TIPO_CURRICULO).show();
            } catch (IOException e) {
                Mensagem.mensagemErro("ERRO AO CARREGAR TELA!");
            }
            Main.changeScreen("CadastroCurriculoEDisciplina.fxl");
            limparCampos();

        }

        if (event.getSource() == tiposCurriculoCombobox){
            System.out.println("effefeffeggerhftjutjfykujyjuf");

            //carregar a tabela com as disciplinas do combobox selecionado
            carregarTableDisciplinasDoCurriculo(Facade.getInstance().findAllNomeCurriculoDisiplina(
                    tiposCurriculoCombobox.valueProperty().get().toString()
            ));
        }

        //PESQUISA PROFESSOR
        if (event.getSource() == professorPesquisaButton){
            try {
                if (disciplinasTable.getSelectionModel().getSelectedItem()!=null)
                    Main.genericaStage(Main.AREA_PROFESSOR).show();
                else Mensagem.mensagemErro("por favor! salve primerio a disciplina e " +
                        "depois adcione o professor à disciplina.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.changeScreen("CadastroCurriculoEDisciplina.fxml", null);
        }
    }


}
