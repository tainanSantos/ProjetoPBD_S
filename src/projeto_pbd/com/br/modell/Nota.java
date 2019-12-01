package projeto_pbd.com.br.modell;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.persistence.*;
import java.io.FileOutputStream;
import java.io.IOException;

@Entity
public class Nota {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;
    private String resultado;

    private Double primeiraVa;
    private Double segundaVa;
    private Double terceiraVa;
    private Double quartaVa;
    private Double finalVa;
    private Double media;

    // se aprovado ou reprovado na disciplina
    private Boolean status;


    public Nota() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Double getPrimeiraVa() {
        return primeiraVa;
    }

    public void setPrimeiraVa(Double primeiraVa) {
        this.primeiraVa = primeiraVa;
    }

    public Double getSegundaVa() {
        return segundaVa;
    }

    public void setSegundaVa(Double segundaVa) {
        this.segundaVa = segundaVa;
    }

    public Double getTerceiraVa() {
        return terceiraVa;
    }

    public void setTerceiraVa(Double terceiraVa) {
        this.terceiraVa = terceiraVa;
    }

    public Double getQuartaVa() {
        return quartaVa;
    }

    public void setQuartaVa(Double quartaVa) {
        this.quartaVa = quartaVa;
    }

    public Double getFinalVa() {
        return finalVa;
    }

    public void setFinalVa(Double finalVa) {
        this.finalVa = finalVa;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Nota{" +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                ", primeiraVa=" + primeiraVa +
                ", segundaVa=" + segundaVa +
                ", terceiraVa=" + terceiraVa +
                ", quartaVa=" + quartaVa +
                ", finalVa=" + finalVa +
                ", resultado='" + resultado + '\'' +
                ", media=" + media +
                ", status=" + status +
                '}';
    }


//    public static void main(String[] args) {
//
//        Document document = new Document();
//        try {
//
//            PdfWriter.getInstance(document,
//                    new FileOutputStream("/home/tainan/PDF_DevMedia.pdf"));
//            document.open();
//
//            // adicionando um parágrafo ao documento
//            document.add(new Paragraph("Gerando PDF em Java - metadados"));
//            document.addSubject("Gerando PDF em Java");
//            document.addKeywords("www.devmedia.com.br");
//            document.addCreator("iText");
//            document.addAuthor("Davi Gomes da Costa");
//        }
//        catch(DocumentException de) {
//            System.err.println(de.getMessage());
//        }
//        catch(IOException ioe) {
//            System.err.println(ioe.getMessage());
//        }
//        document.close();
//    }
}
