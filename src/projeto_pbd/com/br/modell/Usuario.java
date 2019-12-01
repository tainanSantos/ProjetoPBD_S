package projeto_pbd.com.br.modell;


import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Usuario extends Pessoa {

    private String email;
    private String senha;
    private String tipoDeAcesso;
    private String cpf;

    public Usuario() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoDeAcesso() {
        return tipoDeAcesso;
    }

    public void setTipoDeAcesso(String tipoDeAcesso) {
        this.tipoDeAcesso = tipoDeAcesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoDeAcesso='" + tipoDeAcesso + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}




//  GATILHO PARA QUANDO O USUÁRIO FOR ATUALIZADO

    /*
        create table update_usuario(
            id serial,
            cpf varchar,
            email varchar,
            senha varchar,
            tipodeacesso varchar,
            data_alteracao date
        );


        create function update_usuario_function()
        returns trigger as
        $$
            begin
                insert into update_usuario(cpf, email, senha, tipodeacesso, data_alteracao)
                values(new.cpf, new.email, new.senha, new.tipodeacesso, now());
                return new;
            end;
        $$ language 'plpgsql';


        create trigger registrar_atulizacao after insert or update on usuario
        for each row execute procedure update_usuario_function();
    */
