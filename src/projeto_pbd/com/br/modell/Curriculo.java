package projeto_pbd.com.br.modell;


import javax.persistence.*;

@Entity
public class Curriculo {

    /*
    * ENUM
    *
    * Campos do ENUM:
    *       EF
    *       EF
    *       EM
    * */

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;



    public Curriculo() {
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


}
