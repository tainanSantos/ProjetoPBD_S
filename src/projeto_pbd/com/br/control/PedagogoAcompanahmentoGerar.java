package projeto_pbd.com.br.control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.AcompanhamentoPedagogico;
import projeto_pbd.com.br.modell.UsuarioLogado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PedagogoAcompanahmentoGerar implements Initializable {


    @FXML
    private Button gerarPdfButton;
    @FXML
    private TextField usuarioPedText;
    @FXML
    private TextField usuarioTipoAcessoText;
    @FXML
    private TextField emailUserText;

    UsuarioLogado usuarioLogado = new UsuarioLogado();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarioLogado = Facade.getInstance().findAllUsuarioLogado();
        usuarioPedText.setText(usuarioLogado.getNome());
        usuarioTipoAcessoText.setText(usuarioLogado.getTipodeacesso());
        emailUserText.setText(usuarioLogado.getEmail());
    }


    // pegar a data no foemato String direto so Sistema
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    @FXML
    public void gerarPdfAction(){
        // gerar Relatório aqui!
        UsuarioLogado usuarioLogado = null;
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicos = null;
        usuarioLogado = Facade.getInstance().findAllUsuarioLogado();
        acompanhamentoPedagogicos = Facade.getInstance().findByIdUsuarioPedagogoAcompanhamentoPedagogico(
                usuarioLogado.getPessoa_id());
        System.out.println(acompanhamentoPedagogicos);


        Document document = new Document();
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/tainan/Área de Trabalho/"+"Acompanhamento_"+"pedagogo"+usuarioLogado.getNome()+".pdf"));
            document.open();

            document.add(new Paragraph("______________________________________________________________________________"));
            document.add(new Paragraph("\nPEDAGOGO (A):   "+ usuarioLogado.getNome()));
            document.add(new Paragraph("E-MAIL PEDAGOGO (A):   "+ usuarioLogado.getEmail()));
            document.add(new Paragraph("CPF PEDAGOGO (A):   "+ usuarioLogado.getCpf()));

            document.add(new Paragraph("______________________________________________________________________________\n\n"));

            int i = 0;
            while(i < acompanhamentoPedagogicos.size()){
                document.add(new Paragraph("\n\n______________________________________________________________________________"));
                document.add(new Paragraph("ALUNO (A):  "+ acompanhamentoPedagogicos.get(i).getAluno().getNome()));
                document.add(new Paragraph("DATA DO ACOMPANHAMENTO:  "+ acompanhamentoPedagogicos.get(i).getDataAcompanhamento()));
                document.add(new Paragraph("DETALHAMENTO DA SESSÃO DO ACOMPANHAMENTO:  \n"+ acompanhamentoPedagogicos.get(i).getSecaoDetalhamento()));
                document.add(new Paragraph("DETALHAMENTO SESSÂO CONCLUÍDA:  "+ acompanhamentoPedagogicos.get(i).getConcluida()));
                i+=1;
            }

            document.addSubject("Gerando PDF em Java");
            document.addKeywords("www.devmedia.com.br");
            document.addCreator("iText");
            document.addAuthor("Tainan Santos Silva");
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
        Main.STAGE.close();
    }

}
