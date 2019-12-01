package projeto_pbd.com.br.modell;

import javax.persistence.*;

@Entity
public class Parcela {

    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne
    private Curriculo curriculo;

    private Boolean status;

    private Double valorParcela;

    public Parcela(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }


    @Override
    public String toString() {
        return "Parcela{" +
                ", curriculo=" + curriculo +
                ", status=" + status +
                ", valorParcela=" + valorParcela +
                '}';
    }
}
