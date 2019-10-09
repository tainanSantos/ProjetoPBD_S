package projeto_pbd.com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory ("Tainan");



    public static EntityManager getConection(){
        return  enf.createEntityManager ();
    }
}
