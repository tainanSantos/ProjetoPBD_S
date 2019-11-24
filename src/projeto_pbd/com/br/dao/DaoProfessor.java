package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Professor;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoProfessor implements IDaoProfessor{


    @Override
    public Professor save(Professor professor) {

        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(professor.getId () == null){ // inserir
                em.persist(professor.getEndereco());
                em.persist (professor);
            }else { // atualizar
                em.merge(professor.getEndereco());
                em.merge (professor);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return professor;
    }


    @Override
    public Professor findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Professor professor = null;

        try {
            professor = em.find (Professor.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return professor;
    }


    @Override
    public List<Professor> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Professor> professores = null;

        try {
            professores = em.createQuery ("from Professor").getResultList ();
        }catch (Exception e ){

        }finally {
            em.close (); // fecha conexão
        }

        return professores;
    }


    @Override
    public Professor remove(Integer id) {
        EntityManager em = new Conection().getEntityManager ();
        Professor professor = null;

        try {
            professor = em.find (Professor.class, id);
            em.getTransaction ().begin ();
            em.remove (professor);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return professor;
    }


}
