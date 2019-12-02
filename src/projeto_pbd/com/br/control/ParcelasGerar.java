package projeto_pbd.com.br.control;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projeto_pbd.Main;
import projeto_pbd.com.br.modell.Aluno;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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


    Aluno aluno = new Aluno();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
            @Override
            public void onScreenchanged(String newScene, Object userData) {
                // pegar o objeto aqui e setar os campos
                aluno = (Aluno) userData;
                alunoText.setText(aluno.getNome());
                curriculoText.setText(aluno.getCurriculo().getNome());
                turmaText.setText(aluno.getTurma().getNomeTurma());
//                montar a lógica pra isso
                valorParcelaText.setText(""+aluno.getCurriculo().getValorParcela());
            }
        });
    }


    @FXML
    void gerarBoletoAction() {
        // configurar o pdf e salvar o valores nele

        Document document = new Document();
        try {



            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/tainan/Área de Trabalho/"+aluno.getNome()+".pdf"));
            document.open();


            // adicionando um parágrafo ao documento
            document.add(new Paragraph("______________________________________________________________________________"));
            document.add(new Paragraph("\nALUNO:   "+ aluno.getNome()));
            document.add(new Paragraph("MATRÍCULA:   "+ aluno.getId()));
            document.add(new Paragraph("CURRÍCULO:   "+ aluno.getCurriculo().getNome()));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(0) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(1) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(2) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(3) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(4) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(5) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(6) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(7) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(8) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(9) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(10) + "         VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));
            document.add(new Paragraph("______________________________________________________________________________\n\n"));
            document.add(new Paragraph("                                          DATA VENCIMENTO:  "+ getDatas().get(11) + "          VALOR:   R$ "+ aluno.getCurriculo().getValorParcela()+",00" ));
            codBarras(writer,document);
            document.add(new Paragraph("______________________________________________________________________________\n"));

            document.addSubject("Gerando PDF em Java");
            document.addKeywords("www.devmedia.com.br");
            document.addCreator("iText");
            document.addAuthor("Davi Gomes da Costa");
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


    public static ArrayList<String> getDatas() {
        Calendar c = Calendar.getInstance();
        ArrayList<String> datas = new ArrayList<>();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < 12; i++) {
            mes += 1;
            String data = null;
            if ((dia + "").length() == 1) {
                data = "0" + dia + "/" + mes + "/" + ano;
                if ((mes + "").length() == 1) {
                    data = "0" + dia + "/" + "0" + mes + "/" + ano;
                }
            } else {
                data = +dia + "/" + mes + "/" + ano;
            }
            System.out.println(data);
            datas.add(data);
            if (mes == 12) {
                mes = 0;
                ano += 1;
            }
        }
        return datas;
    }

    public void codBarras(PdfWriter writer, Document document){
        PdfContentByte cb = writer.getDirectContent();
        BarcodeEAN codeEAN = new BarcodeEAN();
        codeEAN.setCodeType(codeEAN.EAN13);
        codeEAN.setCode("9780201615883");
        Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
        try {
            document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
