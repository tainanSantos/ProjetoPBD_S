package projeto_pbd.com.br.teste;

import org.apache.commons.codec.digest.DigestUtils;
import projeto_pbd.com.br.modell.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTeste {

    public static void main(String[] args) {


//        FuncionarioTeste funcionarioTeste = new FuncionarioTeste ();
//        funcionarioTeste.setCpf ("111.333.222-55");
//        funcionarioTeste.setNome ("Tainan Santos Silva");


        String pass = DigestUtils.md5Hex ("123");
//        usuarioSoPraTeste.setSenha (pass);


        EntityManagerFactory enf = Persistence.createEntityManagerFactory ("Tainan");
        EntityManager em = enf.createEntityManager ();

      
        em.getTransaction ().begin ();
//        em.persist (funcionarioTeste);
        em.getTransaction ().commit ();

        em.close ();
        enf.close ();

    }
}
