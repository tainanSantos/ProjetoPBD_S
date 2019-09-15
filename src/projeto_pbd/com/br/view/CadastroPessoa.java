package projeto_pbd.com.br.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadastroPessoa implements Initializable {


    @FXML
    private ComboBox comboBoxSelecaoCadastro;
    private ArrayList selecaoCadastroList = new ArrayList();

    @FXML
    private AnchorPane anchorpaneCadastroAluno;

    @FXML
    private AnchorPane anchorpaneCadastroPedagogo;

    @FXML
    private AnchorPane anchorpaneCadastroPessoa;

    @FXML
    private AnchorPane anchorpaneCadastroProfessor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBox();
    }


    public void salvar(){
        System.out.println("Ssalvo com sucesso!");
    }


    public void setarTabelaPesquisa() {

        int valor = this.comboBoxSelecaoCadastro.getSelectionModel().getSelectedIndex();

        this.anchorpaneCadastroAluno.setVisible(false);
        this.anchorpaneCadastroPedagogo.setVisible(false);
        this.anchorpaneCadastroPessoa.setVisible(false);
        this.anchorpaneCadastroProfessor.setVisible(false);

        switch (valor){
            case 0:{
                this.anchorpaneCadastroAluno.setVisible(true);
                break;
            }
            case 1:{
                this.anchorpaneCadastroPedagogo.setVisible(true);
                break;
            }
            case 2:{
                this.anchorpaneCadastroPessoa.setVisible(true);
                break;
            }
            case 3:{
                this.anchorpaneCadastroProfessor.setVisible(true);
                break;
            }
        }
    }


    public void carregarComboBox(){
        this.selecaoCadastroList.add("aluno");
        this.selecaoCadastroList.add("pedagogo");
        this.selecaoCadastroList.add("pessoa");
        this.selecaoCadastroList.add("professor");
        this.comboBoxSelecaoCadastro.setItems( FXCollections.observableArrayList(selecaoCadastroList));
    }


}
