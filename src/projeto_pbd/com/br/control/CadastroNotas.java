package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import projeto_pbd.Main;

import java.io.IOException;

public class CadastroNotas {


    @FXML
    private TextField textFieodVa1;
    @FXML
    private TextField textFieldVa2;
    @FXML
    private TextField textFieldVa3;
    @FXML
    private TextField textFieldVaFinal;
    @FXML
    private TextField media;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Label labelMostrarResultado;
    @FXML
    private Button buttonCancelar;


    public void adicionarNota() throws IOException {

        // fazer antes a validação dos campos

       Stage stage =  Main.genericaStage (Main.AREA_DISCENTE_INFORMACOES);
       stage.show ();
    }

    public void cancelar() throws IOException {
        Main.genericaStage (Main.AREA_DISCENTE_INFORMACOES).show ();
    }




}
