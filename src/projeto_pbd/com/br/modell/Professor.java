package projeto_pbd.com.br.modell;


public class Professor extends Pessoa  {


    private int id;
    private String nome;
    private String dataNascomento;
    private String naturalidade;
    private String cpf;


    public Professor() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascomento() {
        return dataNascomento;
    }

    public void setDataNascomento(String dataNascomento) {
        this.dataNascomento = dataNascomento;
    }

    @Override
    public String getNaturalidade() {
        return naturalidade;
    }

    @Override
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
