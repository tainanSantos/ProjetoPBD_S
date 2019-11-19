package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<Professor> professors;

    private String nomeTurma;

    public Turma(){
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
