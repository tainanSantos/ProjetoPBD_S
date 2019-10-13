package projeto_pbd.com.br.modell;



import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Usuario extends  Pessoa {




    private String email;
    private String senha; // a senha que se repete é só pra fazer a validação nas regras de negócio
    private String tipoDeAcesso;
    private String cpf;


    private ArrayList<Telefone> telefones;


    public Usuario() {

    }


    public Usuario(String nome, String dataNascimento, String naturalidade, Endereco endereco, String email,
                   String senha, String tipoDeAcesso, String cpf) {
        super (nome, dataNascimento, naturalidade, endereco);
        this.email = email;
        this.senha = senha;
        this.tipoDeAcesso = tipoDeAcesso;
        this.cpf = cpf;
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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

//    @Override
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(int id) {
//        this.id = id;
//    }

    @OneToMany(cascade = CascadeType.ALL)
    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }




    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoDeAcesso='" + tipoDeAcesso + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
