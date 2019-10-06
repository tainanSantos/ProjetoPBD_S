package projeto_pbd.com.br.modell;


import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private Date dataNascimento;
    private String naturalidade;
    private Endereco endereco;




}
