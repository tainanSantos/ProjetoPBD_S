package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoAluno implements IDaoAluno {


    @Override
    public Aluno save(Aluno aluno) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(aluno.getId () == null){ // inserir
                em.persist (aluno);
            }else { // atualizar
                em.merge (aluno);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return aluno;    }

    @Override
    public Aluno findById(int id) {
        EntityManager em = new Conection().getEntityManager ();

        Aluno aluno= null;

        try {
            aluno = em.find (Aluno.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return aluno;    }

    @Override
    public List<Aluno> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Aluno> alunos = null;

        try {
            alunos = em.createQuery ("from Aluno").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return alunos;    }

    @Override
    public Aluno remove(int id) {
        EntityManager em = new Conection().getEntityManager ();
        Aluno aluno = null;

        try {
            aluno = em.find (Aluno.class, id);
            em.getTransaction ().begin ();
            em.remove (aluno);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return aluno;    }
}
