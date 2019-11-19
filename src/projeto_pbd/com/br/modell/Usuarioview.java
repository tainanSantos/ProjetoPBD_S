package projeto_pbd.com.br.modell;

//
//import org.hibernate.annotations.Immutable;
//
//import javax.persistence.Entity;
//
//@Immutable
//@Entity

public class Usuarioview {

    // falta colocar os dados do jeito que estão definidos lá no banco
    // lembrar de rafezer aquela view lá no banco, uma vez que o
    // cada pessoa tem 2 telefones e isso ta repliando a linha da pessoa

    private Integer pessoa_id;
    private String email;
    private String senha; // a senha que se repete é só pra fazer a validação nas regras de negócio
    private String tipoDeAcesso;
    private String cpf;

    public Usuarioview() {
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

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    @Override
    public String toString() {
        return "Usuariovw{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoDeAcesso='" + tipoDeAcesso + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
