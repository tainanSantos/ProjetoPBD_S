package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Principal implements Initializable {

    // perceba que o control fora da pasta view
    // deixa a trasição entre telas um pouco mais lenta

    public static final String CADASTRO_ALUNO = "../view/CadastroAluno.fxml";
    public static final String CADASTRO_CURRICULO = "../view/CadastroCurriculoEDisciplina.fxml";
    public static final String CADASTRO_DISCIPLINA = "../view/CadastroDisciplina.fxml";
    public static final String CADASTRO_PROFESSOR_PEDAGOGO= "../view/CadastroProfessor.fxml";
    public static final String CADASTRO_PROFESSOR = "../view/CadastroProfessor.fxml";
    public static final String HOME = "../view/Home.fxml";
    public static final String CONFIGURACOES = "../view/Configuracoes.fxml";
    public static final String AREA_DISCENTE = "../view/AreaDiscente.fxml";
    public static final String AREA_DO_PROFESSOR = "../view/AreaProfessor.fxml";
    public static final String AREA_DO_PEDAGOGO = "../view/AreaPedagogo.fxml";
    public static final String CADASTRAR_USUARIO_DO_SISTEMA = "../view/CadastrarUsuarioDoSistema.fxml";
    public static final String TURMA_GERENCIAMENTO = "../view/TurmaGerenciamento.fxml";



    @FXML
    private AnchorPane anchorPanePrincipal;

    @FXML
    private MenuItem homeMenuItem;

    @FXML
    private MenuItem areaAlunoMenuItem;

    @FXML
    private MenuItem gerenciamentoTurmaMenuItem;

    @FXML
    private MenuItem areaProfessorMenuItem;

    @FXML
    private MenuItem cacadastroCurriculoMenuItem;

    @FXML
    private MenuItem configuracoeMenuItem;

    @FXML
    private MenuButton usuarioButton;

    @FXML
    private MenuItem cadastroUasuarioMenuItem;

    @FXML
    private MenuItem sairUsuarioMenuItem;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

//         criar um método estático em uma class fora só para carregar as mensagens d Tooltip
//        usuarioButton.setTooltip (new Tooltip ("Usuário do Sistem"));
//        labelArgusAcad.setTooltip (new Tooltip ("Sistema para Escola de Ensiono Funadamental e Médio"));

        try {
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(HOME)));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }


    public void actionEvent(ActionEvent event) throws IOException {


        if (event.getSource () == cacadastroCurriculoMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CADASTRO_CURRICULO)));
        }
        if (event.getSource () == areaAlunoMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(AREA_DISCENTE)));
        }
        if (event.getSource () == homeMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(HOME)));
        }
        if (event.getSource () == configuracoeMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(CONFIGURACOES)));
        }

        if (event.getSource() == areaProfessorMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(AREA_DO_PROFESSOR)));
        }

        if (event.getSource() == gerenciamentoTurmaMenuItem){
            this.anchorPanePrincipal.getChildren().clear();
            this.anchorPanePrincipal.getChildren().add(FXMLLoader.load(getClass().getResource(TURMA_GERENCIAMENTO)));
        }

        //MENU BUTTON
        if (event.getSource () == cadastroUasuarioMenuItem){
            Main.genericaStage (Main.CADASTRAR_USUARIO_DO_SISTEMA).show ();
        }
       
        if (event.getSource () == sairUsuarioMenuItem){
            Main.stagePrincipal ().close ();
            Main.stageLogin ().show ();
        }

    }





}
