package projeto_pbd.com.br.sqlConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Conection {

    private EntityManagerFactory enf;


    public Conection(){

    }

    public EntityManager getEntityManager() throws PersistenceException {
        this.enf = Persistence.createEntityManagerFactory ("tainan");
        return this.enf.createEntityManager ();
    }


}
