package projeto_pbd.com.br.modell;

import javax.persistence.*;

@Entity
public class Telefone {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String tipo;
    private String numero;


    public Telefone(){

    }


    public Telefone(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

}
