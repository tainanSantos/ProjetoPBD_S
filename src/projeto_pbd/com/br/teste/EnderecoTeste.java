package projeto_pbd.com.br.teste;

import javax.persistence.*;

//@Entity
//@SequenceGenerator (name = "enderecoteste_seq", sequenceName = "enderecoteste_seq",
//        allocationSize = 1,initialValue = 1)
public class EnderecoTeste {


//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecoteste_seq")
    private int id;
    private String rua;
    private String numeroCasa;

    public EnderecoTeste() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
}
