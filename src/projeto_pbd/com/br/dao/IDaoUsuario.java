package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.UsuarioLogado;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public interface IDaoUsuario {


    public Usuario save(Usuario usuario);

    public UsuarioLogado saveUsuarioLogado(UsuarioLogado usuarioLogado);

    public Usuario findById(Integer id);

    public List<Usuarioview> findAllUsuarioview();

    public List<Usuarioview> findAllNome(String nome);

    public Usuario remove(Integer id);

    public  Usuarioview validarLoginSenha(String email, String senha);


}
