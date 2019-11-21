package projeto_pbd.com.br.util;

public class SqlUtil {

    private SqlUtil(){

    }

    public static final String BUSCAR_USUARIO_POR_NOME = "select u from Usuario u where u.nome like :nome";

    public static final String BUSCAR_USUARIO_LOGIN_SENHA = "select u from Usuario u where u.email = :email and u.senha = :senha";

    public static final String BUSCAR_ALUNO_POR_NOME = "select a from Aluno a where a.nome like :nome";

    public static final String BUSCAR_CURRICULO_POR_NOME = "select c from Curriculo c where c.nome = :nome";

    public static final String BUSCAR_ACOMPANHAMNETO_POR_ID_ALUNO = "select a from AcompanhamentoPedagogico " +
            "a where a.aluno.id = :id";

    public static final String BUSCAR_DISCIPLINAS_DO_CURRICULO =  "select d from Disciplina d where " +
            "d.curriculo.nome = :nome";

    public static final String BUSCAR_DISCIPLINAS_POR_NOME =  "select d from Disciplina d where d.nome like :nome";

    public static final String BUSCAR_DISCIPLINAS_POR_ID_CURRICULO =  "select d from Disciplina d where d.curriculo.id = :curriculo ";

}
