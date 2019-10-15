package projeto_pbd.com.br.modell;

import projeto_pbd.com.br.teste.TelefonesTeste;

import javax.persistence.*;

@Entity
@SequenceGenerator (name = "telefone_seq", sequenceName = "telefone_seq",
        initialValue = 1, allocationSize = 1)
public class Telefone extends TelefonesTeste {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_seq")
    private int id;
    private String tipo;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "pedagogo_id")
    private Pedagogo pedagogo;


    public Telefone(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
