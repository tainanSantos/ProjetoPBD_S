package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.modell.Aluno;

import java.net.URL;
import java.util.ResourceBundle;

public class ParcelasGerar implements Initializable {


    @FXML
    private Button gerarBoletoButton;
    @FXML
    private TextField alunoText;
    @FXML
    private TextField curriculoText;
    @FXML
    private TextField turmaText;
    @FXML
    private TextField valorParcelaText;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                // pegar o objeto aqui e setar os campos
                Aluno aluno = null;
                aluno = (Aluno) userData;
                alunoText.setText(aluno.getNome());
                curriculoText.setText(aluno.getCurriculo().getNome());
                turmaText.setText(aluno.getTurma().getNomeTurma());
//                montar a lógica pra isso
//                valorParcelaText.setText(aluno.getCurriculo().getConfiguracao());
            }
        });
    }


    @FXML
    void gerarBoletoAction(ActionEvent event) {
        // configurar o pdf e salvar o valores nele

        Main.STAGE.close();
    }



}
