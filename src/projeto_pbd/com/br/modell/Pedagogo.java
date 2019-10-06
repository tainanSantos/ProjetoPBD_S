package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedagogo extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

}
