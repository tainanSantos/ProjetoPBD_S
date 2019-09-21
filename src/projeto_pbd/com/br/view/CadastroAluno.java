package projeto_pbd.com.br.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroAluno implements Initializable {



    @FXML
    private AnchorPane anchorpaneCadastroAluno;
    @FXML
    private AnchorPane anchorpaneCadastroAlunoDependente;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void cadastroAlunoTelaUmDois(){
        this.anchorpaneCadastroAluno.setVisible(false);
        this.anchorpaneCadastroAlunoDependente.setVisible(true);
    }


    public void cadastroAlunoTelaDoisUm(){
        this.anchorpaneCadastroAluno.setVisible(true);
        this.anchorpaneCadastroAlunoDependente.setVisible(false);
    }


    public void salvar(){
        // GERAR BOLETO NO ATO DE SALVAMENTO
        System.out.println("Salvo com sucesso!");
        gerarPdf();

    }

    public void gerarPdf(){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("relatorioAluno.pdf"));
            document.open ();

            // criar um método para formatar PDF
            formatarPdf();
            document.add (new Paragraph ("informações relevantes aqui!!!"));
            document.add (new Paragraph ("informações relevantes aqui!!!"));
            document.add (new Paragraph ("informações relevantes aqui!!!"));
            document.add (new Paragraph ("informações relevantes aqui!!!"));

        } catch (DocumentException e) {
            e.printStackTrace ( );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            document.close ();
        }

        try {
            Desktop.getDesktop ().open (new File ("relatorioAluno.pdf"));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }


    public void formatarPdf(){
        // todas as formatações do pdf devem ser feitas aqui
        // questões de tabelas, exibição de conteúdo, etc.
    }
}
