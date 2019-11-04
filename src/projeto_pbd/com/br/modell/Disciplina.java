package projeto_pbd.com.br.modell;

import javax.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private Integer id; // vai ser o código
    private String nome;
    private double cargaHoaria;

    @ManyToOne
    private Turma turma;

    @ManyToOne
    private Curriculo curriculo;

    private Boolean status;

    public Disciplina(){

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCargaHoaria() {
        return cargaHoaria;
    }

    public void setCargaHoaria(double cargaHoaria) {
        this.cargaHoaria = cargaHoaria;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }
}
