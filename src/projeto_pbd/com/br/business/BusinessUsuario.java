package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoUsuario;
import projeto_pbd.com.br.dao.IDaoUsuario;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.modell.UsuarioLogado;
import projeto_pbd.com.br.modell.Usuarioview;

import java.util.List;

public class BusinessUsuario implements IBusinessUsuario {

    private IDaoUsuario daoUsuario;

    public BusinessUsuario(){
        this.daoUsuario = new DaoUsuario ();
    }


    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return this.daoUsuario.save (usuario);
    }

    @Override
    public UsuarioLogado saveUsuarioLogado(UsuarioLogado usuarioLogado) {
        return this.daoUsuario.saveUsuarioLogado(usuarioLogado);
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return this.daoUsuario.findById (id);
    }

    @Override
    public List<Usuarioview> findAllUsuario() {
        return this.daoUsuario.findAllUsuarioview ();
    }

    @Override
    public List<Usuarioview> findAllNome(String nome) {
        return this.daoUsuario.findAllNome(nome);
    }

    @Override
    public Usuario removeUsuario(Integer id) {
        return this.daoUsuario.remove (id);
    }

    @Override
    public Usuarioview validarLoginSenha(String email, String senha) {
        return this.daoUsuario.validarLoginSenha(email,senha);
    }
}
