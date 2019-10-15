package projeto_pbd.com.br.modell;

/*
ima interface só para implementar tudo
*/

import projeto_pbd.com.br.teste.PessoaTeste;

import javax.persistence.*;
import java.util.List;



@Entity
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq",
        initialValue = 1, allocationSize = 1)
public class Usuario extends Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    private int id;
    private String email;
    private String senha; // a senha que se repete é só pra fazer a validação nas regras de negócio
    private String tipoDeAcesso;
    private String cpf;




    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Telefone> telefones;


    public Usuario() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoDeAcesso() {
        return tipoDeAcesso;
    }

    public void setTipoDeAcesso(String tipoDeAcesso) {
        this.tipoDeAcesso = tipoDeAcesso;
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
