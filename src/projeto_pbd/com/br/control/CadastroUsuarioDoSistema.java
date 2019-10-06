package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroUsuarioDoSistema implements Initializable {

    @FXML
    private ComboBox comboboxTipoFunacionario;
    private List listTipoFuncionario = new ArrayList();

    @FXML
    private AnchorPane anchorpaneCadastroUser1;
    @FXML
    private AnchorPane anchorpaneCadastroUser2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboboxTipoFunacionario();
    }


    public void carregarComboboxTipoFunacionario(){
        this.listTipoFuncionario.add ("Adiminstração");
        this.listTipoFuncionario.add ("Direção ");
        this.listTipoFuncionario.add ("Coordenação Pedagogica");
        this.listTipoFuncionario.add ("Secretaria");
        this.comboboxTipoFunacionario.setItems (FXCollections.observableArrayList (this.listTipoFuncionario));
    }

    public void proximatelaCadastroUsuarioDoSistema(){
        this.anchorpaneCadastroUser1.setVisible (false);
        this.anchorpaneCadastroUser2.setVisible (true);
    }

    public void voltarTelaAnterioCadastroUsuario(){
        this.anchorpaneCadastroUser1.setVisible (true);
        this.anchorpaneCadastroUser2.setVisible (false);
    }

    public void salvarCaradastroUsuario(){

    }

}
