package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.*;

public class AreaPedagogo implements Initializable {



    @FXML
    private Button apagarPedagogoButton;
    @FXML
    private TextField nomeText;
    @FXML
    private TextField naturalidadeText;
    @FXML
    private TextField dataText;
    @FXML
    private TextField cpfText;
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
    private TextField cepText;
    @FXML
    private TextField bairroText;
    @FXML
    private TextField cidadeText;
    @FXML
    private ComboBox<?> comboboxUf;
    @FXML
    private TextField graduacaoText;
    @FXML
    private Button apagarButton;
    @FXML
    private Button salvarPedagogoButton;
    @FXML
    private Button novoPedagogoButton;
    @FXML
    private TableView<Pedagogo> educandoTable;
    @FXML
    private TableColumn<?, ?> nomeColum;
    @FXML
    private TableColumn<?, ?> graduacaoColum;
    @FXML
    private TableColumn<?, ?> naturalidadeColum;
    @FXML
    private TableColumn<?, ?> logradouroColum;
    @FXML
    private TextField pesquisaText;
    @FXML
    private Button pesquisarPedagogoButton;
    @FXML
    private Button acompanhamentoButton;

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

        carregarTable (Facade.getInstance().findAllPedagogo());

        this.educandoTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1){
                    if (educandoTable.getSelectionModel().getSelectedItem() != null){
                        Pedagogo pedagogo = null;
                        pedagogo = educandoTable.getSelectionModel().getSelectedItem();
                        logradouroText.setText(pedagogo.getEndereco().getLogradouro());
                        numeroText.setText(pedagogo.getEndereco().getNumero());
                        complementoText.setText(pedagogo.getEndereco().getComplemento());
                        bairroText.setText(pedagogo.getEndereco().getBairro());
                        cidadeText.setText(pedagogo.getEndereco().getCidade());
//                        comboboxUf.getSelectionModel().select(Integer.parseInt(pedagogo.getEndereco().getUf()));
                        cepText.setText(pedagogo.getEndereco().getCep());
                        cpfText.setText(pedagogo.getCpf());

                        dataText.clear(); // ainda não implementado

                        naturalidadeText.setText(pedagogo.getNaturalidade());
                        nomeText.setText(pedagogo.getNome());
                        graduacaoText.setText(pedagogo.getGraduacao());
                        List<Telefone> telefoneList = null;
                        telefoneList = Facade.getInstance().findAllIdTelefone(pedagogo.getId());
                        for (Telefone telefone: telefoneList){
                            System.out.println(telefone.getNumero() +" ---- "+telefone.getId());
                        }
                        telefoneUmText.setText(telefoneList.get(0).getNumero());
                        telefoneDoisText.setText(telefoneList.get(1).getNumero());
                    }
                }
            }
        });

        this.comboboxUf.getItems().setAll(this.listUfsProf);

        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
   }

    //__________________________________________________________________________________________________________________


    public void carregarTable(List<Pedagogo> pedagogoList){

        nomeColum.setCellValueFactory(new PropertyValueFactory<> ("nome"));
        graduacaoColum.setCellValueFactory(new PropertyValueFactory<> ("graduacao"));
        naturalidadeColum.setCellValueFactory(new PropertyValueFactory<> ("naturalidade"));
        educandoTable.getItems().setAll(pedagogoList);
    }


    public void limparaCampos(){
        logradouroText.clear();
        numeroText.clear();
        complementoText.clear();
        bairroText.clear();
        cidadeText.clear();
        cepText.clear();
        cpfText.clear();
        dataText.clear();
        naturalidadeText.clear();
        nomeText.clear();
        graduacaoText.clear();
        telefoneDoisText.clear();
        telefoneUmText.clear();
        carregarTable(Facade.getInstance().findAllPedagogo());

    }

    //__________________________________________________________________________________________________________________


    @FXML
    public void action(ActionEvent event){

        if (event.getSource() == novoPedagogoButton){
            limparaCampos();
        }

        if (event.getSource() == salvarPedagogoButton){
            Pedagogo ped = new Pedagogo ();
            Endereco endereco = new Endereco ();
            Telefone telefone =  new Telefone();
            Telefone telefone1 = new Telefone();
            String mensagem = "Salvo com Sucesso!";

            //ATUALIZAR
            if (educandoTable.getSelectionModel().getSelectedItem()!=null){
                ped.setId(educandoTable.getSelectionModel().getSelectedItem().getId());
                endereco.setId(educandoTable.getSelectionModel().getSelectedItem().getEndereco().getId());
                mensagem = "Atualizado com Sucesso!";
                List<Telefone> telefoneList = null;
                telefoneList = Facade.getInstance().findAllIdTelefone(ped.getId());
                telefone.setId(telefoneList.get(0).getId());
                telefone1.setId(telefoneList.get(1).getId());
            }

            endereco.setLogradouro (logradouroText.getText ());
            endereco.setNumero (numeroText.getText ());
            endereco.setComplemento (complementoText.getText ());
            endereco.setBairro (bairroText.getText ());
            endereco.setCidade (cidadeText.getText ());
            endereco.setCep (cepText.getText ());
            endereco.setUf (comboboxUf.valueProperty ().get ().toString ());

            ped.setCpf (cpfText.getText ());
            ped.setDataNascimento ((Date) dataText.getUserData ());
            ped.setNaturalidade (naturalidadeText.getText ());
            ped.setNome (nomeText.getText ());
            ped.setGraduacao (graduacaoText.getText ());
            ped.setStatus(true);

            telefone.setNumero(telefoneUmText.getText());
            telefone1.setNumero(telefoneDoisText.getText());

            ped.setEndereco (endereco);
            ped = Facade.getInstance ().savePedagogo (ped);
            telefone.setPessoa(ped);
            telefone1.setPessoa(ped);

            Facade.getInstance().saveTelefone(telefone);
            Facade.getInstance().saveTelefone(telefone1);
            Mensagem.mensagemSucesso (mensagem);
            limparaCampos();
        }

        if (event.getSource() == apagarPedagogoButton){
            //TROCAR O STATUS DELE FARA FALSE
        }
        if (event.getSource() == pesquisarPedagogoButton){
            //PESQUISAR POR NOME --> IMPLEMENTAR
        }

        if (event.getSource() == acompanhamentoButton){
            //SÓ ABRIDE UM ALUNO ANTES FOR SELECIONADO
        }
    }


    @FXML
    void actionKeyPressed(KeyEvent event) {
        System.out.println("não implementado ainda! ");
//        carregarTable(Facade.getInstance().findAllStringPedagogo(pesquisaText.getText()));
    }


}
