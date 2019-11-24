package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
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
    private DatePicker dataProfessorText;
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
    private Button adicionarProfessorDisciplinaButton;
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
    private TableColumn<Professor, Boolean>  selecionadoColum;
    @FXML
    private TextField pesquisaProfessorText;
    @FXML
    private Button pesquisaProfessorButton;
    @FXML
    private CheckBoxTableCell comCheckBoxTableCell;

    private List listUfsProf = new ArrayList(Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    //__________________________________________________________________________________________________________________


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //RESTRIÇÃO DE ACESSO
        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    System.out.println("Adm");
                    break;
                case ("Direção"):
                    System.out.println("Direção");
                    break;
                case ("Coordenação Pedagogica"):
                    System.out.println("Cood Ped");
                    break;
                case ("Secretaria"):
                    System.out.println("Secretaria");
                    break;
            }
        }

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                // deixa aqui por enquando que pode ser útil para outra tela!
                if (newScene.equalsIgnoreCase("CadastroCurriculoEDisciplina.fxml")) {
                    System.out.println("aqui tudo certo");
                    adicionarProfessorDisciplinaButton.setVisible(true);
                }
            }
        });





        carregarTable (Facade.getInstance().findAllProfessor());

        this.professorTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    if (professorTable.getSelectionModel().getSelectedItem()!=null){

                        Professor prof = null;
                        prof = professorTable.getSelectionModel().getSelectedItem();
                        logradouroProfessorText.setText(prof.getEndereco().getLogradouro());
                        numeroProfessorText.setText(prof.getEndereco().getNumero());
                        complementoProfessorText.setText(prof.getEndereco().getComplemento());
                        bairroProfessorText.setText(prof.getEndereco().getBairro());
                        cidadeProfessorText.setText(prof.getEndereco().getCidade());
                        comboBoxPorfUf.setValue(prof.getEndereco().getUf());
                        cepProfessorText.setText(prof.getEndereco().getCep());
                        cpfProfessorText.setText(prof.getCpf());
                        dataProfessorText.setValue(prof.getDataNascimento());
                        naturalidadeProfessorText.setText(prof.getNaturalidade());
                        nomeProfessorText.setText(prof.getNome());
                        graduacaoProfessorText.setText(prof.getGraduacao());
                        dataProfessorText.setValue(prof.getDataNascimento());
                        List<Telefone> telefoneList = null;
                        telefoneList = Facade.getInstance().findAllIdTelefone(prof.getId());
                        telefoneUmProfessorText.setText(telefoneList.get(0).getNumero());
                        telefoneDoisProfessorText.setText(telefoneList.get(1).getNumero());

                    }
                }
            }
        });
        pesquisaProfessorText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // falta implementar isso ainda ...
            }
        });


        this.comboBoxPorfUf.getItems().setAll(this.listUfsProf);

        MaskFieldUtil.dateField (this.dataProfessorText.getEditor());
        MaskFieldUtil.cpfField (this.cpfProfessorText);
        MaskFieldUtil.cepField (this.cepProfessorText);
        MaskFieldUtil.foneField (this.telefoneUmProfessorText);
        MaskFieldUtil.foneField (this.telefoneDoisProfessorText);
    }



    public void carregarTable(List<Professor> professorList){

        nomeProfessorColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoPorfessorColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeProfessorColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        selecionadoColum.setCellValueFactory(new PropertyValueFactory<>("selectTable"));
        selecionadoColum.setCellFactory(comCheckBoxTableCell.forTableColumn((selecionadoColum)));
        professorTable.getItems().setAll(professorList);
    }


    public void limparaCampos(){
        logradouroProfessorText.clear();
        numeroProfessorText.clear();
        complementoProfessorText.clear();
        bairroProfessorText.clear();
        cidadeProfessorText.clear();
        cepProfessorText.clear();
        cpfProfessorText.clear();
        comboBoxPorfUf.setValue(null);
        dataProfessorText.setValue(null);
        naturalidadeProfessorText.clear();
        nomeProfessorText.clear();
        graduacaoProfessorText.clear();
        telefoneDoisProfessorText.clear();
        telefoneUmProfessorText.clear();
        carregarTable(Facade.getInstance().findAllProfessor());
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
            Telefone telefone = new Telefone();
            Telefone telefone1 = new Telefone();

            if (professorTable.getSelectionModel().getSelectedItem()!=null){
                professor.setId(professorTable.getSelectionModel().getSelectedItem().getId());
                endereco.setId(professorTable.getSelectionModel().getSelectedItem().getEndereco().getId());
                mensagem = "Atualizado com sucesso!";
                List<Telefone> telefoneList = null;
                telefoneList = Facade.getInstance().findAllIdTelefone(professor.getId());
                telefone.setId(telefoneList.get(0).getId());
                telefone1.setId(telefoneList.get(1).getId());
            }

            endereco.setLogradouro (logradouroProfessorText.getText ());
            endereco.setNumero (numeroProfessorText.getText ());
            endereco.setComplemento (complementoProfessorText.getText ());
            endereco.setBairro (bairroProfessorText.getText ());
            endereco.setCidade (cidadeProfessorText.getText ());
            endereco.setCep (cepProfessorText.getText ());
            try {
                endereco.setUf (comboBoxPorfUf.valueProperty ().get ().toString ());
            }catch (NullPointerException e){
                Mensagem.mensagemErro("Estado não Selecionado!");
            }

            professor.setCpf (cpfProfessorText.getText ());
            professor.setDataNascimento(dataProfessorText.getValue());

            professor.setNaturalidade (naturalidadeProfessorText.getText ());
            professor.setNome (nomeProfessorText.getText ());
            professor.setGraduacao (graduacaoProfessorText.getText ());
            professor.setDataNascimento(dataProfessorText.getValue());
            professor.setStatus(true);
            professor.setSelectTable(true);

            telefone.setNumero(telefoneUmProfessorText.getText());
            telefone1.setNumero(telefoneDoisProfessorText.getText());

            professor.setEndereco (endereco);
            professor = Facade.getInstance ().saveProfessor (professor);

            telefone.setPessoa(professor);
            telefone1.setPessoa(professor);
            Facade.getInstance().saveTelefone(telefone);
            Facade.getInstance().saveTelefone(telefone1);
            Mensagem.mensagemSucesso (mensagem);
            limparaCampos();
        }

        if (event.getSource() == apagarButton){

        }

        if (event.getSource() == pesquisaProfessorButton){

        }

        if (event.getSource() == adicionarProfessorDisciplinaButton){
            // setar o id do professor para a disciplina e só
            Main.STAGE.close();
            Main.changeScreen("AreaPorfessor.fxml", professorTable.getSelectionModel().getSelectedItem());
        }

    }
}
