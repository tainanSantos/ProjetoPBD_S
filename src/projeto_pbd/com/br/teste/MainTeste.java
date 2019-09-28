package projeto_pbd.com.br.teste;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTeste {

    public static void main(String[] args) {

        UsuarioSoPraTeste usuarioSoPraTeste = new UsuarioSoPraTeste ();
        usuarioSoPraTeste.setLogin ("santodos_dos_santos_2019@gmail.com");

        String pass = DigestUtils.md5Hex ("123");
        usuarioSoPraTeste.setSenha (pass);

        EntityManagerFactory enf = Persistence.createEntityManagerFactory ("Tainan");
        EntityManager em = enf.createEntityManager ();

        em.getTransaction ().begin ();
        em.persist (usuarioSoPraTeste);
        em.getTransaction ().commit ();

        em.close ();
        enf.close ();

    }
}
