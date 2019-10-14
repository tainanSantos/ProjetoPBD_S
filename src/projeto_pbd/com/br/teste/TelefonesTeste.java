package projeto_pbd.com.br.teste;

import javax.persistence.*;


@Entity
public class TelefonesTeste {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String numerio;

    @ManyToOne
    @JoinColumn(name = "idPessoaTeste")
    private PessoaTeste pessoa;


    public TelefonesTeste() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerio() {
        return numerio;
    }

    public void setNumerio(String numerio) {
        this.numerio = numerio;
    }


}
