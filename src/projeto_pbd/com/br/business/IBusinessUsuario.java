package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public interface IBusinessUsuario {

    public Usuario saveUsuario(Usuario usuario);

    public Usuario findByIdUsuario(Integer id);

    public List<Usuarioview> findAllUsuario();

    public List<Usuarioview> findAllNome(String nome);

    public Usuario removeUsuario(Integer id);

    public  Usuarioview validarLoginSenha(String email, String senha);

}
