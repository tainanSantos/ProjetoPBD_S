package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoCurriculo implements IDaoCurriculo {



    @Override
    public Curriculo save(Curriculo curriculo) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(curriculo.getId () == null){ // inserir
                em.persist (curriculo);
            }else { // atualizar
                em.merge (curriculo);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return curriculo;
    }

    @Override
    public Curriculo findById(Integer id) {

        EntityManager em = new Conection().getEntityManager ();

        Curriculo curriculo = null;

        try {
            curriculo = em.find (Curriculo.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return curriculo;
    }

    @Override
    public Curriculo findByNome(String nomeCurriculo) {
        EntityManager em = new Conection().getEntityManager ();

        Curriculo curriculo = null;

        try {
            TypedQuery<Curriculo> query = em.createQuery (SqlUtil.BUSCAR_CURRICULO_POR_NOME, Curriculo.class);
            query.setParameter("nome", nomeCurriculo);
            curriculo = query.getSingleResult();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return curriculo;
    }

    @Override
    public List<Curriculo> findAll() {

        EntityManager em = new Conection().getEntityManager ();
        List<Curriculo> curriculos = null;

        try {
            curriculos = em.createQuery ("from Curriculo").getResultList ();
        }catch (Exception e ){

        }finally {
            em.close (); // fecha conexão
        }
        return curriculos;
    }

    @Override
    public Curriculo remove(Integer id) {
        EntityManager em = new Conection().getEntityManager ();
        Curriculo curriculo = null;

        try {
            curriculo = em.find (Curriculo.class, id);
            em.getTransaction ().begin ();
            em.remove (curriculo);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return curriculo;
    }

}
