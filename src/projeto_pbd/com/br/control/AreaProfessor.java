package projeto_pbd.com.br.control;

import javafx.stage.Stage;
import projeto_pbd.Main;

import java.io.IOException;

public class AreaProfessor {

    public void cadastrarNovoProfessor() throws IOException {

        Stage stage = Main.genericaStage (Main.CADASTRO_PROFESSOR);
        stage.show ();

    }
}
