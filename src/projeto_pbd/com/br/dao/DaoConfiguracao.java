package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Configuracao;
import projeto_pbd.com.br.sqlConnectionFactory.Conection;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoConfiguracao implements  IDaoConfiguracao{


    @Override
    public Configuracao saveConfiguracao(Configuracao configuracao) {
        EntityManager em = new Conection().getEntityManager ();

        try {
            em.getTransaction ().begin ();

            if(configuracao.getId () == null){ // inserir
                em.persist (configuracao);
            }else { // atualizar
                em.merge (configuracao);
            }
            em.getTransaction ( ).commit ();  // comando de salvar
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return configuracao;
    }

    @Override
    public Configuracao findByIdConfiguracao(Integer id) {
        EntityManager em = new Conection().getEntityManager ();

        Configuracao configuracao = null;

        try {
            configuracao = em.find (Configuracao.class,id);
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return configuracao;    }



    @Override
    public List<Configuracao> findAllConfiguracao() {
        EntityManager em = new Conection().getEntityManager ();
        List<Configuracao> configuracaos = null;

        try {
            configuracaos = em.createQuery ("from Configuracao").getResultList ();
        }catch (Exception e ){
            em.getTransaction ().rollback ();
        }finally {
            em.close (); // fecha conexão
        }
        return configuracaos;
    }

    @Override
    public Configuracao removeConfiguracao(Integer id) {
        return null;
    }
}
