package projeto_pbd.com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {


    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory ("tainan");
    private EntityManager em;


    public void persit(Object o){

        try {
            this.em = this.emf.createEntityManager ();
            em.getTransaction ().begin ();

            //REGRAD DE NEGÓCIO
            //Ver qual tipo de objeto está sendo persistdo o banco antes de salvalo.

            em.persist (o);
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
    }

}
