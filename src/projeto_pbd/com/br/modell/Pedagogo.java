package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Pedagogo extends Pessoa {


    private String graduacao;
    private String cpf;

    public Pedagogo() {
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



   }
