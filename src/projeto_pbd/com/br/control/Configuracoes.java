package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Configuracao;

import java.net.URL;
import java.util.ResourceBundle;

public class Configuracoes implements Initializable {

    // carregar a configuração predefinida sempre que entrar nessa tela

    @FXML
    private RadioButton bimentralRadioButton;
    @FXML
    private ToggleGroup formaCadCurriculos;
    @FXML
    private RadioButton trimestralRadioButton;
    @FXML
    private Button salvarCurriculoButton;
    @FXML
    private Button redefinirConfiguracaoCurriculoButton;
    @FXML
    private TextField valorParcelaAnosIniciasiEFText;
    @FXML
    private TextField valorParcelaAnosFinaisEFText;
    @FXML
    private TextField valorParcelaEnsinoMedioEMText;


    //__________________________________________________________________________________________________________________


    private void restricoesAcesso(){
        salvarCurriculoButton.setDisable(true);
        redefinirConfiguracaoCurriculoButton.setDisable(true);
        bimentralRadioButton.setDisable(true);
        trimestralRadioButton.setDisable(true);
        valorParcelaAnosFinaisEFText.setDisable(true);
        valorParcelaAnosIniciasiEFText.setDisable(true);
        valorParcelaEnsinoMedioEMText.setDisable(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    break;
                case ("Direção"):
                    restricoesAcesso();
                    break;
                case ("Coordenação Pedagogica"):
                    restricoesAcesso();
                    break;
                case ("Secretaria"):
                    restricoesAcesso();
                    break;
            }
        }
    }

    //__________________________________________________________________________________________________________________

    @FXML
    void salvarCurriculoAction(ActionEvent event) {
        Configuracao configuracao = new Configuracao();
        configuracao.setCurriculoPorBimesntre(bimentralRadioButton.isSelected());
        configuracao.setCurriculoPorTrimestre(trimestralRadioButton.isSelected());
        configuracao.setValorParcelaAnosIniciaisEF(Double.parseDouble(valorParcelaAnosIniciasiEFText.getText()));
        configuracao.setValorParcelaAnosFinaisEF(Double.parseDouble(valorParcelaAnosFinaisEFText.getText()));
        configuracao.setValorParcelaAensinoMedioEM(Double.parseDouble(valorParcelaEnsinoMedioEMText.getText()));
        Facade.getInstance().saveConfiguracao(configuracao);
    }

    @FXML
    void redefinirConfiguracaoCurriculoAction(ActionEvent event) {

    }




}
