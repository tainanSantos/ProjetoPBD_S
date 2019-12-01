package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Configuracao;
import projeto_pbd.com.br.msg.Mensagem;

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

        //  carregrar a configuração já predefinida para esssa página
        // sempfre que essa tela for invocada
        // essa configuração deve ser setada em todos os currículos
        // lá na tela de currículos
        // As regras de negócio da tela de cadastro notas devem ser alteradas de acordo com
        // o que será definido nessa tela
        // apenas uma entidade de configuração deve ser salva no banco de dados
        // essa entidade sera subescrita sempre que for atualizada e as regras de negocios mofificadas


        Configuracao configuracao = null;
        try {
            configuracao = Facade.getInstance().findAllConfiguracao().get(0);
        }catch (IndexOutOfBoundsException e){
            redefinirConfiguracaoCurriculoAction();
            configuracao = Facade.getInstance().findAllConfiguracao().get(0);
        }

        bimentralRadioButton.setSelected(configuracao.getCurriculoPorBimesntre());
        trimestralRadioButton.setSelected(configuracao.getCurriculoPorTrimestre());
        valorParcelaAnosIniciasiEFText.setText(configuracao.getValorParcelaAnosIniciaisEF()+"");
        valorParcelaAnosFinaisEFText.setText(configuracao.getValorParcelaAnosFinaisEF()+"");
        valorParcelaEnsinoMedioEMText.setText(configuracao.getValorParcelaAensinoMedioEM()+"");

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
    void salvarCurriculoAction() {
        Configuracao configuracao = new Configuracao();
        // dessa forma apenas um tipo de configuração será registrada no banco

        configuracao.setId(Facade.getInstance().findAllConfiguracao().get(0).getId());

        configuracao.setCurriculoPorBimesntre(bimentralRadioButton.isSelected());
        configuracao.setCurriculoPorTrimestre(trimestralRadioButton.isSelected());
        configuracao.setValorParcelaAnosIniciaisEF(Double.parseDouble(valorParcelaAnosIniciasiEFText.getText()));
        configuracao.setValorParcelaAnosFinaisEF(Double.parseDouble(valorParcelaAnosFinaisEFText.getText()));
        configuracao.setValorParcelaAensinoMedioEM(Double.parseDouble(valorParcelaEnsinoMedioEMText.getText()));
        Facade.getInstance().saveConfiguracao(configuracao);
        Mensagem.mensagemConfirmacao("Configuração Salvas Com Sucesso!");
    }

    @FXML
    void redefinirConfiguracaoCurriculoAction() {
        bimentralRadioButton.setSelected(true);
        trimestralRadioButton.setSelected(false);
        valorParcelaAnosIniciasiEFText.setText("400.0");
        valorParcelaAnosFinaisEFText.setText("600.0");
        valorParcelaEnsinoMedioEMText.setText("800.0");

        Configuracao configuracao = new Configuracao();
        // dessa forma apenas um tipo de configuração será registrada no banco
        String mensagem = "Configuração Redefinidas Com Sucesso!";
        try {
            configuracao.setId(Facade.getInstance().findAllConfiguracao().get(0).getId());
        }catch (IndexOutOfBoundsException e){
            mensagem = null;
        }
        configuracao.setCurriculoPorBimesntre(bimentralRadioButton.isSelected());
        configuracao.setCurriculoPorTrimestre(trimestralRadioButton.isSelected());
        configuracao.setValorParcelaAnosIniciaisEF(Double.parseDouble(valorParcelaAnosIniciasiEFText.getText()));
        configuracao.setValorParcelaAnosFinaisEF(Double.parseDouble(valorParcelaAnosFinaisEFText.getText()));
        configuracao.setValorParcelaAensinoMedioEM(Double.parseDouble(valorParcelaEnsinoMedioEMText.getText()));
        Facade.getInstance().saveConfiguracao(configuracao);
        if (mensagem!=null)
            Mensagem.mensagemConfirmacao(mensagem);

    }




}
