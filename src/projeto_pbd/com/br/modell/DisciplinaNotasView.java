package projeto_pbd.com.br.modell;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
create view disciplinanotasview as

select

		curriculo_id, disciplina_id, n.id, n.primeirava, n.segundava,
		n.terceirava, n.quartava, n.finalva, n.status, d.nome, n.resultado

	from
		nota as n, disciplina as d, curriculo as cu
	where
		d.id = n.disciplina_id and d.curriculo_id = cu.id and d.curriculo_id = 	cu.id
*/

@Entity
@Immutable
public class DisciplinaNotasView {


    // lembrando que esse vai ser o id da nota ok
    @Id
    @GeneratedValue
    private Integer id;

    //PEGAR O ID DO CURRÍCULO AQUI TABMBÉMcurriculo_id

    private Integer disciplina_id;
    private Integer curriculo_id;
    private Integer primeirava;
    private Integer segundava;
    private Integer terceirava;
    private Integer quartava;
    private Integer finalva;
    private Boolean status;
    private Integer media;
    private String nome;
    private String resultado;


    // precisaremos também do Id do aluno e da disciplina, Somente

    public DisciplinaNotasView() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

    public Integer getDisciplina_id() {
        return disciplina_id;
    }


    public void setDisciplina_id(Integer disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public Integer getPrimeirava() {
        return primeirava;
    }

    public void setPrimeirava(Integer primeirava) {
        this.primeirava = primeirava;
    }

    public Integer getSegundava() {
        return segundava;
    }

    public void setSegundava(Integer segundava) {
        this.segundava = segundava;
    }

    public Integer getTerceirava() {
        return terceirava;
    }

    public void setTerceirava(Integer terceirava) {
        this.terceirava = terceirava;
    }

    public Integer getQuartava() {
        return quartava;
    }

    public void setQuartava(Integer quartava) {
        this.quartava = quartava;
    }

    public Integer getFinalva() {
        return finalva;
    }

    public void setFinalva(Integer finalva) {
        this.finalva = finalva;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getCurriculo_id() {
        return curriculo_id;
    }

    public void setCurriculo_id(Integer curriculo_id) {
        this.curriculo_id = curriculo_id;
    }


/*
     CPI = QUANTIDADE DE INSTRUÇÕES POR CICLO INFRA DE HARDWARE
     A ESTRUTURA MONOCICLO VAI EXECUTAR TUDO EM UM TEMPO SÓ

     NA PROVA ELE PODERIA COLOCAR PARA GENTE ANALISAR A ESTRUTURA MUTICICLO E MONOCICLO E
     DIZER QUAL A SERIA MAIS RÁPIDA
*/


    @Override
    public String toString() {
        return "DisciplinaNotasView{" +
                "disciplina_id=" + disciplina_id +
                ", curriculo_id=" + curriculo_id +
                ", primeirava=" + primeirava +
                ", segundava=" + segundava +
                ", terceirava=" + terceirava +
                ", quartava=" + quartava +
                ", finalva=" + finalva +
                ", status=" + status +
                ", media=" + media +
                ", nome='" + nome + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
