package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "generic_id")
public class Pedagogo extends Pessoa {

    private String graduacao;
    private String cpf;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "pedagogo",
            fetch = FetchType.EAGER
    )
    private List<Telefone> telefones;


    public Pedagogo() {
    }


    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
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
}
