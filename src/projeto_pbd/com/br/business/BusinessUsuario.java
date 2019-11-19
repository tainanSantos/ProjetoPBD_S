package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoUsuario;
import projeto_pbd.com.br.dao.IDaoUsuario;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public class BusinessUsuario implements IBusinessUsuario {

    private IDaoUsuario daoUsuario;

    public BusinessUsuario(){
        this.daoUsuario = new DaoUsuario ();
    }


    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return this.daoUsuario.save (usuario);
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return this.daoUsuario.findById (id);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return this.daoUsuario.findAll ();
    }

    @Override
    public List<Usuario> findAllNome(String nome) {
        return this.daoUsuario.findAllNome(nome);
    }

    @Override
    public Usuario removeUsuario(Integer id) {
        return this.daoUsuario.remove (id);
    }

    @Override
    public Usuario validarLoginSenha(String email, String senha) {
        return this.daoUsuario.validarLoginSenha(email,senha);
    }
}
