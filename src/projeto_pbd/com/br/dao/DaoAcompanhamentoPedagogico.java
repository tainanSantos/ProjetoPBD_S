package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.façade.Facade;
import projeto_pbd.com.br.modell.AcompanhamentoPedagogico;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;
import projeto_pbd.com.br.util.SqlUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoAcompanhamentoPedagogico implements IDaoAcompanhamentoPedagogico {



    @Override
    public AcompanhamentoPedagogico saveAcompanhamentoPedagogico(AcompanhamentoPedagogico acompanhamentoPedagogico) {
        EntityManager em = new Conection().getEntityManager ();
        try {
            em.getTransaction ().begin ();
            if(acompanhamentoPedagogico.getId () == null){ // inserir
                em.persist (acompanhamentoPedagogico);
            }else { // atualizar
                em.merge (acompanhamentoPedagogico);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogico;
    }



    @Override
    public AcompanhamentoPedagogico findByIdAcompanhamentoPedagogico(Integer id) {

        EntityManager em = new Conection().getEntityManager ();

        AcompanhamentoPedagogico acompanhamentoPedagogico = null;

        try {
            acompanhamentoPedagogico = em.find (AcompanhamentoPedagogico.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogico;
    }



    @Override
    public List<AcompanhamentoPedagogico> findByIdAlunoAcompanhamentoPedagogico(Integer idAluno) {
        EntityManager em = new Conection().getEntityManager ();
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicoList = null;
        try {
            TypedQuery<AcompanhamentoPedagogico> query = em.createQuery(
                    SqlUtil.BUSCAR_ACOMPANHAMNETO_POR_ID_ALUNO, AcompanhamentoPedagogico.class);
            query.setParameter("id", idAluno);
            acompanhamentoPedagogicoList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogicoList;
    }

    @Override
    public List<AcompanhamentoPedagogico> findByIdUsuarioPedagogoAcompanhamentoPedagogico(Integer idPedagogoLogado) {
        System.out.println("Passamos aqui");

        EntityManager em = new Conection().getEntityManager ();
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicoList = null;
        try {
            TypedQuery<AcompanhamentoPedagogico> query = em.createQuery(
                    SqlUtil.BUSCAR_ACOMPANHAMNETO_POR_ID_USUARIO_LOGADO, AcompanhamentoPedagogico.class);
            query.setParameter("pessoa_id", idPedagogoLogado);
            acompanhamentoPedagogicoList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }
        finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogicoList;
    }


    @Override
    public List<AcompanhamentoPedagogico> findAllAcompanhamentoPedagogicoList() {
        EntityManager em = new Conection().getEntityManager ();
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicos = null;
        try {
            acompanhamentoPedagogicos = em.createQuery ("from AcompanhamentoPedagogico").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogicos;
    }


    @Override
    public List<AcompanhamentoPedagogico> findAllStringAcompanhamentoPedagogicos(String nome) {
        EntityManager em = new Conection().getEntityManager ();
        List<AcompanhamentoPedagogico> acompanhamentoPedagogicoList = null;

        try {
            acompanhamentoPedagogicoList = em.createQuery ("from AcompanhamentoPedagogico").getResultList ();

            String consulta = "select p from AcompanhamentoPedagogico p where p.nome ="+nome;
            TypedQuery<AcompanhamentoPedagogico> query = em.createQuery(consulta, AcompanhamentoPedagogico.class);
            acompanhamentoPedagogicoList = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return acompanhamentoPedagogicoList;
    }


    @Override
    public AcompanhamentoPedagogico removeAcompanhamentoPedagogico(Integer id) {


        EntityManager em = new Conection().getEntityManager ();
        AcompanhamentoPedagogico acompanhamentoPedagogico = null;

        try {
            acompanhamentoPedagogico = em.find (AcompanhamentoPedagogico.class, id);
            em.getTransaction ().begin ();
            em.remove (acompanhamentoPedagogico);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return acompanhamentoPedagogico;
    }


    public static void main(String[] args) {
        DaoAcompanhamentoPedagogico daoAcompanhamentoPedagogico = new DaoAcompanhamentoPedagogico();
        System.out.println(daoAcompanhamentoPedagogico.findByIdUsuarioPedagogoAcompanhamentoPedagogico(
                Facade.getInstance().findAllUsuarioLogado().getPessoa_id()
        ));
    }

}
