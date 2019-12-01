package projeto_pbd.com.br.modell;


import javax.persistence.*;

@Entity
public class Curriculo {

    // tipoCurriculo poderia ser enum
    // mas por questão de tempo não vou usar enum.

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Boolean status;

    // ver como setar a configuração no momento do cadastramento do currículo

    @ManyToOne
    private Configuracao configuracao;

    private Double valorParcela;

    public Curriculo() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    @Override
    public String toString() {
        return ""+nome;
    }
}
