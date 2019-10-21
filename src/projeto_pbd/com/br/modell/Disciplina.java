package projeto_pbd.com.br.modell;

import javax.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private Integer id;
    private String codigo;
    private String nome;
    private double cargaHoaria;

    @ManyToOne
    private Professor professor;

    private String statusAluno;

    public Disciplina(){

    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(String statusAluno) {
        this.statusAluno = statusAluno;
    }
}
