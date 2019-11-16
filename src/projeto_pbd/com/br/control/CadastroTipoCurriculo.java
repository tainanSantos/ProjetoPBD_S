package projeto_pbd.com.br.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
            curriculo.setId(curriculosTable.getSelectionModel().getSelectedItem().getId());
            mensagem = "Curriculo Atualizado Com Sucesso!";
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
    void tableEvet(MouseEvent event) {
        if (event.getClickCount() >= 1){
            if (curriculosTable.getSelectionModel().getSelectedItem()!=null){
                nomeCurriculoText.setText(curriculosTable.getSelectionModel().getSelectedItem().getNome());
            }
        }
    }



}
