package projeto_pbd.com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conection {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory ("tainan");

    public static EntityManager getEntityManager(){
        return enf.createEntityManager ();
    }

}
