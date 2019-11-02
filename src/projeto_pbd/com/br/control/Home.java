package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {


    @FXML
    private Button cadastrarProfessorButton;

    @FXML
    private Button listarProfessoresButton;

    @FXML
    private Button cadastrarNovoALunoButton;

    @FXML
    private Button listarAlunosCadastradosButton;

    @FXML
    private Button alunosOutrosButton;

    @FXML
    private Button cadastrarPedagogoButton;

    @FXML
    private Button listarPedagogosCadastradosButton;

    @FXML
    private Button novaDisciplinaButton;

    @FXML
    private Button buscarDsciplinasCadastradasButton;

    @FXML
    private Button disciplinasOutroButton;

    @FXML
    private Button cadastrarNovoCurriculoButton;

    @FXML
    private Button ListarCurriculosCadastradosButton;

    @FXML
    private Button curriculoOutrosButton;


    public void action(ActionEvent event) throws IOException {

        //Pra Professor
        if (event.getSource() == cadastrarProfessorButton){
            Main.genericaStage(Main.CADASTRO_PROFESSOR).show();
        }
        if (event.getSource() == listarProfessoresButton){
            Main.genericaStage(Main.AREA_PROFESSOR).show();
        }

        //Pra Pedagogo
        if (event.getSource() == cadastrarPedagogoButton){
            Main.genericaStage(Main.CADASTRO_PEDAGOGO).show();
        }
        if (event.getSource() == listarPedagogosCadastradosButton){
            Main.genericaStage(Main.AREA_PEDAGOGO).show();
        }

        //Pra Disciplina

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });

    }




}
