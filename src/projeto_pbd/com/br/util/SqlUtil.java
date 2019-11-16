package projeto_pbd.com.br.util;

public class SqlUtil {

    private SqlUtil(){

    }

    public static final String BUSCAR_USUARIO_POR_NOME = "select u from Usuario u where u.nome like :nome";
    public static final String BUSCAR_CURRICULO_POR_NOME = "select c from Curriculo c where c.nome = :nome";
    public static final String BUSCAR_DISCIPLINAS_DO_CURRICULO =  "select d from Disciplina d where " +
            "d.curriculo.nome = :nome";
    public static final String BUSCAR_DISCIPLINAS_POR_NOME =  "select d from Disciplina d where d.nome like :nome";

}
