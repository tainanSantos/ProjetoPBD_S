package projeto_pbd.com.br.control;

import javafx.fxml.Initializable;
import projeto_pbd.Main;
import sun.rmi.server.MarshalInputStream;

import java.net.URL;
import java.util.ResourceBundle;

public class Relatorios implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                // vou precisar disso aqui para pegar as coisas das telas
                // que será usarei para gerar as coisas lá das outra coisas lá
            }
        });
    }

}
