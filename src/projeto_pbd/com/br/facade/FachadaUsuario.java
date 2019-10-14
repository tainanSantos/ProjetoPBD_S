package projeto_pbd.com.br.facade;

import projeto_pbd.com.br.business.BusinessUsuario;
import projeto_pbd.com.br.business.IBusinessUsuario;
import projeto_pbd.com.br.modell.Usuario;

public class FachadaUsuario implements IFachadaUsuario {

    private IBusinessUsuario businessUsuario;

    public FachadaUsuario(){
        this.businessUsuario = new BusinessUsuario ();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return this.businessUsuario.salvarUsuario (usuario);
    }
}
