package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Usuario;

import java.util.List;

public interface IDaoUsuario {


    public Usuario save(Usuario usuario);

    public Usuario findById(Integer id);

    public List<Usuario> findAll();

    public List<Usuario> findAllNome(String nome);

    public Usuario remove(Integer id);

}
