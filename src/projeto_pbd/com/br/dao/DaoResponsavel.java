package projeto_pbd.com.br.dao;


import projeto_pbd.com.br.modell.Responsavel;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoResponsavel implements IDaoResponsavel {


    @Override
    public Responsavel save(Responsavel responsavel) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(responsavel.getId () == null){ // inserir
                em.persist(responsavel.getEndereco());
                em.persist (responsavel);
            }else { // atualizar
                em.merge(responsavel.getEndereco());
                em.merge (responsavel);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return responsavel;
    }

    @Override
    public Responsavel findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Responsavel responsavel= null;

        try {
            responsavel = em.find (Responsavel.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return responsavel;
    }

    @Override
    public List<Responsavel> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Responsavel> responsavels = null;

        try {
            responsavels = em.createQuery ("from Responsavel").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return responsavels;
    }

    @Override
    public Responsavel remove(Integer id) {
        EntityManager em = new Conection().getEntityManager ();
        Responsavel responsavel = null;

        try {
            responsavel = em.find (Responsavel.class, id);
            em.getTransaction ().begin ();
            em.remove (responsavel);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return responsavel;
    }
}
