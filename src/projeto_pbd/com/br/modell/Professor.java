package projeto_pbd.com.br.modell;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Professor extends Pessoa  {


    private String graduacao;
    private String cpf;

    // CAMPO PARA SELECIONAR MARCAR ONJETOS NA TABELA
    private Boolean selectTable;

    public Professor() {
    }

    public Boolean getSelectTable() {
        return selectTable;
    }

    public void setSelectTable(Boolean selectTable) {
        this.selectTable = selectTable;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
}
