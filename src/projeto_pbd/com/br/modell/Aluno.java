package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends  Pessoa{

    // CPF obrigatorio se o aluno for responsável financeiro

    @ManyToOne
    private Curriculo curriculo;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Responsavel responsavel;

    public Aluno() {
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
