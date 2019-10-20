package projeto_pbd.com.br.modell;


import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(generator = "generic_id")
    private Integer id;
    
    private String nome;

    @Temporal (TemporalType.DATE)
    private Date dataNascimento; // TALVEZ DE ERRO AQUI

    private String naturalidade;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Endereco endereco;


    public Pessoa() {

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
