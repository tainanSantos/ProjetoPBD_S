package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.DisciplinaNotasView;
import projeto_pbd.com.br.modell.Nota;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoNotas implements IDaoNotas {

    @Override
    public Nota saveNota(Nota notaDisciplina) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(notaDisciplina.getId () == null){ // inserir
                em.persist (notaDisciplina);
            }else { // atualizar
                System.out.println("vai ter que atualizar");
                System.out.println("vai ter que atualizar");
                System.out.println("vai ter que atualizar");
                System.out.println("vai ter que atualizar");
                System.out.println("vai ter que atualizar");
                System.out.println("vai ter que atualizar");
                em.merge (notaDisciplina);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return notaDisciplina;
    }




    @Override
    public Nota findByIdNota(Integer id) {
        return null;
    }



    @Override
    public Nota findByIdNotaDisciplina(Integer idDisciplina) {
        EntityManager em = new Conection().getEntityManager ();

        Nota nota = null;

        try {
            TypedQuery<Nota> query = em.createQuery (SqlUtil.BUSCAR_DOTA_POR_ID_DISCIPLINA, Nota.class);
            query.setParameter("disciplina", idDisciplina);
            nota = query.getSingleResult();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return nota;
    }



    @Override
    public List<DisciplinaNotasView> findAllNotas(Integer idCurriculo) {
        // IMPLEMNTAR ESSE MÉTODO PARA EU BUSCAR SÓ PELAS NOTAS DO ALUNO DAQUELAS DISCIPLINAS
        // IMPLEMNTAR ESSE MÉTODO PARA EU BUSCAR SÓ PELAS NOTAS DO ALUNO DAQUELAS DISCIPLINAS
        // OU PELO ID DO CURRICULO
        EntityManager em = new Conection().getEntityManager ();
        List<DisciplinaNotasView> disciplinaNotasViews = null;

        try {
            TypedQuery<DisciplinaNotasView> typedQuery = em.createQuery(SqlUtil.BUSCAR_NOTA_POR_ID_CURRICULO, DisciplinaNotasView.class);
            typedQuery.setParameter("curriculo_id", idCurriculo);
            disciplinaNotasViews = typedQuery.getResultList();
        }catch (Exception e ){

        }finally {
            em.close (); // fecha conexão
        }

        return disciplinaNotasViews;
    }

    @Override
    public Nota removeNota(Integer id) {
        return null;
    }


    public static void main(String[] args) {

        DaoNotas daoNotas = new DaoNotas();

        System.out.println(daoNotas.findAllNotas(20));
    }

}
