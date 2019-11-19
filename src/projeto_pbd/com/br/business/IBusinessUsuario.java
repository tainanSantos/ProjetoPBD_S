package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public interface IBusinessUsuario {

    public Usuario saveUsuario(Usuario usuario);

    public Usuario findByIdUsuario(Integer id);

    public List<Usuario> findAllUsuario();

    public List<Usuario> findAllNome(String nome);

    public Usuario removeUsuario(Integer id);

    public  Usuario validarLoginSenha(String email, String senha);

}
