package projeto_pbd.com.br.modell;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Immutable
public class TurmaGerenciamentoView {

    @Id
    @GeneratedValue
    private Integer id;

    public TurmaGerenciamentoView() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
