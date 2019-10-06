package projeto_pbd.com.br.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String numeroUm;
    private String numeroDois;


    public Telefone(String numeroUm, String numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroUm() {
        return numeroUm;
    }

    public void setNumeroUm(String numeroUm) {
        this.numeroUm = numeroUm;
    }

    public String getNumeroDois() {
        return numeroDois;
    }

    public void setNumeroDois(String numeroDois) {
        this.numeroDois = numeroDois;
    }


    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numeroUm='" + numeroUm + '\'' +
                ", numeroDois='" + numeroDois + '\'' +
                '}';
    }
}
