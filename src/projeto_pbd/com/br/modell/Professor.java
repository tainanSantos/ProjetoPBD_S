package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "professor_seq", sequenceName = "professor_seq",
        initialValue = 1, allocationSize = 1)
public class Professor extends Pessoa  {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_seq")
    private int id;
    private String graduacao;
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Telefone> telefones;


    public Professor() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
