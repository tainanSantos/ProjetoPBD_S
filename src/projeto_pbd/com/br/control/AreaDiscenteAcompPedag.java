package projeto_pbd.com.br.control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import projeto_pbd.Main;
import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.AcompanhamentoPedagogico;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.msg.Mensagem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class AreaDiscenteAcompPedag implements Initializable {



    @FXML
    private TextField pedagogoLogadoText;
    @FXML
    private TextField alunoAcompanhamentoText;
    @FXML
    private TextArea detalalhamentoAcompamanhamentoText;
    @FXML
    private CheckBox acompanhamentoConcluidoBoolean;
    @FXML
    private Button salvarAcompanhamentoButton;
    @FXML
    private TableView<AcompanhamentoPedagogico> acompanamentoPedagocicoTable;
    @FXML
    private TableColumn<?, ?> consuídaColum;
    @FXML
    private TableColumn<?, ?> detalhamentoColum;
    @FXML
    private TableColumn<?, ?> dataColum;
    @FXML
    private Button gerarPdfButton;

    Aluno aluno = new Aluno();

    private void restricoaAcesso(){
        salvarAcompanhamentoButton.setDisable(true);
    }

    //__________________________________________________________________________________________________________________


    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        if (Main.getUsuarioLogado().getTipodeacesso().equalsIgnoreCase("Coordenação Pedagogica")) {
//            pedagogoLogadoText.setText(Main.getUsuarioLogado().getEmail());
//        }else pedagogoLogadoText.clear();

        if (Main.getTipoUsuario()!=null) {
            switch (Main.getTipoUsuario()) {
                case ("Adiminstração"):
                    break;
                case ("Direção"):
                    restricoaAcesso();
                    break;
                case ("Coordenação Pedagogica"):
                    break;
                case ("Secretaria"):
                    restricoaAcesso();
                    break;
            }
        }

        Main.addOnChangeScreenListener(new Main.OnchangeSceneen() {
           @Override
           public void onScreenchanged(String newScene, Object userData) {
               aluno = (Aluno) userData;
               alunoAcompanhamentoText.setText(aluno.getNome());
               pedagogoLogadoText.setText(Facade.getInstance().findAllUsuarioLogado().getNome());
               pedagogoLogadoText.setText(Facade.getInstance().findAllUsuarioLogado().getNome());
               // setar o pedagoggo que tpá logado no sistema também
               carregarTabela(Facade.getInstance().findByIdAlunoAcompanhamentoPedagogico(aluno.getId()));
           }
       });

        acompanamentoPedagocicoTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() >= 2){
                    // só pra definir os pontos levantados no acompanhamento
                    detalalhamentoAcompamanhamentoText.setText(
                            acompanamentoPedagocicoTable.getSelectionModel().getSelectedItem().getSecaoDetalhamento());
                }
            }
        });

    }



    public void carregarTabela(List<AcompanhamentoPedagogico> acompanhamentoPedagogicos){
        dataColum.setCellValueFactory(new PropertyValueFactory<>("dataAcompanhamento"));
        consuídaColum.setCellValueFactory(new PropertyValueFactory<>("concluida"));
        detalhamentoColum.setCellValueFactory(new PropertyValueFactory<>("secaoDetalhamento"));
        acompanamentoPedagocicoTable.getItems().setAll(acompanhamentoPedagogicos);

    }



    //__________________________________________________________________________________________________________________



    @FXML
    void action(ActionEvent event) {
        if (event.getSource() == salvarAcompanhamentoButton){
            AcompanhamentoPedagogico acompanhamentoPedagogico = new AcompanhamentoPedagogico();
            acompanhamentoPedagogico.setAluno(aluno);
            acompanhamentoPedagogico.setSecaoDetalhamento(detalalhamentoAcompamanhamentoText.getText());
            acompanhamentoPedagogico.setDataAcompanhamento(getDateTime()); // pegar data e Hora
            acompanhamentoPedagogico.setConcluida(acompanhamentoConcluidoBoolean.isSelected());
            acompanhamentoPedagogico.setPessoa_id(Facade.getInstance().findAllUsuarioLogado().getPessoa_id());
            Facade.getInstance().saveAcompanhamentoPedagogico(acompanhamentoPedagogico);
            Mensagem.mensagemSucesso("Salvo com sucesso");
            carregarTabela(Facade.getInstance().findByIdAlunoAcompanhamentoPedagogico(aluno.getId()));
        }

        if (acompanhamentoConcluidoBoolean.isSelected()){
            //fechar secao
        }
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
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicos = new ArrayList<>();
        acompanhamentoPedagogicos = Facade.getInstance().findByIdAlunoAcompanhamentoPedagogico(aluno.getId());
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/tainan/Área de Trabalho/"+"Acompanhamento_"+aluno.getNome()+".pdf"));
            document.open();

            document.add(new Paragraph("______________________________________________________________________________"));
            document.add(new Paragraph("ALUNO (A):   "+ aluno.getNome()));
            document.add(new Paragraph("Nª MATRÍCULA:   "+ aluno.getId()));
            document.add(new Paragraph("CURRÍCULO:   "+ aluno.getCurriculo().getNome()));
            document.add(new Paragraph("DIA DE EMIÇÃO:   "+ getDateTime()));
            document.add(new Paragraph("\nPEDAGOGO:   "+ Facade.getInstance().findAllUsuarioLogado().getNome()));
            document.add(new Paragraph("E-MAIL PEDAGOGO:   "+ Facade.getInstance().findAllUsuarioLogado().getEmail()));

            document.add(new Paragraph("______________________________________________________________________________\n\n"));

            int i = 0;
            while(i < acompanhamentoPedagogicos.size()){
                document.add(new Paragraph("\n\n______________________________________________________________________________"));
                document.add(new Paragraph("DATA DO ACOMPANHAMENTO:  "+ acompanhamentoPedagogicos.get(i).getDataAcompanhamento()));
                document.add(new Paragraph("DETALHAMENTO DA SESSÃO DO ACOMPANHAMENTO:  \n"+ acompanhamentoPedagogicos.get(i).getSecaoDetalhamento()));
                document.add(new Paragraph("DETALHAMENTO SESÂO CONCLUÍDA:  "+ acompanhamentoPedagogicos.get(i).getConcluida()));
                i+=1;
            }

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





}