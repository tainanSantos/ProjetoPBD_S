package projeto_pbd.com.br.control;

import javafx.fxml.Initializable;
import projeto_pbd.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroResponsavelFinanceiro implements Initializable {




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

    }
}
