package projeto_pbd.com.br.view;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CadastroCurriculo {

    @FXML
    private GridPane paneCadastroCurriculoUm;
    @FXML
    private AnchorPane paneCadastroCurriculoDois;
    @FXML
    private AnchorPane paneCadastroCurriculoTres;

    public void proximo(){

        // FAZER VALIDAÇÃO DOS COMAPOS ANTES

        trocarTelas(2);
    }

    public void anterior(){
        trocarTelas(1);
    }


    public void proximoDois(){
        trocarTelas(3);
    }


    public void anteriorDois(){
        trocarTelas(2);
    }


    public void salvarCurriculo(){

    }


    public void trocarTelas(int valor){
        this.paneCadastroCurriculoUm.setVisible(false);
        this.paneCadastroCurriculoDois.setVisible(false);
        this.paneCadastroCurriculoTres.setVisible(false);
        switch (valor) {
            case 1:
                this.paneCadastroCurriculoUm.setVisible(true);
                break;
            case 2:
                this.paneCadastroCurriculoDois.setVisible(true);
                break;
            case 3:
                this.paneCadastroCurriculoTres.setVisible(true);
                break;
        }
    }
}
