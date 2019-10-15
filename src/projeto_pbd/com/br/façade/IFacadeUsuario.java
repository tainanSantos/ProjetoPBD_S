package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public interface IFacadeUsuario {

    public Usuario save(Usuario usuario);

    public Usuario findById(int id);

    public List<Usuario> findAll();

    public Usuario remove(int id);
}
