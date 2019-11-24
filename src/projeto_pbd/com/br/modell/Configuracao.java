package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Configuracao {

    @Id
    @GeneratedValue
    private Integer id;

    private Boolean curriculoPorBimesntre;
    private Boolean curriculoPorTrimestre;

    private Double valorParcelaAnosIniciaisEF;
    private Double valorParcelaAnosFinaisEF;
    private Double valorParcelaAensinoMedioEM;

    public Configuracao() {
    }

    public Configuracao(Boolean curriculoPorBimesntre, Boolean curriculoPorTrimestre, Double valorParcelaAnosIniciaisEF,
                        Double valorParcelaAnosFinaisEF, Double valorParcelaAensinoMedioEM) {
        this.curriculoPorBimesntre = curriculoPorBimesntre;
        this.curriculoPorTrimestre = curriculoPorTrimestre;
        this.valorParcelaAnosIniciaisEF = valorParcelaAnosIniciaisEF;
        this.valorParcelaAnosFinaisEF = valorParcelaAnosFinaisEF;
        this.valorParcelaAensinoMedioEM = valorParcelaAensinoMedioEM;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCurriculoPorBimesntre() {
        return curriculoPorBimesntre;
    }

    public void setCurriculoPorBimesntre(Boolean curriculoPorBimesntre) {
        this.curriculoPorBimesntre = curriculoPorBimesntre;
    }

    public Boolean getCurriculoPorTrimestre() {
        return curriculoPorTrimestre;
    }

    public void setCurriculoPorTrimestre(Boolean curriculoPorTrimestre) {
        this.curriculoPorTrimestre = curriculoPorTrimestre;
    }

    public Double getValorParcelaAnosIniciaisEF() {
        return valorParcelaAnosIniciaisEF;
    }

    public void setValorParcelaAnosIniciaisEF(Double valorParcelaAnosIniciaisEF) {
        this.valorParcelaAnosIniciaisEF = valorParcelaAnosIniciaisEF;
    }

    public Double getValorParcelaAnosFinaisEF() {
        return valorParcelaAnosFinaisEF;
    }

    public void setValorParcelaAnosFinaisEF(Double valorParcelaAnosFinaisEF) {
        this.valorParcelaAnosFinaisEF = valorParcelaAnosFinaisEF;
    }

    public Double getValorParcelaAensinoMedioEM() {
        return valorParcelaAensinoMedioEM;
    }

    public void setValorParcelaAensinoMedioEM(Double valorParcelaAensinoMedioEM) {
        this.valorParcelaAensinoMedioEM = valorParcelaAensinoMedioEM;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "id=" + id +
                ", curriculoPorBimesntre=" + curriculoPorBimesntre +
                ", curriculoPorTrimestre=" + curriculoPorTrimestre +
                ", valorParcelaAnosIniciaisEF=" + valorParcelaAnosIniciaisEF +
                ", valorParcelaAnosFinaisEF=" + valorParcelaAnosFinaisEF +
                ", valorParcelaAensinoMedioEM=" + valorParcelaAensinoMedioEM +
                '}';
    }
}
