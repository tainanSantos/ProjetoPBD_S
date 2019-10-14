package projeto_pbd.com.br.facade;

import projeto_pbd.com.br.business.BusinessUsuario;
import projeto_pbd.com.br.business.IBusinessUsuario;
import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public class FacadeUsuario implements IFacadeUsuario {

    private IBusinessUsuario businessUsuario;

    public FacadeUsuario(){
        this.businessUsuario = new BusinessUsuario ();
    }


    @Override
    public Usuario save(Usuario usuario) {
        return this.businessUsuario.save (usuario);
    }

    @Override
    public Usuario findById(int id) {
        return this.businessUsuario.findById (id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.businessUsuario.findAll ();
    }

    @Override
    public Usuario remove(int id) {
        return this.businessUsuario.remove (id);
    }
}
