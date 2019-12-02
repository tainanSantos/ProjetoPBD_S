package projeto_pbd.com.br.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.AuditoriaUsuarios;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Auditoria implements Initializable {

    @FXML
    private TableView<AuditoriaUsuarios> auditoriaTable;

    @FXML
    private TableColumn<?, ?> usuarioColumn;
    @FXML
    private TableColumn<?, ?> dataauditoriaColum;
    @FXML
    private TableColumn<?, ?> cpfuserColumn;

    @FXML
    private TableColumn<?, ?> emailUserColumn;

    @FXML
    private TableColumn<?, ?> pessoaColumn;

    @FXML
    private TableColumn<?, ?> cpfPessoaColumn;

    @FXML
    private TableColumn<?, ?> emailPessoaColumn;

    @FXML
    private TextField pesquisaText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        carregarTabela(Facade.getInstance().findAllAuditoriasUser());

    }

    public void carregarTabela(List<AuditoriaUsuarios> auditoriaUsuarios){

        usuarioColumn.setCellValueFactory(new PropertyValueFactory<>("nomeUser"));
        cpfuserColumn.setCellValueFactory(new PropertyValueFactory<>("cpfUser"));
        emailUserColumn.setCellValueFactory(new PropertyValueFactory<>("emailUser"));

        pessoaColumn.setCellValueFactory(new PropertyValueFactory<>("tipodeacessoUserModificado"));
        emailPessoaColumn.setCellValueFactory(new PropertyValueFactory<>("emailUserModificado"));
        cpfPessoaColumn.setCellValueFactory(new PropertyValueFactory<>("cpfUserModificado"));
        dataauditoriaColum.setCellValueFactory(new PropertyValueFactory<>("datamodificacao"));
        auditoriaTable.getItems().setAll(auditoriaUsuarios);
    }
}
