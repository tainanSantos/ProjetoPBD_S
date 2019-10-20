package projeto_pbd.com.br.modell;

import projeto_pbd.com.br.teste.TelefonesTeste;

import javax.persistence.*;

@Entity
public class Telefone extends TelefonesTeste {


    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String tipo;
    @Column
    private String numero;


    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;


    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;


    @ManyToOne(cascade = CascadeType.ALL)
    private Pedagogo pedagogo;


    public Telefone(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Pedagogo getPedagogo() {
        return pedagogo;
    }

    public void setPedagogo(Pedagogo pedagogo) {
        this.pedagogo = pedagogo;
    }
}
