package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Telefone;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoTelefone implements IDaoTelefone {


    @Override
    public Telefone save(Telefone telefone) {

        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(telefone.getId () == 0){ // inserir
                em.persist (telefone);
            }else { // atualizar
                em.merge (telefone);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return telefone;
    }


    @Override
    public Telefone findById(int id) {

        EntityManager em = new Conection().getEntityManager ();

        Telefone telefone = null;

        try {
            telefone = em.find (Telefone.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return telefone;
    }


    @Override
    public List<Telefone> findAll() {

        EntityManager em = new Conection().getEntityManager ();
        List<Telefone> telefones = null;

        try {
            telefones = em.createQuery ("from Telefone").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        return telefones;
    }

    @Override
    public Telefone remove(int id) {

        EntityManager em = new Conection().getEntityManager ();
        Telefone telefone = null;

        try {
            telefone = em.find (Telefone.class, id);
            em.getTransaction ().begin ();
            em.remove (telefone);
            em.getTransaction ().commit ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return telefone;
    }


}
