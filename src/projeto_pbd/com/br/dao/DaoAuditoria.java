package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.AuditoriaUsuarios;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoAuditoria implements  IDaoAuditoria {

    @Override
    public List<AuditoriaUsuarios> findAllAuditoriasUser() {
        EntityManager em = new Conection().getEntityManager ();
        List<AuditoriaUsuarios> auditoriaUsuarios = null;

        try {
            auditoriaUsuarios = em.createQuery ("from AuditoriaUsuarios").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return auditoriaUsuarios;
    }

}
