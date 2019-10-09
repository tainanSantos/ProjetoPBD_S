package projeto_pbd.com.br.modell;

import javax.persistence.*;

public class Usuario extends  Pessoa {


    private int id;
//
//    @OneToOne
//    @JoinColumn(name = "idTelefone")
    private Telefone telefone;

    private String email;
    private String senha; // a senha que se repete é só pra fazer a validação nas regras de negócio

    public Usuario() {
    }

    public Usuario(Telefone telefone, String email, String senha) {
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
