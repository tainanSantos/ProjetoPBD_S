package projeto_pbd.com.br.modell;


import javax.persistence.*;

@Entity
public class AcompanhamentoPedagogico {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Aluno aluno;


    private Integer pessoa_id;

    private String dataAcompanhamento;

    private String secaoDetalhamento;

    private Boolean concluida;

    public AcompanhamentoPedagogico() {

    }

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDataAcompanhamento() {
        return dataAcompanhamento;
    }

    public void setDataAcompanhamento(String dataAcompanhamento) {
        this.dataAcompanhamento = dataAcompanhamento;
    }

    public String getSecaoDetalhamento() {
        return secaoDetalhamento;
    }

    public void setSecaoDetalhamento(String secaoDetalhamento) {
        this.secaoDetalhamento = secaoDetalhamento;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return "AcompanhamentoPedagogico{" +
                "aluno=" + aluno +
                ", dataAcompanhamento='" + dataAcompanhamento + '\'' +
                ", secaoDetalhamento='" + secaoDetalhamento + '\'' +
                ", concluida=" + concluida +
                '}';
    }
}
