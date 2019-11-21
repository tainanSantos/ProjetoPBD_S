package projeto_pbd.com.br.modell;

// será uma view para gerencias as  infoemações do aluno

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Immutable
public class NotasAlunoVw {

    // criar a no sql no banco

    @Id
    @GeneratedValue
    private Integer id;

    public NotasAlunoVw() {


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
