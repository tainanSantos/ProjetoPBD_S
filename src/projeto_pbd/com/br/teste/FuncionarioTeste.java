package projeto_pbd.com.br.teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncionarioTeste extends PessoaTeste{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public FuncionarioTeste(String nome, String cpf) {
        super (nome, cpf);
    }

    public FuncionarioTeste() {
    }

}
