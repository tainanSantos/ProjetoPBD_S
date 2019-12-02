package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
    import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class UsuarioLogado {

    @Id
    private Integer id;
    private Integer pessoa_id;
    private String nome;
    private String cpf;
    private String email;
    private String tipodeacesso;
    private LocalDate datamodificacao;


    public UsuarioLogado() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipodeacesso() {
        return tipodeacesso;
    }

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public void setTipodeacesso(String tipodeacesso) {
        this.tipodeacesso = tipodeacesso;
    }

    public LocalDate getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(LocalDate datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    @Override
    public String toString() {
        return "UsuarioLogado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", tipodeacesso='" + tipodeacesso + '\'' +
                ", datamodificacao=" + datamodificacao +
                '}';
    }
}
