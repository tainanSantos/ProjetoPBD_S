package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Professor extends Pessoa  {


    private String graduacao;
    private String cpf;

    // CAMPO PARA SELECIONAR MARCAR ONJETOS NA TABELA
    private Boolean selectTable;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "professor_turma",
            joinColumns = @JoinColumn(name = "professor_pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "turmalist_id"))
    private List<Turma> turmaList = new ArrayList<>();

    public Professor() {


    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    public Boolean getSelectTable() {
        return selectTable;
    }

    public void setSelectTable(Boolean selectTable) {
        this.selectTable = selectTable;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "graduacao='" + graduacao + '\'' +
                ", cpf='" + cpf + '\'' +
                ", selectTable=" + selectTable +
                ", turmaList=" + turmaList +
                '}';
    }
}
