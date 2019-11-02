package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Professor extends Pessoa  {

    private String graduacao;
    private String cpf;

    @ManyToMany
    private List<Turma> turmaList;

    public Professor() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }
}
