package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaDiscenteAcompPedag implements Initializable {


    @FXML
    private TextField pedagogoLogadoText; // setar o nome do pedagogo logado no sstema para esse campo

    @FXML
    private CheckBox acompanhamentoConcluidoBoolean;

    @FXML
    private Button salvarAcompanhamentoButton;

    //__________________________________________________________________________________________________________________

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
    }

    //__________________________________________________________________________________________________________________

    @FXML
    void action(ActionEvent event) {
        if (event.getSource() == salvarAcompanhamentoButton){

        }

        if (acompanhamentoConcluidoBoolean.isSelected()){
            //fechar secao
        }
    }


}