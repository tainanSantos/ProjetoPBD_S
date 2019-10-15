package projeto_pbd.com.br.modell;


import javax.persistence.*;


@MappedSuperclass
public abstract class Pessoa {


    private String nome;
    private String dataNascimento; // TALVEZ DE ERRO AQUI
    private String naturalidade;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;


    public Pessoa() {

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
