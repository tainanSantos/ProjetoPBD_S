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
    private String nome;
    private String dataNascomento;
    private String naturalidade;
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

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascomento() {
        return dataNascomento;
    }

    public void setDataNascomento(String dataNascomento) {
        this.dataNascomento = dataNascomento;
    }

    @Override
    public String getNaturalidade() {
        return naturalidade;
    }

    @Override
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
