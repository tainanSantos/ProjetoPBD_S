package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import projeto_pbd.Main;

import java.io.IOException;
import java.util.ArrayList;

public class CadastroDisciplina {

    @FXML
    private ComboBox comboboxProfessoresCadastrados;
    private ArrayList professoresCadastradosList =  new ArrayList();


    public void salvarCadastroDisciplina(){

    }


    public void cancelarCadastroDisciplina(){

    }


    public void comboboxCarregarProfessoresCadastrados(){
        /*
        * buscar os professores já cadastrados na base e setar lá no combobox
        * */
    }

    public void cadastraNovoProfessor() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_PROFESSOR);
        stage.show ();
    }
}
