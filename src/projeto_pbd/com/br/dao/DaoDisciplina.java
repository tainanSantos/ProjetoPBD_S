package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.modell.Usuario;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
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
    public Disciplina findById(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Disciplina disciplina = null;

        try {
            disciplina = em.find (Disciplina.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return disciplina;
    }

    @Override
    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo) {
        EntityManager em = new Conection().getEntityManager ();
        List<Disciplina> disciplinaList = null;
        try {
            TypedQuery<Disciplina> query = em.createQuery(SqlUtil.BUSCAR_DISCIPLINAS_POR_ID_CURRICULO, Disciplina.class);
            query.setParameter("curriculo", idCurriculo);
            disciplinaList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return disciplinaList;    }


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
    public List<Disciplina> findAllNome(String nomeDisciplina) {
        EntityManager em = new Conection().getEntityManager ();
        List<Disciplina> disciplinaList = null;
        try {
//            String pesquisarDisciplinaNome = "select d from Disciplina d where d.nome like :nome";
            TypedQuery<Disciplina> query = em.createQuery(SqlUtil.BUSCAR_DISCIPLINAS_POR_NOME, Disciplina.class);
            query.setParameter("nome", "%"+nomeDisciplina+"%");
            disciplinaList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return disciplinaList;
    }

    @Override
    public List<Disciplina> findAllNomeCurriculo(String nomeCurriculo) {
        EntityManager em = new Conection().getEntityManager ();
        List<Disciplina> disciplinaList = null;
        try {
            TypedQuery<Disciplina> query = em.createQuery(SqlUtil.BUSCAR_DISCIPLINAS_DO_CURRICULO, Disciplina.class);
            query.setParameter("nome", nomeCurriculo);
            disciplinaList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return disciplinaList;
    }


    @Override
    public Disciplina remove(Integer id) {
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


    public static void main(String[] args) {

        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Norfologia");
        disciplina.setCargaHoaria(60);

        DaoDisciplina daoDisciplina = new DaoDisciplina();
        disciplina = daoDisciplina.save(disciplina);
        System.out.println(disciplina.getNome());
        System.out.println(disciplina.getCargaHoaria());
    }

}
