package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnoLetivo {

    @Id
    @GeneratedValue
    private Integer id;

    public AnoLetivo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
