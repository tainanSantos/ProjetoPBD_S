package projeto_pbd.com.br.control;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import projeto_pbd.com.br.msg.Mensagem;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class CadastroAluno implements Initializable {


    @FXML
    private AnchorPane anchorpaneCadastroAluno;


    @FXML
    private ComboBox<?> comboboxUfAlun;
    private List listUfsAlun = new ArrayList (Arrays.asList (new String[]{"AC", "AL", "" +
            "AM", "AP", "BA", "CE", "DF","ES", "GO", "MA", "MG", "MS", "MT", "PA",
            "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC","SE", "SP", "TO"} ));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboboxUfAlun.setItems (FXCollections.observableArrayList (this.listUfsAlun));
    }


    public void cadastroAlunoTelaUmDois(){

    }


    public void salvar(){
        // GERAR BOLETO NO ATO DE SALVAMENTO

        Mensagem.mensagemConfirmacao ("Cadastro salvo com sucesso, um boleto com seus dados sera gerado agora!");
//        gerarPdf();
    }


//    public void gerarPdf(){
//        Document document = new Document();
//
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream("relatorioAluno.pdf"));
//            document.open ();
//
//            // criar um método para formatar PDF
//            formatarPdf();
//            document.add (new Paragraph ("informações relevantes aqui!!!"));
//            document.add (new Paragraph ("informações relevantes aqui!!!"));
//            document.add (new Paragraph ("informações relevantes aqui!!!"));
//            document.add (new Paragraph ("informações relevantes aqui!!!"));
//
//        } catch (DocumentException e) {
//            e.printStackTrace ( );
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            document.close ();
//        }
//
//        try {
//            Desktop.getDesktop ().open (new File ("relatorioAluno.pdf"));
//        } catch (IOException e) {
//            e.printStackTrace ( );
//        }
//    }


    public void formatarPdf(){
        // todas as formatações do pdf devem ser feitas aqui
        // questões de tabelas, exibição de conteúdo, etc.
    }


}
