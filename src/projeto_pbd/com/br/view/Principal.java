package projeto_pbd.com.br.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;

import java.io.IOException;


public class Principal {

    public final String CADASTRO_PESSOA = "CadastroAluno.fxml";
    public final String CADASTRO_CURRICULO = "CadastroCurriculo.fxml";
    public final String CADASTRO_DISCIPLINA = "CadastroDisciplina.fxml";
    public final String PESQUISA = "Pesquisa.fxml";
    public final String CONFIGURACOES = "Configuracoes.fxml";
    public final String RELATORIO_DISCENTE = "RelatorioDiscente.fxml";


    @FXML
    public AnchorPane anchorPanePrincipal;

    /**
     *
     *
     *
     *
     */


    public void cadastrarAluno() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_PESSOA)));

    }


    public void  cadastrarCurriculo() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_CURRICULO)));
    }


    public void cadastrarFuncionario(){
//        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
//        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(?????)));
    }

    public void cadastrarDisciplina() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_DISCIPLINA)));
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

    public void informacoesDiscente() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(RELATORIO_DISCENTE)));


    }
}
