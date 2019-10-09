package projeto_pbd.com.br.control;

import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projeto_pbd.Main;

import java.io.IOException;

public class AreaDiscente {

    public void infromacoesDiscente() throws IOException {

        /*
            VERIFICAR SE ALGUM ALUNO FOI SELECIOANDO NA TEBELA
            2 cliques na linha ta tabela abrira isso aqui
            tem que ter algum objeto na linha para abrir
        */

        Stage stage = Main.genericaStage (Main.AREA_DISCENTE_INFORMACOES);
        stage.show ();
    }

    public void cadastrarNovoAluno() throws IOException {
        Stage stage = Main.genericaStage (Main.CADASTRO_ALUNO);
        stage.show ();
    }


}
