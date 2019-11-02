package projeto_pbd.com.br.modell;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Aluno aluno;

    private float primeiraVa;
    private float segundaVa;
    private float terceiraVa;
    private float quartaVa;
    private float finalVa;

    private float media;

    // se aprovado ou reprovado na disciplina
    private boolean status;


    public Nota() {
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

    public float getPrimeiraVa() {
        return primeiraVa;
    }

    public void setPrimeiraVa(float primeiraVa) {
        this.primeiraVa = primeiraVa;
    }

    public float getSegundaVa() {
        return segundaVa;
    }

    public void setSegundaVa(float segundaVa) {
        this.segundaVa = segundaVa;
    }

    public float getTerceiraVa() {
        return terceiraVa;
    }

    public void setTerceiraVa(float terceiraVa) {
        this.terceiraVa = terceiraVa;
    }

    public float getQuartaVa() {
        return quartaVa;
    }

    public void setQuartaVa(float quartaVa) {
        this.quartaVa = quartaVa;
    }

    public float getFinalVa() {
        return finalVa;
    }

    public void setFinalVa(float finalVa) {
        this.finalVa = finalVa;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
