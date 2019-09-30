package projeto_pbd.com.br.teste;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEndereco;
    @Column
    private String nome;
    @Column
    private String logradourp;
    @Column
    private int numero;
    @Column
    private String cep;

    public Endereco(){

    }

    public Endereco(String nome, String logradourp, int numero, String cep) {
        this.nome = nome;
        this.logradourp = logradourp;
        this.numero = numero;
        this.cep = cep;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradourp() {
        return logradourp;
    }

    public void setLogradourp(String logradourp) {
        this.logradourp = logradourp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", nome='" + nome + '\'' +
                ", logradourp='" + logradourp + '\'' +
                ", numero=" + numero +
                ", cep='" + cep + '\'' +
                '}';
    }
}
