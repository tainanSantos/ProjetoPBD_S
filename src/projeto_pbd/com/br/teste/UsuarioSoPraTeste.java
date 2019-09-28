package projeto_pbd.com.br.teste;

import javax.persistence.*;

@Entity
public class UsuarioSoPraTeste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String login;
    @Column
    private String senha;


    public UsuarioSoPraTeste() {

    }

    public UsuarioSoPraTeste(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


