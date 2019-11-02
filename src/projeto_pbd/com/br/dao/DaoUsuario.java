package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoUsuario implements IDaoUsuario {


    @Override
    public Usuario save(Usuario usuario) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(usuario.getId () == null){ // inserir
                em.persist(usuario.getEndereco());
                em.persist (usuario);
            }else { // atualizar
                em.merge(usuario.getEndereco());
                em.merge (usuario);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return usuario;    }

    @Override
    public Usuario findById(int id) {
        EntityManager em = new Conection().getEntityManager ();

        Usuario usuario = null;

        try {
            usuario = em.find (Usuario.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return usuario;    }

    @Override
    public List<Usuario> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Usuario> usuarios = null;

        try {
            usuarios = em.createQuery ("from Usuario").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return usuarios;    }

    @Override
    public Usuario remove(int id) {
        EntityManager em = new Conection().getEntityManager ();
        Usuario usuario = null;

        try {
            usuario = em.find (Usuario.class, id);
            em.getTransaction ().begin ();
            em.remove (usuario);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return usuario;    }
}
