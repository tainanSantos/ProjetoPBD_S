package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projeto_pbd.Main;

import java.io.IOException;

public class CadastroCurriculo {

    public void cadastrarNovaDisciplina() throws IOException {
        Main.genericaStage (Main.CADASTRO_DISCIPLINA).show ();

    }


}
