package projeto_pbd.com.br.modell;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
@Immutable
public class DisciplinaNotasView {


    // lembrando que esse vai ser o id da nota ok
    @Id
    @GeneratedValue
    private Integer id;

    //PEGAR O ID DO CURRÍCULO AQUI TABMBÉMcurriculo_id

    private Integer pessoa_id;
    private Integer disciplina_id;
    private Integer curriculo_id;

    private Double primeirava;
    private Double segundava;
    private Double terceirava;
    private Double quartava;
    private Double finalva;
    private Double media;

    private Boolean status;
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

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public Integer getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(Integer disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public Integer getCurriculo_id() {
        return curriculo_id;
    }

    public void setCurriculo_id(Integer curriculo_id) {
        this.curriculo_id = curriculo_id;
    }

    public Double getPrimeirava() {
        return primeirava;
    }

    public void setPrimeirava(Double primeirava) {
        this.primeirava = primeirava;
    }

    public Double getSegundava() {
        return segundava;
    }

    public void setSegundava(Double segundava) {
        this.segundava = segundava;
    }

    public Double getTerceirava() {
        return terceirava;
    }

    public void setTerceirava(Double terceirava) {
        this.terceirava = terceirava;
    }

    public Double getQuartava() {
        return quartava;
    }

    public void setQuartava(Double quartava) {
        this.quartava = quartava;
    }

    public Double getFinalva() {
        return finalva;
    }

    public void setFinalva(Double finalva) {
        this.finalva = finalva;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
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




/*
create view disciplinanotasview as

select

		al.pessoa_id, d.curriculo_id, disciplina_id, n.id, n.primeirava, n.segundava,
		n.terceirava, n.quartava, n.finalva, n.status, d.nome, n.resultado, n.media

	from
		nota as n, disciplina as d, curriculo as cu, aluno al
	where
		d.id = n.disciplina_id
		and d.curriculo_id = cu.id
		and d.curriculo_id = 	cu.id
		and al.pessoa_id = n.aluno_pessoa_id
*/




/*

-- se a tabela curríclo estiver vazia
-- então no momento do cadastro da disciplina
-- este gatilho será executado e dará carga na tabela de currículos

create  function carregar_curriculo()
returns trigger as
$$
	begin
		if not exists (select 1 from curriculo) then
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (1,'1 - EF - ANOS INICIAL', false, (select id from configuracao),
					(select valorparcelaanosiniciaisef from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (2,'2 a 5 - EF - ANOS INICIAL', false, (select id from configuracao),
					(select valorparcelaanosiniciaisef from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (3,'6 a 8 - EF - ANOS FINAIS', false, (select id from configuracao),
					(select valorparcelaanosfinaisef from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (4,'9 - EF - ANOS FINAIS', false, (select id from configuracao),
					(select valorparcelaanosfinaisef from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (5,'1 - EM - ENSINO MÉDIO', false, (select id from configuracao),
					(select valorparcelaaensinomedioem from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (6,'2 - EM - ENSINO MÉDIO', false, (select id from configuracao),
					(select valorparcelaaensinomedioem from configuracao));
			insert into curriculo(id, nome, status, configuracao_id, valorparcela)
			values (7,'3 - EM - ENSINO MÉDIO', false, (select id from configuracao),
					(select valorparcelaaensinomedioem from configuracao));
		end if;
		return new;
	end;
$$ language 'plpgsql';

-- vamos disparar esse gatilho no momento do cadastro de dsiciplina

create trigger carregar_curriculos after update or insert on disciplina
for each row execute procedure carregar_curriculo();

*/
