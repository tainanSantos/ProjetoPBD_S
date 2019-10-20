package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "generic_id")
public class Professor extends Pessoa  {


    private String graduacao;
    private String cpf;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "professor",
            fetch = FetchType.EAGER
    )
    private List<Telefone> telefones;


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "professor",
            fetch = FetchType.EAGER
    )

    private List<Disciplina> disciplinas;


    public Professor() {
    }


    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }


}
