package projeto_pbd.com.br.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;

import java.io.IOException;


public class Principal {

    public final String LOGIN_PANE = "Login.fxml";
    public final String CADASTRO_PANE = "CadastroPessoa.fxml";
    public final String PESQUISA = "Pesquisa.fxml";
    public final String CONFIGURACOES = "Configuracoes.fxml";

    @FXML
    public AnchorPane anchorPanePrincipal;

    /**
     *
     *
     *
     *
     */


    public void cadastrarPessoa() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_PANE)));

    }

    public void logar() throws IOException {
        Main.stageLogin().show();
    }

    public void configuracoesGerais() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CONFIGURACOES)));
    }

    public void pesquisa() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(PESQUISA)));
    }
}
