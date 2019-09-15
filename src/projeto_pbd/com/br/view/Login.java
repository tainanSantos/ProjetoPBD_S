package projeto_pbd.com.br.view;

import projeto_pbd.Main;

import java.io.IOException;

public class Login {

    public void fazerLogin() throws IOException {
        Main.stageLogin().close();
        Main.stagePrincipal().show();
    }

}
