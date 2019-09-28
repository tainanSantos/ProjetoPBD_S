package projeto_pbd.com.br.control;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import projeto_pbd.Main;

import java.io.IOException;
import java.util.ArrayList;


public class Principal {

    // perceba que o control fora da pasta view
    // deixa a trasição entre telas um pouco mais lenta

    public static final String CADASTRO_ALUNO = "../view/CadastroAluno.fxml";
    public static final String CADASTRO_CURRICULO = "../view/CadastroCurriculo.fxml";
    public static final String CADASTRO_DISCIPLINA = "../view/CadastroDisciplina.fxml";
    public static final String CADASTRO_FUNCIONARIO = "../view/CadastroFuncionario.fxml";
    public static final String PESQUISA = "../view/Home.fxml";
    public static final String CONFIGURACOES = "../view/Configuracoes.fxml";
    public static final String RELATORIO_DISCENTE = "../view/AreaDiscente.fxml";

    @FXML
    private ComboBox comboBoxLogin;
    private ArrayList arrayListLogin = new ArrayList ();

    @FXML
    private AnchorPane anchorPanePrincipal;


    public void informacoesUsuario() throws IOException{
        Main.STAGE.setScene (new Scene (FXMLLoader.load(getClass().getResource(CADASTRO_ALUNO))));
        Main.STAGE.setOnCloseRequest(new EventHandler<WindowEvent> () {public void handle(WindowEvent event) { }});
        Main.STAGE.show ();
    }


    public void sairDoSistema() throws IOException{
            Main.stagePrincipal ().close ();
            Main.stageLogin ().show ();
    }


    public void cadastrarAluno() throws IOException {

        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_ALUNO)));
//        FXMLLoader loader = new FXMLLoader ();
//        loader.setLocation (getClass().getResource(CADASTRO_ALUNO));
//        Parent root = loader.load ();
//
//        this.anchorPanePrincipal.getChildren().add(root);
//
//        root.translateXProperty ().set(Main.stagePrincipal ().getScene ().getWidth ());
//
////        root.translateYProperty ().set(Main.stagePrincipal ().getScene ().getHeight ());
//
//        Timeline timeL = new Timeline ();
//        KeyValue kv = new KeyValue (root.translateXProperty (), 0, Interpolator.EASE_IN);
//
//        KeyFrame kf = new KeyFrame (Duration.seconds (1), kv);
//
//        timeL.getKeyFrames ().add (kf);
//        timeL.setOnFinished (e -> {
////            this.anchorPanePrincipal.getChildren().clear();
//        });
//
//        timeL.play ();



    }


    public void  cadastrarCurriculo() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_CURRICULO)));
    }


    public void cadastrarFuncionario() throws IOException {
        this.anchorPanePrincipal.getChildren().clear(); // limpar o pane coso ele venha sujo
        this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_FUNCIONARIO)));
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
