package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.Date;

public class AcompanhamentoPedagogico {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Pedagogo pedagogo;

    @Temporal (TemporalType.DATE)
    private Date dataAtendimento;

    @Column
    private String secaoDetalhamento;

    @Column
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
