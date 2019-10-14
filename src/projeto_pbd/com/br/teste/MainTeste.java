package projeto_pbd.com.br.teste;

import projeto_pbd.com.br.dao.GenericDao;
import projeto_pbd.com.br.modell.Telefone;
import projeto_pbd.com.br.modell.Usuario;

import java.util.ArrayList;


public class MainTeste {

    public static void main(String[] args) {

        EnderecoTeste enderecoTeste = new EnderecoTeste ();

        enderecoTeste.setNumeroCasa ("455");
        enderecoTeste.setRua ("Rua15");

        PessoaTeste pessoaTeste = new PessoaTeste ();

        pessoaTeste.setCpf ("1236544");
        pessoaTeste.setNome ("Tainan");
        pessoaTeste.setEnderecoTeste (enderecoTeste);

        TelefonesTeste telefonesTeste = new TelefonesTeste ();
        telefonesTeste.setNumerio ("4444444444");
        TelefonesTeste telefonesTeste2 = new TelefonesTeste ();
        telefonesTeste2.setNumerio ("5555555555");

        ArrayList<TelefonesTeste> telefones = new ArrayList<> ();
        telefones.add (telefonesTeste);
        telefones.add (telefonesTeste2);

        pessoaTeste.setTelefones (telefones);

        GenericDao genericDao = new GenericDao ();
        genericDao.persit (pessoaTeste);

    }
}