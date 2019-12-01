package projeto_pbd;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;
import projeto_pbd.com.br.msg.Mensagem;

public class Main extends Application {

//	alteração só pra teste

	public static final String LOGIN_PANE = "com/br/view/Login.fxml";
	public static final String PRINCIPLA_PANE = "com/br/view/Principal.fxml";
	public static final String CADASTRO_ALUNO = "com/br/view/CadastroAluno.fxml";
	public static final String CADASTRO_CURRICULO = "com/br/view/CadastroCurriculoEDisciplina.fxml";
	public static final String CADASTRO_DISCIPLINA = "com/br/view/CadastroDisciplina.fxml";
	public static final String CADASTRO_PROFESSOR = "com/br/view/CadastroProfessor.fxml";
	public static final String CADASTRO_PEDAGOGO = "com/br/view/CadastroPedagogo.fxml";
	public static final String CADASTRO_NOTAS = "com/br/view/CadastroNotas.fxml";
	public static final String AREA_DISCENTE_INFORMACOES = "com/br/view/AreaDiscenteInformacoes.fxml";
	public static final String AREA_PROFESSOR = "com/br/view/AreaProfessor.fxml";
	public static final String CONFIGURACOES = "com/br/view/Configuracoes.fxml";
	public static final String RELATORIO_DISCENTE = "com/br/view/AreaDiscente.fxml";
	public static final String AREA_DISCENTE_ACOMPANHAMENTO_PEDAGOGICO = "com/br/view/AreaDiscenteAcompPedag.fxml";
	public static final String CADASTRAR_USUARIO_DO_SISTEMA = "com/br/view/CadastrarUsuarioDoSistema.fxml";
	public static final String CADASTRAR_TIPO_CURRICULO = "com/br/view/CadastroTipoCurriculo.fxml";
	public static final String TURMA_GERENCIAMENTO = "com/br/view/TurmaGerenciamento.fxml";
	public static final String REDEFINIR_SENHA_ADMIN = "com/br/view/RedefinirSenha.fxml";
	public static final String GERAR_PARCELAS = "com/br/view/ParcelasGerar.fxml";


	//__________________________________________________________________________________________________________________


	private static String TIPO_USUARIO;
	private static Usuario NOTIFICATIO_SENHA_UPDATE_USER;
	private static Usuarioview usuarioLogado;


	//__________________________________________________________________________________________________________________


	public static  Stage STAGE = new Stage(); // usar sempre que for abrir uma nova tela
	public static  Stage STAGE2 = new Stage(); // usar sempre que for abrir uma nova tela2
	public static  Stage STAGE_PRINCIPAL = new Stage();


	//__________________________________________________________________________________________________________________

	/*
		"Não existe segredo. Apenas chegue antes, saia depois, faça mais do que te pedem e confie 100% em si mesmo"
		- Cristiano Ronaldo
	*/

	@Override
	public void start(Stage primaryStage) throws Exception {

		STAGE.initOwner (STAGE_PRINCIPAL);
		STAGE.initModality (Modality.WINDOW_MODAL);

		STAGE2.initOwner (STAGE_PRINCIPAL);
		STAGE2.initOwner (STAGE);
		STAGE2.initModality (Modality.WINDOW_MODAL);

		stageLogin().show();
	}


	public static Stage stagePrincipal() throws IOException {
		STAGE_PRINCIPAL.setScene(new Scene(
				FXMLLoader.load(Main.class.getResource (PRINCIPLA_PANE))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
			    System.exit(0);}});
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
			public void handle(WindowEvent event) { STAGE.close();
			}});
		return STAGE;
	}


	public static Stage genericaStage2(String caminho) throws IOException {
		STAGE2.setScene(new Scene(
				FXMLLoader.load(Main.class.getResource (caminho))));
		STAGE2.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) { STAGE2.close();
			}});
		return STAGE2;
	}


	public static Stage genericaStageComParametro(String caminho, Object object) throws IOException {
		STAGE.setScene(new Scene(
				FXMLLoader.load(Main.class.getResource (caminho))));
		STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) { STAGE.close(); }});
		return STAGE;
	}


	//__________________________________________________________________________________________________________________
	//TRANSIÇÃO ENTRE TELAS


	public static void changeScreen(String scr, Object userData){
		notifyAllListeners(scr, userData);
	}

	public static void changeScreen(String scr){
		changeScreen(scr, null);
	}

	private static ArrayList<OnchangeSceneen> listners = new ArrayList<>();

	public static interface OnchangeSceneen{
		void onScreenchanged(String newScene, Object userData );
	}

	public static void addOnChangeScreenListener(OnchangeSceneen newListener){
		listners.add(newListener);
	}

	private static  void notifyAllListeners(String newScereen, Object userData){
		for(OnchangeSceneen l: listners)
			l.onScreenchanged(newScereen, userData);
	}


	//__________________________________________________________________________________________________________________


	public static void main(String[] args) {
		launch(args);
	}


	//__________________________________________________________________________________________________________________


	public static Usuario getNotificatioSenhaUpdateUser() {
		if (NOTIFICATIO_SENHA_UPDATE_USER != null){
			Mensagem.mensagemErro("Usuario: "+NOTIFICATIO_SENHA_UPDATE_USER.getNome()+
					" tipo de acesso: "+NOTIFICATIO_SENHA_UPDATE_USER.getTipoDeAcesso()+
					" de CPF: "+NOTIFICATIO_SENHA_UPDATE_USER.getCpf()+
					" e email: " + NOTIFICATIO_SENHA_UPDATE_USER.getCpf()+
					". Atualizou Senha.");
		}
		setNotificatioSenhaUpdateUser(null);
		return null;
	}

	public static void setNotificatioSenhaUpdateUser(Usuario notificatioSenhaUpdateUser) {
		NOTIFICATIO_SENHA_UPDATE_USER = notificatioSenhaUpdateUser;
	}

	public static String getTipoUsuario() {
		return TIPO_USUARIO;
	}

	public static void setTipoUsuario(String tipoUsuario) {
		TIPO_USUARIO = tipoUsuario;
	}

	public static Usuarioview getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuarioview usuarioLogado) {
		Main.usuarioLogado = usuarioLogado;
	}
}
