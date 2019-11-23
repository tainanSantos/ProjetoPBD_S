package projeto_pbd.com.br.modell;


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

    private Integer primeiraVa;
    private Integer segundaVa;
    private Integer terceiraVa;
    private Integer quartaVa;
    private Integer finalVa;
    private String resultado;
    private Integer media;

    // se aprovado ou reprovado na disciplina
    private Boolean status;


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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getPrimeiraVa() {
        return primeiraVa;
    }

    public void setPrimeiraVa(Integer primeiraVa) {
        this.primeiraVa = primeiraVa;
    }

    public Integer getSegundaVa() {
        return segundaVa;
    }

    public void setSegundaVa(Integer segundaVa) {
        this.segundaVa = segundaVa;
    }

    public Integer getTerceiraVa() {
        return terceiraVa;
    }

    public void setTerceiraVa(Integer terceiraVa) {
        this.terceiraVa = terceiraVa;
    }

    public Integer getQuartaVa() {
        return quartaVa;
    }

    public void setQuartaVa(Integer quartaVa) {
        this.quartaVa = quartaVa;
    }

    public Integer getFinalVa() {
        return finalVa;
    }

    public void setFinalVa(Integer finalVa) {
        this.finalVa = finalVa;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Nota{" +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                ", primeiraVa=" + primeiraVa +
                ", segundaVa=" + segundaVa +
                ", terceiraVa=" + terceiraVa +
                ", quartaVa=" + quartaVa +
                ", finalVa=" + finalVa +
                ", resultado='" + resultado + '\'' +
                ", media=" + media +
                ", status=" + status +
                '}';
    }
}
