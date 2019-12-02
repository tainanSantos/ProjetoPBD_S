package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.UsuarioLogado;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public interface IBusinessUsuario {

    public Usuario saveUsuario(Usuario usuario);

    public UsuarioLogado saveUsuarioLogado(UsuarioLogado usuarioLogado);

    public Usuario findByIdUsuario(Integer id);

    public List<Usuarioview> findAllUsuario();

    public List<Usuarioview> findAllNome(String nome);

    public Usuario removeUsuario(Integer id);

    public UsuarioLogado findAllUsuarioLogado();

    public  Usuarioview validarLoginSenha(String email, String senha);

}
