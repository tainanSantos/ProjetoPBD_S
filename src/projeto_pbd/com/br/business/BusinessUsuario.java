package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoUsuario;
import projeto_pbd.com.br.dao.IDaoUsuario;
import projeto_pbd.com.br.modell.Usuario;

public class BusinessUsuario implements IBusinessUsuario {

    private IDaoUsuario daoUsuario;

    public BusinessUsuario(){
        this.daoUsuario = new DaoUsuario ();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return this.daoUsuario.salvarUsuario (usuario);
    }
}
