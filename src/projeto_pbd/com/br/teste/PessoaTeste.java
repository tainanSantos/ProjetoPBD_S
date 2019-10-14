package projeto_pbd.com.br.teste;


import projeto_pbd.com.br.modell.Telefone;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class PessoaTeste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nome;
    private String cpf;

    @OneToOne
    @JoinColumn(name="idEdereco")
    private EnderecoTeste enderecoTeste;

    @OneToMany( mappedBy="pessoa" )
    private ArrayList<TelefonesTeste> telefones;


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

    public ArrayList<TelefonesTeste> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<TelefonesTeste> telefones) {
        this.telefones = telefones;
    }
}
