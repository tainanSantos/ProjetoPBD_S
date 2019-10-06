package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Nota nota;


}
