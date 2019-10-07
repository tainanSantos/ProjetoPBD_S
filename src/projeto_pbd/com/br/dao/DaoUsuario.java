package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.sqlConnectionFactory.ConnectionFactory;

import javax.persistence.EntityManager;

public class DaoUsuario implements IDaoUsuario {

    @Override
    public Usuario salvarUsuario(Usuario usuario) {

        EntityManager em = ConnectionFactory.getConnectionFactory ();

        em.getTransaction ().begin ();
        em.persist (usuario);
        em.getTransaction ().commit ();
        em.close ();

        return null;
    }

}
