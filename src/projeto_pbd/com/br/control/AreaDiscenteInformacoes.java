package projeto_pbd.com.br.control;

import projeto_pbd.Main;

import java.io.IOException;

public class AreaDiscenteInformacoes {


    public void adicionarNotas() throws IOException {
        Main.genericaStage (Main.CADASTRO_NOTAS).show ();
    }


    public void acompanhamentoPedagogico() throws IOException {
        /*
            criar a tela para acompanahamento pedagogico
        */
        Main.genericaStage (Main.AREA_DISCENTE_ACOMPANHAMENTO_PEDAGOGICO).show ();

    }


}
