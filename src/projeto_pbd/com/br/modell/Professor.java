package projeto_pbd.com.br.modell;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Professor extends Pessoa {


    private int id;
    private String cpf;
    private String rg;
    private String orgaoEspedito;
    private String numMatricula;
    private String emailAcad;
    private String areaFormacao;

}
