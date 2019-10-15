package projeto_pbd.com.br.teste;


import javax.persistence.*;
import java.util.List;

//@Entity
//@SequenceGenerator (name = "pessoateste_seq", sequenceName = "pessoateste_seq",
//        initialValue = 1, allocationSize = 1)
public class PessoaTeste {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoateste_seq")
    private int id;

    private String nome;
    private String cpf;

//    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoTeste enderecoTeste;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaTeste")
    private List<TelefonesTeste> telefones;


    public PessoaTeste() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoTeste getEnderecoTeste() {
        return enderecoTeste;
    }

    public void setEnderecoTeste(EnderecoTeste enderecoTeste) {
        this.enderecoTeste = enderecoTeste;
    }

    public List<TelefonesTeste> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefonesTeste> telefones) {
        this.telefones = telefones;
    }
}
