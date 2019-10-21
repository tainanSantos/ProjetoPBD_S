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
    private String codigo;
    private String nome;
//    @ManyToOne
//    private Aluno aluno;


    public Curriculo() {
    }

//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
