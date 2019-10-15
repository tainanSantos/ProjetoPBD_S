package projeto_pbd.com.br.teste;

import javax.persistence.*;


//@Entity
//@SequenceGenerator (name = "telefoneteste_seq", sequenceName = "telefoneteste_seq",
//        initialValue = 1, allocationSize = 1)
public class TelefonesTeste {


//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefoneteste_seq")
    private int id;
    private String numerio;
//    @ManyToOne
//    @JoinColumn(name = "pessoateste_id")
    private PessoaTeste pessoaTeste;


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

    public PessoaTeste getPessoaTeste() {
        return pessoaTeste;
    }

    public void setPessoaTeste(PessoaTeste pessoaTeste) {
        this.pessoaTeste = pessoaTeste;
    }
}
