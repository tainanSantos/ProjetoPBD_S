package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.FacadePedagogo;
import projeto_pbd.com.br.façade.FacadeProfessor;
import projeto_pbd.com.br.façade.IFacadePedagogo;
import projeto_pbd.com.br.façade.IFacadeProfessor;
import projeto_pbd.com.br.modell.Endereco;
import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.msg.Mensagem;
import projeto_pbd.com.br.util.MaskFieldUtil;
import projeto_pbd.com.br.util.ObjetctUtil;

import java.net.URL;
import java.util.*;


public class CadastroPedagogo implements Initializable {


    private IFacadePedagogo facadePedagogo;

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


    public CadastroPedagogo() {
        this.facadePedagogo = new FacadePedagogo ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.comboboxUf.setItems (FXCollections.observableArrayList (this.listUfsProf));

        if (ObjetctUtil.getObject () != null){
            apagarButton.setVisible (true);
           carregarObjetoSelecioando ();
        }
        MaskFieldUtil.dateField (this.dataText);
        MaskFieldUtil.cpfField (this.cpfText);
        MaskFieldUtil.cepField (this.cepText);
        MaskFieldUtil.foneField (this.telefoneUmText);
        MaskFieldUtil.foneField (this.telefoneDoisText);
    }



    public void carregarObjetoSelecioando(){

        Pedagogo pedagogo = null;
        pedagogo = (Pedagogo) ObjetctUtil.getObject ();

        logradouroText.setText (pedagogo.getEndereco ().getLogradouro ());
        numeroText.setText (pedagogo.getEndereco ().getNumero ());
        complementoText.setText (pedagogo.getEndereco ().getComplemento ());
        bairroText.setText (pedagogo.getEndereco ().getBairro ());
        cidadeText.setText (pedagogo.getEndereco ().getCidade ());
        cepText.setText (pedagogo.getEndereco ().getCep ());

        comboboxUf.getSelectionModel().select(pedagogo.getEndereco ().getUf ());

        telefoneUmText.setText (pedagogo.getTelefones ().get (0).getNumero ());
        telefoneDoisText.setText (pedagogo.getTelefones ().get (1).getNumero ());

        nomeText.setText (pedagogo.getNome ());
        dataText.setText (String.valueOf (pedagogo.getDataNascimento ()));
        naturalidadeText.setText (pedagogo.getNaturalidade ());
        cpfText.setText (pedagogo.getCpf ());
        graduacaoText.setText (pedagogo.getGraduacao ());

    }



    public void salvarCadastro() {
        Pedagogo pedagogo = new Pedagogo ();
        Endereco endereco = new Endereco ();
        Telefone telefone = new Telefone ();
        Telefone telefone1 = new Telefone ();

        String mensagem = "Salvo com Sucesso!";


        if (ObjetctUtil.getObject () != null){

            mensagem = "Atualizado com Sucesso!";
            pedagogo = (Pedagogo) ObjetctUtil.getObject ();

            System.out.println (pedagogo.getId ());
            endereco = pedagogo.getEndereco ();
            telefone = pedagogo.getTelefones ().get (0);
            telefone1 = pedagogo.getTelefones ().get (1);

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

        List<Telefone> telefones = new ArrayList (Arrays.asList (new Telefone[]{telefone, telefone1}));

        pedagogo.setCpf (cpfText.getText ());
        pedagogo.setDataNascimento ((Date) dataText.getUserData ());
        pedagogo.setNaturalidade (naturalidadeText.getText ());
        pedagogo.setNome (nomeText.getText ());
        pedagogo.setGraduacao (graduacaoText.getText ());

        pedagogo.setEndereco (endereco);
        telefone.setPedagogo (pedagogo);
        telefone1.setPedagogo (pedagogo);
        pedagogo.setTelefones (telefones);

        this.facadePedagogo.save (pedagogo);

        Main.STAGE.close ();
        ObjetctUtil.setObject (null);
        Mensagem.mensagemSucesso (mensagem);
    }


    public void deletarCadastro(){
        Pedagogo pedagogo = (Pedagogo) ObjetctUtil.getObject ();
        this.facadePedagogo.remove (pedagogo.getId ());
        Main.STAGE.close ();
        Mensagem.mensagemSucesso ("Removido com sucesso!");

    }

}
