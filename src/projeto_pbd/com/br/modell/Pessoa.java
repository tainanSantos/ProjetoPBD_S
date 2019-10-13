package projeto_pbd.com.br.modell;


import javax.persistence.*;


@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    private String nome;
    private String dataNascimento; // TALVEZ DE ERRO AQUI
    private String naturalidade;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;



    public Pessoa() {

    }


    public Pessoa(String nome, String dataNascimento, String naturalidade, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
//        this.endereco = endereco;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", naturalidade='" + naturalidade + '\'' +
//                ", endereco=" + endereco +
                '}';
    }
}
