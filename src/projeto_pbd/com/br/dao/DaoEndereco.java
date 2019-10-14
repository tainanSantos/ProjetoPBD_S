package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DaoEndereco implements IDaoEndereco{


    @Override
    public Endereco save(Endereco endereco) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("tainan");
        EntityManager em = emf.createEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(endereco.getId () == 0){ // inserir
                em.persist (endereco);
            }else { // atualizar
                em.merge (endereco);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return endereco;
    }


    @Override
    public Endereco findById(int id) {

        EntityManager em = new Conection().getEntityManager ();

        Endereco endereco = null;

        try {
            endereco = em.find (Endereco.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return endereco;
    }

    @Override
    public List<Endereco> findAll() {
        EntityManager em = new Conection().getEntityManager ();
        List<Endereco> enderecos = null;

        try {
            enderecos = em.createQuery ("from Endereco").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return enderecos;
    }



    @Override
    public Endereco remove(int id) {
        EntityManager em = new Conection().getEntityManager ();
        Endereco endereco = null;

        try {
            endereco = em.find (Endereco.class, id);
            em.getTransaction ().begin ();
            em.remove (endereco);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return endereco;    }
}
