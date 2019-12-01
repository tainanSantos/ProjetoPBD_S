package projeto_pbd.com.br.modell;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Immutable
@Entity
public class alunoView {


    /*
     create view alunoview as
        select
            en.bairro, en.cep, en.cidade,en.complemento,en.logradouro, en.numero, en.uf,
            pe.endereco_id, pe.datanascimento, pe.naturalidade, pe.nome, pe.status,
            al.maiodeidadeeresponsavel, al.nomemae, al.nomepai,al.pessoa_id ,al.curriculo_id, al.responsavel_pessoa_id, al.turma_id
            from aluno as al, pessoa as pe, endereco as en
        where
            pe.id = al.pessoa_id
            and pe.endereco_id = en.id
    */


    @Id
    @GeneratedValue
    private Integer pessoa_id;
    private Integer curriculo_id;
    private Integer responsavel_pessoa_id;
    private Integer turma_id;
    private Integer endereco_id;
    private Boolean maiodeidadeeresponsavel;
    private String nomemae;
    private String nomepai;

    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String logradouro;
    private String numero;
    private String uf;

    private LocalDate datanascimento;
    private String naturalidade;
    private String nome;
    private Boolean status;

    public alunoView() {
    }


    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public Integer getCurriculo_id() {
        return curriculo_id;
    }

    public void setCurriculo_id(Integer curriculo_id) {
        this.curriculo_id = curriculo_id;
    }

    public Integer getResponsavel_pessoa_id() {
        return responsavel_pessoa_id;
    }

    public void setResponsavel_pessoa_id(Integer responsavel_pessoa_id) {
        this.responsavel_pessoa_id = responsavel_pessoa_id;
    }

    public Integer getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(Integer turma_id) {
        this.turma_id = turma_id;
    }

    public Integer getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        this.endereco_id = endereco_id;
    }

    public Boolean getMaiodeidadeeresponsavel() {
        return maiodeidadeeresponsavel;
    }

    public void setMaiodeidadeeresponsavel(Boolean maiodeidadeeresponsavel) {
        this.maiodeidadeeresponsavel = maiodeidadeeresponsavel;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public String getNomepai() {
        return nomepai;
    }

    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "alunoView{" +
                "pessoa_id=" + pessoa_id +
                ", curriculo_id=" + curriculo_id +
                ", responsavel_pessoa_id=" + responsavel_pessoa_id +
                ", turma_id=" + turma_id +
                ", endereco_id=" + endereco_id +
                ", maiodeidadeeresponsavel=" + maiodeidadeeresponsavel +
                ", nomemae='" + nomemae + '\'' +
                ", nomepai='" + nomepai + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", uf='" + uf + '\'' +
                ", datanascimento=" + datanascimento +
                ", naturalidade='" + naturalidade + '\'' +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }




}