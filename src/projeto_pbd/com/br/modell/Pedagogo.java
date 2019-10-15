package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "pedagogo_seq", sequenceName = "pedagogo_seq",
        initialValue = 1, allocationSize = 1)
public class Pedagogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedagogo_seq")
    private int id;
    private String nome;
    private String dataNascomento;
    private String naturalidade;
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedagogo")
    private List<Telefone> telefones;


    public Pedagogo() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascomento() {
        return dataNascomento;
    }

    public void setDataNascomento(String dataNascomento) {
        this.dataNascomento = dataNascomento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
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
