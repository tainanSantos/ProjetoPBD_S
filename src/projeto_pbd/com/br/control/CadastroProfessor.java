package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;

import java.net.URL;
import java.util.*;


public class CadastroProfessor implements Initializable {


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

    @FXML
    private Button salvarButton;





    private List listUfsProf = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));

    private Professor professor = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                if (userData != null && newScene.equalsIgnoreCase("AreaProfessor.fxml_atualzar")){
                    apagarButton.setVisible (true);
                    professor = (Professor) userData;
                    carregarObjetoSelecioando (professor);
                }
            }
        });


        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
    }



    public void carregarObjetoSelecioando(Professor professor){

        logradouroText.setText (professor.getEndereco ().getLogradouro ());
        numeroText.setText (professor.getEndereco ().getNumero ());
        complementoText.setText (professor.getEndereco ().getComplemento ());
        bairroText.setText (professor.getEndereco ().getBairro ());
        cidadeText.setText (professor.getEndereco ().getCidade ());
        cepText.setText (professor.getEndereco ().getCep ());

        comboboxUf.getSelectionModel().select(professor.getEndereco ().getUf ());

//        telefoneUmText.setText (professor.getTelefones ().get (0).getNumero ());
//        telefoneDoisText.setText (professor.getTelefones ().get (1).getNumero ());

        nomeText.setText (professor.getNome ());
        dataText.setText (String.valueOf (professor.getDataNascimento ()));
        naturalidadeText.setText (professor.getNaturalidade ());
        cpfText.setText (professor.getCpf ());
        graduacaoText.setText (professor.getGraduacao ());

    }


    @FXML
    void action(ActionEvent event) {

        //SALVA E ATUALIZAR PROFESSOR
        if (event.getSource() == salvarButton){
            Professor prof = new Professor ();
            Endereco endereco = new Endereco ();
            Telefone telefone = new Telefone ();
            Telefone telefone1 = new Telefone ();

            String mensagem = "Salvo com Sucesso!";

            if (professor != null){
                prof = professor;
                mensagem = "Atualizado com Sucesso!";
                endereco = prof.getEndereco ();
//                telefone = prof.getTelefones ().get (0);
//                telefone1 = prof.getTelefones ().get (1);
            }

            endereco.setLogradouro (logradouroText.getText ());
            endereco.setNumero (numeroText.getText ());
            endereco.setComplemento (complementoText.getText ());
            endereco.setBairro (bairroText.getText ());
            endereco.setCidade (cidadeText.getText ());
            endereco.setCep (cepText.getText ());
            endereco.setUf (comboboxUf.valueProperty ().get ().toString ());

            telefone.setNumero (telefoneUmText.getText ());
            telefone1.setNumero (telefoneDoisText.getText ());

            prof.setCpf (cpfText.getText ());
            prof.setDataNascimento ((Date) dataText.getUserData ());
            prof.setNaturalidade (naturalidadeText.getText ());
            prof.setNome (nomeText.getText ());
            prof.setGraduacao (graduacaoText.getText ());

            prof.setEndereco (endereco);


            //Salvando ou atualizando
            Facade.getInstance ().saveProfessor (prof);
            telefone.setPessoa (prof);
            telefone1.setPessoa (prof);
            Facade.getInstance().saveTelefone(telefone);
            Facade.getInstance().saveTelefone(telefone1);
            Mensagem.mensagemSucesso (mensagem);
        }

        //REMOVER PROFESSOR
        if (event.getSource() == apagarButton){
            Facade.getInstance ().removeProfessor (professor.getId ());
            Mensagem.mensagemSucesso ("Removido com sucesso!");
        }

        // campos informados errados não posso fechar a tela
        fecharTela();

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

