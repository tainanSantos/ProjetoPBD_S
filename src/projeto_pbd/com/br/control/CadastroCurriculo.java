package projeto_pbd.com.br.control;

import javafx.scene.Scene;
import javafx.stage.Stage;
import projeto_pbd.Main;

import java.io.IOException;

public class CadastroCurriculo {

    public void cadastrarNovaDisciplina() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_DISCIPLINA);
        stage.show ();
    }


}
