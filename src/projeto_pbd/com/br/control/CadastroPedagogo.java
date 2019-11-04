package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.*;

public class CadastroPedagogo implements Initializable {

    @FXML
    private TextField graduacaoText;
    @FXML
    private TextField nomeText;
    @FXML
    private TextField naturalidadeText;
    @FXML
    private TextField dataText;
    @FXML
    private TextField cpfText;
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
    private Button apagarButton;


    private List listUfsProf = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));

    private Pedagogo pedagogo = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                if (newScene.equalsIgnoreCase("AreaPedagogo_Atualzar") && userData!=null){
                    pedagogo = (Pedagogo) userData;
                    apagarButton.setVisible (true);
                    atualizar();
                }
            }
        });

        this.comboboxUf.getItems().setAll(this.listUfsProf);
//        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));

        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
    }



    public void atualizar(){

        logradouroText.setText (pedagogo.getEndereco ().getLogradouro ());
        numeroText.setText (pedagogo.getEndereco ().getNumero ());
        complementoText.setText (pedagogo.getEndereco ().getComplemento ());
        bairroText.setText (pedagogo.getEndereco ().getBairro ());
        cidadeText.setText (pedagogo.getEndereco ().getCidade ());
        cepText.setText (pedagogo.getEndereco ().getCep ());

        comboboxUf.getSelectionModel().select(pedagogo.getEndereco ().getUf ());

        nomeText.setText (pedagogo.getNome ());
        dataText.setText (String.valueOf (pedagogo.getDataNascimento ()));
        naturalidadeText.setText (pedagogo.getNaturalidade ());
        cpfText.setText (pedagogo.getCpf ());
        graduacaoText.setText (pedagogo.getGraduacao ());

    }



    public void salvarCadastro() {
        Pedagogo ped = new Pedagogo ();
        Endereco endereco = new Endereco ();
        Telefone telefone = new Telefone();
        Telefone telefone1 = new Telefone();

        String mensagem = "Salvo com Sucesso!";

        // ATUALIZANDO
        if (pedagogo != null){
            ped = pedagogo;
            mensagem = "Atualizado com Sucesso!";
            endereco = ped.getEndereco ();

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

        ped.setEndereco (endereco);
        ped = Facade.getInstance ().savePedagogo (ped);

        telefone.setPessoa(ped);
        telefone1.setPessoa(ped);
        Facade.getInstance().saveTelefone(telefone);
        Facade.getInstance().saveTelefone(telefone1);

        fecharTela();
        Mensagem.mensagemSucesso (mensagem);
    }


    public void deletarCadastro(){
        Facade.getInstance ().removePedagogo (pedagogo.getId ());
        fecharTela();
        Mensagem.mensagemSucesso ("Removido com sucesso!");

    }


    public void fecharTela(){
        Stage stage = null;
        stage = Main.STAGE2;
        stage.getOnCloseRequest ().handle (
                new javafx.stage.WindowEvent (
                        stage, javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST));
        stage.close ();

    }
}
