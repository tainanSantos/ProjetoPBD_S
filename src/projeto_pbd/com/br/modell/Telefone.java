package projeto_pbd.com.br.modell;

import projeto_pbd.com.br.teste.TelefonesTeste;

import javax.persistence.*;

@Entity
public class Telefone extends TelefonesTeste {


    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    private String numero;


    @ManyToOne
    private Pessoa pessoa;

    public Telefone(){

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
