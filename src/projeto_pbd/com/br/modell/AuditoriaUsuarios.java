package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

// classe que vai guardar os dados dos  usuários que foram modificados
// e por quem foram modificado e quando foram modificados

@Entity
public class AuditoriaUsuarios {


    @Id
    @GeneratedValue
    private Integer id;
    private String nomeUser;
    private String cpfUser;
    private String emailUser;
    private String tipodeacessoUser;

    private String cpfUserModificado;
    private String emailUserModificado;
    private String tipodeacessoUserModificado;

    private String datamodificacao;

    public AuditoriaUsuarios() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTipodeacessoUser() {
        return tipodeacessoUser;
    }

    public void setTipodeacessoUser(String tipodeacessoUser) {
        this.tipodeacessoUser = tipodeacessoUser;
    }

    public String getCpfUserModificado() {
        return cpfUserModificado;
    }

    public void setCpfUserModificado(String cpfUserModificado) {
        this.cpfUserModificado = cpfUserModificado;
    }

    public String getEmailUserModificado() {
        return emailUserModificado;
    }

    public void setEmailUserModificado(String emailUserModificado) {
        this.emailUserModificado = emailUserModificado;
    }

    public String getTipodeacessoUserModificado() {
        return tipodeacessoUserModificado;
    }

    public void setTipodeacessoUserModificado(String tipodeacessoUserModificado) {
        this.tipodeacessoUserModificado = tipodeacessoUserModificado;
    }

    public String getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(String datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    @Override
    public String toString() {
        return "AuditoriaUsuarios{" +
                "id=" + id +
                ", nomeUser='" + nomeUser + '\'' +
                ", cpfUser='" + cpfUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", tipodeacessoUser='" + tipodeacessoUser + '\'' +
                ", cpfUserModificado='" + cpfUserModificado + '\'' +
                ", emailUserModificado='" + emailUserModificado + '\'' +
                ", tipodeacessoUserModificado='" + tipodeacessoUserModificado + '\'' +
                ", datamodificacao=" + datamodificacao +
                '}';
    }
}
