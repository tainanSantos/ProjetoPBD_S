package projeto_pbd;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	public static  final  String LOGIN_PANE = "com/br/view/Login.fxml";
	public static  final  String PRINCIPLA_PANE = "com/br/view/Principal.fxml";
	public static final String CADASTRO_ALUNO = "com/br/view/CadastroAluno.fxml";
	public static final String CADASTRO_CURRICULO = "com/br/view/CadastroCurriculo.fxml";
	public static final String CADASTRO_DISCIPLINA = "com/br/view/CadastroDisciplina.fxml";
	public static final String CADASTRO_FUNCIONARIO = "com/br/view/CadastroFuncionario.fxml";
	public static final String CADASTRO_NOTAS = "com/br/view/CadastroNotas.fxml";
	public static final String AREA_DISCENTE_INFORMACOES = "com/br/view/AreaDiscenteInformacoes.fxml";
	public static final String CONFIGURACOES = "com/br/view/Configuracoes.fxml";
	public static final String RELATORIO_DISCENTE = "com/br/view/AreaDiscente.fxml";

	public static  Stage STAGE = new Stage(); // usar sempre que for abrir uma nova tela
	public static  Stage STAGE_PRINCIPAL = new Stage();


	@Override
	public void start(Stage primaryStage) throws Exception {

		STAGE.initOwner (STAGE_PRINCIPAL);
		STAGE.initModality (Modality.WINDOW_MODAL);

		stageLogin().show();
	}


	public static Stage stagePrincipal() throws IOException {
		STAGE_PRINCIPAL.setScene(new Scene(
				FXMLLoader.load(Main.class.getResource(PRINCIPLA_PANE))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {System.exit(0);}});
		return  STAGE_PRINCIPAL;
	}


    public static  Stage stageLogin() throws IOException {
        STAGE.setScene(new Scene(
                FXMLLoader.load(Main.class.getResource(LOGIN_PANE))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) { STAGE.close(); }});
        return STAGE;
    }


	public static Stage genericaStage(String caminho) throws IOException {
		STAGE.setScene(new Scene(
				FXMLLoader.load(Main.class.getResource (caminho))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) { STAGE.close(); }});
		return STAGE;
	}


	public static void main(String[] args) {
		launch(args);
	}




}
