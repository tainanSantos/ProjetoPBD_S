package projeto_pbd.com.br.modell;

import javax.persistence.*;
import java.util.List;
@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Responsavel extends  Pessoa {

    private String cpf;

    public Responsavel() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
