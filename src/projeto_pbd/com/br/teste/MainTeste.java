package projeto_pbd.com.br.teste;

import projeto_pbd.com.br.dao.GenericDao;
import projeto_pbd.com.br.modell.Usuario;


public class MainTeste {

    public static void main(String[] args) {


//        FuncionarioTeste funcionarioTeste = new FuncionarioTeste ();
//        funcionarioTeste.setCpf ("111.333.222-55");
//        funcionarioTeste.setNome ("Tainan Santos Silva");


////        String pass = DigestUtils.md5Hex ("123");
////        usuarioSoPraTeste.setSenha (pass);


        GenericDao genericDao = new GenericDao ();

//        genericDao.persit (funcionarioTeste);


        Usuario usuario = new Usuario ();

        usuario.setSenha ("123456");
        usuario.setCpf ("123456");
        usuario.setNome ("Tainan");
        usuario.setDataNascimento ("20101995");
        usuario.setTipoDeAcesso ("ADM");

        genericDao.persit (usuario);

    }
}