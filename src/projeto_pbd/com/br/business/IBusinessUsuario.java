package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public interface IBusinessUsuario {

    public Usuario saveUsuario(Usuario usuario);

    public Usuario findByIdUsuario(Integer id);

    public List<Usuario> findAllUsuario();

    public Usuario removeUsuario(Integer id);
}
