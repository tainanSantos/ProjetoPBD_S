package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoUsuario;
import projeto_pbd.com.br.dao.IDaoUsuario;
import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public class BusinessUsuario implements IBusinessUsuario {

    private IDaoUsuario daoUsuario;

    public BusinessUsuario(){
        this.daoUsuario = new DaoUsuario ();
    }


    @Override
    public Usuario save(Usuario usuario) {
        return this.daoUsuario.save (usuario);
    }

    @Override
    public Usuario findById(int id) {
        return this.daoUsuario.findById (id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.daoUsuario.findAll ();
    }

    @Override
    public Usuario remove(int id) {
        return this.daoUsuario.remove (id);
    }
}
