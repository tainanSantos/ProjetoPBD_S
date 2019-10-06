package projeto_pbd.com.br.sqlConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("Tainan");

//    para que não seja possível dar new nessa class
    private  ConnectionFactory(){
    }

    public static EntityManager getConnectionFactory(){
        return entityManagerFactory.createEntityManager ();
    }

}
