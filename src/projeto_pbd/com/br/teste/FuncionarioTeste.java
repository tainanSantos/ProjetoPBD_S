package projeto_pbd.com.br.teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class FuncionarioTeste {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String cpf;
    private String nome;


    public FuncionarioTeste(){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
