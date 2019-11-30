package projeto_pbd.com.br.modell;


import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Immutable
@Entity
public class Usuarioview {

    /*


create view usuarioview
as
select
	en.bairro, en.cep, en.cidade,en.complemento,en.logradouro, en.numero, en.uf,
	pe.endereco_id, pe.datanascimento, pe.naturalidade, pe.nome, pe.status,
	us.pessoa_id, us.cpf, us.email, us.tipodeacesso, us.senha

from
	usuario as us, pessoa as pe, endereco as en
where
	us.pessoa_id = pe.id
	and pe.endereco_id = en.id


    */


    @Id
    @GeneratedValue
    private Integer pessoa_id;
    private String email;
    private String tipodeacesso;
    private String cpf;
    private String senha;

    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String logradouro;
    private String numero;
    private String uf;

    private Integer endereco_id;
    private LocalDate datanascimento;
    private String naturalidade;
    private String nome;
    private Boolean status;

    public Usuarioview() {
    }

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipodeacesso() {
        return tipodeacesso;
    }

    public void setTipodeacesso(String tipodeacesso) {
        this.tipodeacesso = tipodeacesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Integer getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        this.endereco_id = endereco_id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuarioview{" +
                "pessoa_id=" + pessoa_id +
                ", email='" + email + '\'' +
                ", tipodeacesso='" + tipodeacesso + '\'' +
                ", cpf='" + cpf + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", uf='" + uf + '\'' +
                ", endereco_id=" + endereco_id +
                ", datanascimento=" + datanascimento +
                ", naturalidade='" + naturalidade + '\'' +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }
}
