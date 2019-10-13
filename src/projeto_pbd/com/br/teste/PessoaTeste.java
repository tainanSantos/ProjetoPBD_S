package projeto_pbd.com.br.teste;

import projeto_pbd.com.br.modell.Pessoa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

public abstract class PessoaTeste {

    private String nome;
    private String cpf;


    public PessoaTeste(){

    }


    public PessoaTeste(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PessoaTeste{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}