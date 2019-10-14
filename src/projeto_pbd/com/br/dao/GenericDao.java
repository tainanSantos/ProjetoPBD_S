package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Pessoa;
import projeto_pbd.com.br.teste.PessoaTeste;
import projeto_pbd.com.br.teste.TelefonesTeste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {


    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory ("tainan");
    private EntityManager em;


    public void persit(Object o){
        PessoaTeste pessoaTeste = null;

        try {
            this.em = this.emf.createEntityManager ();
            em.getTransaction ().begin ();


            pessoaTeste = (PessoaTeste) Object.class.cast (o);
            em.persist (pessoaTeste.getEnderecoTeste ());
            em.persist (pessoaTeste);
            for(TelefonesTeste telefonesTeste: pessoaTeste.getTelefones ()){
                em.persist (telefonesTeste);
            }


            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
    }

}
