package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.msg.Mensagem;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroTipoCurriculo implements Initializable {


    @FXML
    private TextField nomeCurriculoText;
    @FXML
    private TableView<Curriculo> curriculosTable;
    @FXML
    private TableColumn<?, ?> curriculosColumn;

    @FXML
    private Button salvarCurriculoButton;
    @FXML
    private Button novoCurriculoButton;
    @FXML
    private Button apagarTipoCurriculoButton;


    private void restricoesAcesso(){
        salvarCurriculoButton.setDisable(true);
        novoCurriculoButton.setDisable(true);
        apagarTipoCurriculoButton.setDisable(true);
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
                    break;
            }
        }

        carregarCurriculoTable(Facade.getInstance().findAllCurriculo());
        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {

            }
        });
    }



    public void carregarCurriculoTable(List<Curriculo> curriculoList){
        curriculosColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        curriculosTable.getItems().setAll(curriculoList);
    }



    @FXML
    void salvarCurriculoButton(ActionEvent event) {
        Curriculo curriculo = new Curriculo();
        String mensagem = "Curriculo Salvo Com Sucesso!";
        if(curriculosTable.getSelectionModel().getSelectedItem()!=null) {
            curriculo = (curriculosTable.getSelectionModel().getSelectedItem());
            mensagem = "Curriculo Atualizado Com Sucesso!";


            if (curriculo.getNome().equalsIgnoreCase("1 - EF - ANOS INICIAL") ||
                curriculo.getNome().equalsIgnoreCase("2 a 5 - EF - ANOS INICIAL")){
                curriculo.setValorParcela(Facade.getInstance().findAllConfiguracao().get(0).getValorParcelaAnosIniciaisEF());
            }
            if (curriculo.getNome().equalsIgnoreCase("6 a 8 - EF - ANOS FINAIS") ||
                curriculo.getNome().equalsIgnoreCase("9 - EF - ANOS FINAIS")){
                curriculo.setValorParcela(Facade.getInstance().findAllConfiguracao().get(0).getValorParcelaAnosFinaisEF());
            }else
                curriculo.setValorParcela(Facade.getInstance().findAllConfiguracao().get(0).getValorParcelaAensinoMedioEM());
        }


        try {
            curriculo.setConfiguracao(Facade.getInstance().findAllConfiguracao().get(0));
        }catch (IndexOutOfBoundsException e){
            Mensagem.mensagemErro("Redefina a configuração do currículo , antes add um novo currículo");
            return; // para ele sair do método sem executar mais nada
        }

        curriculo.setStatus(true);
        curriculo.setNome(nomeCurriculoText.getText());
        Facade.getInstance().saveCurriculo(curriculo);
        Mensagem.mensagemSucesso(mensagem);
        novoCurriculo(event);
        carregarCurriculoTable(Facade.getInstance().findAllCurriculo());
    }



    @FXML
    void novoCurriculo(ActionEvent event) {
        curriculosTable.getSelectionModel().select(null);
        nomeCurriculoText.clear();
    }



    @FXML
    void apagarTipoCurriculoAction(ActionEvent event) {
        if(Mensagem.mensagmeConfirmar("Apagar Currículo","Desenha ralamente apagar este Currículo? ")==1) {
            Facade.getInstance().removeCurriculo(curriculosTable.getSelectionModel().getSelectedItem().getId());
            carregarCurriculoTable(Facade.getInstance().findAllCurriculo());
        }
    }



    @FXML
    void tableEvet(MouseEvent event) {
        if (event.getClickCount() >= 1){
            if (curriculosTable.getSelectionModel().getSelectedItem()!=null){
                nomeCurriculoText.setText(curriculosTable.getSelectionModel().getSelectedItem().getNome());

            }
        }
    }



}
