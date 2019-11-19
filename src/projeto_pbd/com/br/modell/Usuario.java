package projeto_pbd.com.br.modell;


import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
//@Subselect("selected email, senha, tipoDeAcesso, cpf") // nessa não a view é gerada de foma auromática
//@Immutable nessa eu preciso criar view lá no banco
public class Usuario extends Pessoa {


    private String email;
    private String senha; // a senha que se repete é só pra fazer a validação nas regras de negócio
    private String tipoDeAcesso;
    private String cpf;

    public Usuario() {

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


}
