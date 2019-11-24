package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoAluno implements IDaoAluno {


    @Override
    public Aluno save(Aluno aluno) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(aluno.getId () == null){ // inserir
                em.persist(aluno.getEndereco());
                em.persist (aluno);
            }else { // atualizar
                em.merge(aluno.getEndereco());
                em.merge (aluno);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return aluno;
    }


    @Override
    public Aluno findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Aluno aluno= null;

        try {
            aluno = em.find (Aluno.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return aluno;
    }


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
        return alunos;
    }

    @Override
    public List<Aluno> findAllNome(String nome) {
        EntityManager em = new Conection().getEntityManager ();
        List<Aluno> alunoList = null;
        try {
            TypedQuery<Aluno> query = em.createQuery(SqlUtil.BUSCAR_ALUNO_POR_NOME, Aluno.class);
            query.setParameter("nome", "%"+nome+"%");
            alunoList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return alunoList;
    }

    @Override
    public List<Aluno> findAllAlunosIdTurma(Integer idTurma) {
        EntityManager em = new Conection().getEntityManager ();
        List<Aluno> alunoList = null;
        try {
            TypedQuery<Aluno> query = em.createQuery(SqlUtil.BUSCAR_ALUNOS_POR_ID_TURMA, Aluno.class);
            query.setParameter("id", idTurma);
            alunoList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return alunoList;
    }


    @Override
    public Aluno remove(Integer id) {
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
        return aluno;
    }

}
