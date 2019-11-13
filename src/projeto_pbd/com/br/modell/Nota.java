package projeto_pbd.com.br.modell;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;

    private float primeiraVa;
    private float segundaVa;
    private float terceiraVa;
    private float quartaVa;
    private float finalVa;

    private float media;

    // se aprovado ou reprovado na disciplina
    private Boolean status;


    public Nota() {
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
