package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DaoUsuario implements IDaoUsuario {


    @Override
    public Usuario save(Usuario usuario) {
        EntityManager em = new Conection().getEntityManager ();

        usuario.setSenha(functioCrip2(usuario.getSenha()));

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
        return usuario;
    }


    @Override
    public Usuario findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Usuario usuario = null;

        try {
            usuario = em.find (Usuario.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return usuario;
    }


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

        return usuarios;
    }


    @Override
    public List<Usuario> findAllNome(String nome) {
        EntityManager em = new Conection().getEntityManager ();
        List<Usuario> usuarios = null;
        try {
            TypedQuery<Usuario> query = em.createQuery(SqlUtil.BUSCAR_USUARIO_POR_NOME, Usuario.class);
            query.setParameter("nome", "%"+nome+"%");
            usuarios = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return usuarios;
    }


    @Override
    public Usuario remove(Integer id) {
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
        return usuario;
    }


    @Override
    public Usuario validarLoginSenha(String email, String senha) {
        EntityManager em = new Conection().getEntityManager ();
        senha = functioCrip2(senha);
        Usuario usuario = null;

        try {
            TypedQuery<Usuario> query = em.createQuery (SqlUtil.BUSCAR_USUARIO_LOGIN_SENHA, Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            usuario = query.getSingleResult();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return usuario;
    }


    public String functioCrip2(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

}
