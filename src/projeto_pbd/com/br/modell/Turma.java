package projeto_pbd.com.br.modell;

import javafx.scene.control.DatePicker;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue
    private Integer id;


    @ManyToMany
    private List<Professor> professors;

    private String nomeTurma;


    private LocalDate dataAnoLetivo; // aqui pode ser substituido por uma string, se for mais conveniente

    private int qtdAlunos;

    public Turma(){
    }

    public LocalDate getDataAnoLetivo() {
        return dataAnoLetivo;
    }

    public void setDataAnoLetivo(LocalDate dataAnoLetivo) {
        this.dataAnoLetivo = dataAnoLetivo;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private LocalDate anoLetivo;

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }


    public LocalDate getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(LocalDate anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    @Override
    public String toString() {
        return ""+ nomeTurma ;
    }
}
