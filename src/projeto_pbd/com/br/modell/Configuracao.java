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


/*
        create table update_Configuracao(
            curriculoporbimesntre boolean,
            curriculoportrimestre boolean,
            valorparcelaaensinomedioem real,
            valorparcelaanosfinaisef real,
            valorparcelaanosiniciaisef real,
            data_hora_modificacao varchar(30)
        )


        create or replace function save_update_in_config()
        returns trigger as
        $$
            begin
                insert into update_Configuracao(curriculoporbimesntre, curriculoportrimestre,
                    valorparcelaaensinomedioem, valorparcelaanosfinaisef, valorparcelaanosiniciaisef,
                    data_hora_modificacao )
                values(new.curriculoporbimesntre, new.curriculoportrimestre,
                    new.valorparcelaaensinomedioem, new.valorparcelaanosfinaisef, new.valorparcelaanosiniciaisef,
                    current_timestamp );
            end;
        $$ language 'plpgsql';



        create trigger fazer_beckap after update on configuracao
        for each row execute procedure save_update_in_config();
*/