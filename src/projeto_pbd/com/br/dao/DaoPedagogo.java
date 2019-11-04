package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Pedagogo;
import projeto_pbd.com.br.modell.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoPedagogo implements IDaoPedagogo {



    @Override
    public Pedagogo save(Pedagogo pedagogo) {

        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(pedagogo.getId () == null){ // inserir
                em.persist(pedagogo.getEndereco());
                em.persist (pedagogo);
            }else { // atualizar
                em.merge(pedagogo.getEndereco());
                em.merge (pedagogo);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return pedagogo;
    }

    @Override
    public Pedagogo findById(Integer id) {

        EntityManager em = new Conection().getEntityManager ();

        Pedagogo pedagogo = null;

        try {
            pedagogo = em.find (Pedagogo.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return pedagogo;
    }


    @Override
    public List<Pedagogo> findAll() {

        EntityManager em = new Conection().getEntityManager ();
        List<Pedagogo> pedagogos = null;

        try {
            pedagogos = em.createQuery ("from Pedagogo").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return pedagogos;
    }


    @Override
    public List<Pedagogo> findAllString(String nome) {
        EntityManager em = new Conection().getEntityManager ();
        List<Pedagogo> pedagogos = null;

        try {
            pedagogos = em.createQuery ("from Pedagogo").getResultList ();

            String consulta = "select p from Pedagogo p where p.nome ="+nome;
            TypedQuery<Pedagogo> query = em.createQuery(consulta, Pedagogo.class);
            pedagogos = query.getResultList();

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return pedagogos;
    }


    @Override
    public Pedagogo remove(Integer id) {
        EntityManager em = new Conection().getEntityManager ();
        Pedagogo pedagogo = null;

        try {
            pedagogo = em.find (Pedagogo.class, id);
            em.getTransaction ().begin ();
            em.remove (pedagogo);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return pedagogo;
    }
}
