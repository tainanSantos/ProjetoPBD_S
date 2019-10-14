package projeto_pbd.com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conection {

    private EntityManagerFactory enf;


    public Conection(){
        this.enf = Persistence.createEntityManagerFactory ("tainan");
    }

    public EntityManager getEntityManager(){
        return this.enf.createEntityManager ();
    }


}
