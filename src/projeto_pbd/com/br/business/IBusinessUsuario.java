package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public interface IBusinessUsuario {

    public Usuario save(Usuario usuario);

    public Usuario findById(Integer id);

    public List<Usuario> findAll();

    public Usuario remove(Integer id);
}
