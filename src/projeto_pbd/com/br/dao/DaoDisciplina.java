package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Disciplina;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class DaoDisciplina implements IDaoDisciplina {


    @Override
    public Disciplina save(Disciplina disciplina) throws PersistenceException {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(disciplina.getId () == null){ // inserir
                em.persist (disciplina);
            }else { // atualizar
                em.merge (disciplina);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return disciplina;
    }


    @Override
    public Disciplina findById(int id) {
        EntityManager em = new Conection().getEntityManager ();

        Disciplina disciplina = null;

        try {
            disciplina = em.find (Disciplina.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return disciplina;    }

    @Override
    public List<Disciplina> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Disciplina> disciplinas = null;

        try {
            disciplinas = em.createQuery ("from Disciplina").getResultList ();
        }catch (Exception e ){

        }finally {
            em.close (); // fecha conexão
        }
        return disciplinas;
    }

    @Override
    public Disciplina remove(int id) {
        EntityManager em = new Conection().getEntityManager ();
        Disciplina disciplina = null;

        try {
            disciplina = em.find (Disciplina.class, id);
            em.getTransaction ().begin ();
            em.remove (disciplina);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return disciplina;
    }
}
