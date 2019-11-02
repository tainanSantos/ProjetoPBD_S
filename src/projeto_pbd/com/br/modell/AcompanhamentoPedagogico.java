package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.Date;

@Entity
public class AcompanhamentoPedagogico {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Pedagogo pedagogo;

    @ManyToOne
    private Aluno aluno;

    @Temporal (TemporalType.DATE)
    private Date dataAtendimento;

    private String secaoDetalhamento;

    private boolean concluida;


    public AcompanhamentoPedagogico() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedagogo getPedagogo() {
        return pedagogo;
    }

    public void setPedagogo(Pedagogo pedagogo) {
        this.pedagogo = pedagogo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getSecaoDetalhamento() {
        return secaoDetalhamento;
    }

    public void setSecaoDetalhamento(String secaoDetalhamento) {
        this.secaoDetalhamento = secaoDetalhamento;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
