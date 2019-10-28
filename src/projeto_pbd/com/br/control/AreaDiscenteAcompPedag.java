package projeto_pbd.com.br.control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaDiscenteAcompPedag implements Initializable {


    @FXML
    private ComboBox comboboxPedagogos;
    private List listPedagogos = new ArrayList (
//            Arrays.asList (new String[]{"AC", "AL", "" +
//            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
//            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"})
    );


    public void salvarAtendiemntoPedagogico() throws IOException {
        Main.genericaStage (Main.AREA_DISCENTE_INFORMACOES).show ();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
//        this.comboboxPedagogos.setItems (FXCollections.observableArrayList (this.listPedagogos));

    }
}
