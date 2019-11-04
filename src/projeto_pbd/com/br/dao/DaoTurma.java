package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Turma;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoTurma implements IDaoTurma {
    @Override
    public Turma save(Turma turma) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(turma.getId () == null){ // inserir
                em.persist (turma);
            }else { // atualizar
                em.merge (turma);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return turma;

    }

    @Override
    public Turma findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Turma turma = null;

        try {
            turma = em.find (Turma.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return turma;
    }

    @Override
    public List<Turma> findAll() {

        EntityManager em = new Conection().getEntityManager ();
        List<Turma> turmas = null;

        try {
            turmas = em.createQuery ("from Turma").getResultList ();
        }catch (Exception e ){

        }finally {
            em.close (); // fecha conexão
        }
        return turmas;
    }

    @Override
    public Turma remove(Integer id) {
        EntityManager em = new Conection().getEntityManager ();
        Turma turma = null;

        try {
            turma = em.find (Turma.class, id);
            em.getTransaction ().begin ();
            em.remove (turma);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return turma;
    }
}
