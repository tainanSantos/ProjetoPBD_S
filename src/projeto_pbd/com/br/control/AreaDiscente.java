package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Responsavel;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

public class AreaDiscente implements Initializable {

    @FXML
    private TableView<Aluno> alunosTable;

    @FXML
    private TableColumn<?, ?> curriculoColum;

    @FXML
    private TableColumn<?, ?> nomeAlunoColum;

    @FXML
    private TableColumn<?, ?> numeroMatriculaColum;

    @FXML
    private TableColumn<?, ?> naturalidadeColum;

    @FXML
    private Button pesquisaAlunoButton;

    @FXML
    private AnchorPane alunoAnchorPane;

    @FXML
    private TextField nomeText;

    @FXML
    private TextField naturalidadedText;

    @FXML
    private TextField cpfResponsavelText;

    @FXML
    private Label cpfLabel;

    @FXML
    private DatePicker dataText;

    @FXML
    private TextField cepText;

    @FXML
    private TextField telefoneUmText;

    @FXML
    private TextField telefoneDoisText;

    @FXML
    private TextField logradouroText;

    @FXML
    private TextField numeroText;

    @FXML
    private TextField complementoText;

    @FXML
    private TextField bairroText;

    @FXML
    private TextField cidadeText;

    @FXML
    private ComboBox comboboxUf;

    @FXML
    private AnchorPane filiacaoPane;

    @FXML
    private TextField nomeMaeText;

    @FXML
    private TextField nomePaiText;

    @FXML
    private Label maiorDeIdadeMensagemLabel;


    @FXML
    private ComboBox ensinoComboBox;

    @FXML
    private TitledPane responsavelTiledPane;

    @FXML
    private AnchorPane responsávelAnchorPane;

    @FXML
    private TextField nomeText1Resp;

    @FXML
    private TextField naturalidadedText1Resp;

    @FXML
    private TextField cpfResponsavelText1Resp;

    @FXML
    private DatePicker dataText1Resp;

    @FXML
    private TextField cepText1Resp;

    @FXML
    private TextField telefoneUmText1Resp;

    @FXML
    private TextField telefoneDoisText1Resp;

    @FXML
    private TextField logradouroText1Resp;

    @FXML
    private TextField numeroText1Resp;

    @FXML
    private TextField complementoText1Resp;

    @FXML
    private TextField bairroText1Resp;

    @FXML
    private TextField cidadeText1Resp;

    @FXML
    private ComboBox comboboxUf1Resp;

    @FXML
    private Button salvarAlunoButton;

    @FXML
    private Button apagraAlunoButton;

    @FXML
    private Button acompanhamentoButton;

    @FXML
    private Button novoAlunoButton;

    @FXML
    private Label maiorDeIdadeMensagemLabel1;

    @FXML
    private RadioButton maiorDeIdadeRadioButton;



    private List listUfsAlun = new ArrayList(Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    private List listUfsEnsino = new ArrayList(Arrays.asList (new String[]{"- EF-AI-1", "- EF-AI-2a5",
            "- EF-AF-6a8", "- EF-AI-9", "- EM-1", "- EM-2", "- EM-3", } ));

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                //??
            }
        });

        carregarTabelaAlunos(Facade.getInstance().findAllAluno());

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsAlun));
        this.comboboxUf1Resp.setItems(FXCollections.observableArrayList (this.listUfsAlun));
        this.ensinoComboBox.setItems(FXCollections.observableArrayList(this.listUfsEnsino));

        MaskFieldUtil.dateField (this.dataText.getEditor());
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);

        MaskFieldUtil.dateField (this.dataText1Resp.getEditor());
        MaskFieldUtil.cepField (this.cepText1Resp);
        MaskFieldUtil.foneField (this.telefoneDoisText1Resp);
        MaskFieldUtil.foneField (this.telefoneUmText1Resp);
        MaskFieldUtil.cpfField (this.cpfResponsavelText1Resp);

        this.alunosTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (alunosTable.getSelectionModel().getSelectedItem()!=null
                    && event.getClickCount() == 2){
                    Aluno aluno = null;
                    Responsavel responsavel = null;
                    aluno = Facade.getInstance().findByIdAluno(alunosTable.getSelectionModel().getSelectedItem().getId());
                    responsavel = Facade.getInstance().findByIdResponsavel(alunosTable.getSelectionModel().getSelectedItem().getResponsavel().getId());

                    nomeText.setText(aluno.getNome());
                    nomePaiText.setText(aluno.getNomePai());
                    nomeMaeText.setText(aluno.getNomeMae());
                    naturalidadedText.setText(aluno.getNaturalidade());
                    dataText.setValue(aluno.getDataNascimento());
                    List<Telefone> telefoneList = null;
                    telefoneList = Facade.getInstance().findAllIdTelefone(aluno.getId());
                    telefoneUmText.setText(telefoneList.get(0).getNumero());
                    telefoneDoisText.setText(telefoneList.get(1).getNumero());

                    logradouroText.setText(aluno.getEndereco().getLogradouro());
                    numeroText.setText(aluno.getEndereco().getNumero());
                    complementoText.setText(aluno.getEndereco().getComplemento());
                    bairroText.setText(aluno.getEndereco().getBairro());
                    cidadeText.setText(aluno.getEndereco().getCidade());
                    comboboxUf.setValue(aluno.getEndereco().getUf());
                    cepText.setText(aluno.getEndereco().getCep());

                    //__________________________________

                    nomeText1Resp.setText(responsavel.getNome());
                    cpfResponsavelText1Resp.setText(responsavel.getCpf());
                    naturalidadedText1Resp.setText(aluno.getNaturalidade());
                    dataText1Resp.setValue(aluno.getDataNascimento());
                    List<Telefone> telefoneListResp = null;
                    telefoneListResp = Facade.getInstance().findAllIdTelefone(aluno.getId());
                    telefoneUmText1Resp.setText(telefoneListResp.get(0).getNumero());
                    telefoneDoisText1Resp.setText(telefoneListResp.get(1).getNumero());

                    logradouroText1Resp.setText(aluno.getEndereco().getLogradouro());
                    numeroText1Resp.setText(aluno.getEndereco().getNumero());
                    complementoText1Resp.setText(aluno.getEndereco().getComplemento());
                    bairroText1Resp.setText(aluno.getEndereco().getBairro());
                    cidadeText1Resp.setText(aluno.getEndereco().getCidade());
                    comboboxUf1Resp.setValue(aluno.getEndereco().getUf());
                    cepText1Resp.setText(aluno.getEndereco().getCep());
                }
            }
        });
    }

    //__________________________________________________________________________________________________________________

    public void carregarTabelaAlunos(List<Aluno> alunos){
        nomeAlunoColum.setCellValueFactory(new PropertyValueFactory<>("nome"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<>("naturalidade"));
        numeroMatriculaColum.setCellValueFactory(new PropertyValueFactory<>("id"));
        alunosTable.getItems().setAll(alunos);
    }

    public void limparCampos(){
        carregarTabelaAlunos(Facade.getInstance().findAllAluno());
        alunosTable.getSelectionModel().select(null);
        maiorDeIdadeRadioButton.setSelected(false);
        logradouroText.clear();
        logradouroText1Resp.clear();
        nomeText1Resp.clear();
        nomeText.clear();
        nomeMaeText.clear();
        nomePaiText.clear();
        complementoText1Resp.clear();
        complementoText.clear();
        comboboxUf.getSelectionModel().select(null);
        comboboxUf1Resp.getSelectionModel().select(null);
        bairroText.clear();
        bairroText1Resp.clear();
        cidadeText.clear();
        cidadeText1Resp.clear();
        cepText1Resp.clear();
        cepText.clear();
        numeroText1Resp.clear();
        numeroText.clear();
        cpfResponsavelText1Resp.clear();
        cpfResponsavelText.clear();
        dataText1Resp.setValue(null);
        dataText.setValue(null);
        naturalidadedText1Resp.clear();
        naturalidadedText.clear();
        telefoneUmText1Resp.clear();
        telefoneUmText.clear();
        telefoneDoisText1Resp.clear();
        telefoneDoisText.clear();

    }

    //__________________________________________________________________________________________________________________


    @FXML
    public void action(ActionEvent event){

        if (event.getSource() ==  salvarAlunoButton){
            Aluno aluno = new Aluno();
            Endereco enderecoAluno = new Endereco();
            Telefone telefone1Aluno = new Telefone();
            Telefone telefone2Aluno = new Telefone();

            Responsavel responsavel = new Responsavel();
            Endereco enderecoResponsavel = new Endereco();
            Telefone telefone1Responsavel = new Telefone();
            Telefone telefone2Responsavel = new Telefone();

           if (alunosTable.getSelectionModel().getSelectedItem() != null){
                aluno = alunosTable.getSelectionModel().getSelectedItem();
                enderecoAluno = alunosTable.getSelectionModel().getSelectedItem().getEndereco();
            }
            enderecoAluno.setLogradouro (logradouroText.getText ());
            enderecoAluno.setNumero (numeroText.getText ());
            enderecoAluno.setComplemento (complementoText.getText ());
            enderecoAluno.setBairro (bairroText.getText ());
            enderecoAluno.setCidade (cidadeText.getText ());
            enderecoAluno.setCep (cepText.getText ());
            enderecoAluno.setUf (comboboxUf.valueProperty ().get ().toString ());

            aluno.setNome(nomeText.getText());
            aluno.setNaturalidade (naturalidadedText.getText ());
            aluno.setNomeMae (nomeMaeText.getText ());
            aluno.setNomePai(nomePaiText.getText());
            aluno.setDataNascimento(dataText.getValue());
            aluno.setStatus(true);

            telefone1Aluno.setNumero(telefoneUmText.getText());
            telefone2Aluno.setNumero(telefoneDoisText.getText());
            //----------------------------------------------------------------------------------------------------------
            responsavel.setDataNascimento(dataText1Resp.getValue());
            responsavel.setNaturalidade(naturalidadedText.getText());
            responsavel.setNome(nomeText1Resp.getText());
            responsavel.setCpf(cpfResponsavelText1Resp.getText());
            responsavel.setStatus(true);

            enderecoResponsavel.setNumero(numeroText1Resp.getText());
            enderecoResponsavel.setBairro(bairroText1Resp.getText());
            enderecoResponsavel.setCep(cepText1Resp.getText());
            enderecoResponsavel.setCidade(cidadeText1Resp.getText());
            enderecoResponsavel.setComplemento(complementoText1Resp.getText());
            enderecoResponsavel.setLogradouro(logradouroText1Resp.getText());
            enderecoResponsavel.setUf(comboboxUf1Resp.valueProperty().get().toString());

            telefone1Responsavel.setNumero(telefoneUmText1Resp.getText());
            telefone2Responsavel.setNumero(telefoneDoisText1Resp.getText());

            responsavel.setEndereco(enderecoResponsavel);
            responsavel = Facade.getInstance().saveResponsavel(responsavel);

            telefone1Responsavel.setPessoa(responsavel);
            telefone2Responsavel.setPessoa(responsavel);
            Facade.getInstance().saveTelefone(telefone1Responsavel);
            Facade.getInstance().saveTelefone(telefone2Responsavel);

            aluno.setEndereco (enderecoAluno);
            aluno.setResponsavel(responsavel);
            aluno = Facade.getInstance ().saveAluno (aluno);

            telefone1Aluno.setPessoa(aluno);
            telefone2Aluno.setPessoa(aluno);
            Facade.getInstance().saveTelefone(telefone1Aluno);
            Facade.getInstance().saveTelefone(telefone2Aluno);

            limparCampos();
        }


        if (event.getSource() == apagraAlunoButton){
            // não sei se isso aqui precisa
        }


        if (event.getSource() == pesquisaAlunoButton){

        }

        if (event.getSource() == novoAlunoButton){
            limparCampos();
        }


        if (maiorDeIdadeRadioButton.isSelected()){
            nomeText1Resp.setText(nomeText.getText());
            dataText1Resp.setValue(dataText.getValue());
            naturalidadedText1Resp.setText(naturalidadedText.getText());

            numeroText1Resp.setText(numeroText.getText());
            logradouroText1Resp.setText(logradouroText.getText());
            bairroText1Resp.setText(bairroText.getText());
            cidadeText1Resp.setText(cidadeText.getText());
            complementoText1Resp.setText(complementoText.getText());
            cepText1Resp.setText(cepText.getText());

            telefoneUmText1Resp.setText(telefoneUmText.getText());
            telefoneDoisText1Resp.setText(telefoneDoisText.getText());
        }


        if (!maiorDeIdadeRadioButton.isSelected()){
            nomeText1Resp.clear();
            dataText1Resp.setValue(null);
            naturalidadedText1Resp.clear();

            numeroText1Resp.clear();
            logradouroText1Resp.clear();
            bairroText1Resp.clear();
            cidadeText1Resp.clear();
            comboboxUf1Resp.setValue(null); // pode dar erro aqui
            complementoText.clear();
            cepText1Resp.clear();

            telefoneUmText1Resp.clear();
            telefoneDoisText1Resp.clear();
        }

        if (event.getSource() == acompanhamentoButton){
            try {
                if (alunosTable.getSelectionModel().getSelectedItem()!=null)
                    Main.genericaStage(Main.AREA_DISCENTE_ACOMPANHAMENTO_PEDAGOGICO).show();
                else
                    Mensagem.mensagemErro("por favor seelecione antes um Ítem na tabela!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    void evento(MouseEvent event) {
        if (event.getSource() == responsavelTiledPane){
            // verificar a quatão da data
            Calendar calendar = Calendar.getInstance();
            try {
                int idadeAluno = calendar.get(Calendar.YEAR) - dataText.getValue().getYear();
                if (idadeAluno >= 18) maiorDeIdadeRadioButton.setVisible(true);
                else maiorDeIdadeRadioButton.setVisible(false);
            }catch (NullPointerException e){
                Mensagem.mensagemErro("Verifique os dados Anteriores!");
                responsavelTiledPane.setExpanded(false);
            }

        }
    }


    @FXML
    void selectedEvent(ActionEvent event) {

    }

}
