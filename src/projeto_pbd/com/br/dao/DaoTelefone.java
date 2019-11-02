package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DaoTelefone implements IDaoTelefone {


    @Override
    public Telefone save(Telefone telefone) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(telefone.getId () == null){ // inserir
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

        Telefone telefone= null;

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
    public List<Telefone> findAllId(int idPessoa) {
        EntityManager em = new Conection().getEntityManager ();
        List<Telefone> telefones = null;

        try {
            System.out.println("1A");
            String consulta = "select t from Telefone t join t.pessoa_id = :pessoa_id";
            System.out.println("2A");
            TypedQuery<Telefone> query = em.createQuery(consulta, Telefone.class);
            System.out.println("3A");
            query.setParameter("pessoa_id",idPessoa);
            System.out.println("4A");
            telefones = query.getResultList();
            System.out.println("5A");

        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }

        if(telefones == null) System.out.println("Telefones nullos");
        System.out.println("_______________________________________________");
        for (Telefone telefone : telefones){
            System.out.println(telefone.getNumero());
        }
        System.out.println("_______________________________________________");
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
