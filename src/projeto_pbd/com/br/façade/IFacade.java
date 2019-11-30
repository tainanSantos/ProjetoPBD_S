package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.*;

import java.util.List;

public interface IFacade {

    //Aluno
    public Aluno saveAluno(Aluno aluno );
    public Aluno findByIdAluno(Integer id);
    public List<Aluno> findAllAluno();
    public List<Aluno> findAllNomeAluno(String nomeAluno);
    public List<Aluno> findAllAlunosIdTurma(Integer idTurma);
    public Aluno removeAluno(Integer id);


    //Curriculo
    public Curriculo saveCurriculo(Curriculo curriculo );
    public Curriculo findByIdCurriculo(Integer id);
    public List<Curriculo> findAllCurriculo();
    public Curriculo removeCurriculo(Integer id);


    //Disciplina
    public Disciplina saveDisciplina(Disciplina disciplina );
    public Disciplina findByIdDisciplina(Integer id);
    public List<Disciplina> findAllDisciplina();
    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo);
    public List<Disciplina> findAllNomeDisciplina(String nomeDisciplina);
    public List<Disciplina> findAllNomeCurriculoDisiplina(String nomeCurriculo);
    public Disciplina removeDisciplina(Integer id);


    //Acompanhamento
    public AcompanhamentoPedagogico saveAcompanhamentoPedagogico(AcompanhamentoPedagogico acompanhamentoPedagogico);
    public AcompanhamentoPedagogico findByIdAcompanhamentoPedagogico(Integer id);
    public List<AcompanhamentoPedagogico> findByIdAlunoAcompanhamentoPedagogico(Integer idAluno);
    public List<AcompanhamentoPedagogico> findAllAcompanhamentoPedagogicoList();
    public List<AcompanhamentoPedagogico> findAllStringAcompanhamentoPedagogicos(String nome);
    public AcompanhamentoPedagogico removeAcompanhamentoPedagogico(Integer id);


    //Professor
    public Professor saveProfessor(Professor professor);
    public Professor findByIdProfessor(Integer id);
    public List<Professor> findAllProfessor();
    public Professor removeProfessor(Integer id);


    //Usuario
    public Usuario saveUsuario(Usuario usuario);
    public Usuario findByIdUsuario(Integer id);
    public List<Usuarioview> findAllUsuario();
    public List<Usuarioview> findAllUsuarioNome(String nome);
    public Usuario removeUsuario(Integer id);
    public  Usuarioview validarLoginSenha(String email, String senha);



    //Telefone
    public Telefone saveTelefone(Telefone telefone);
    public Telefone findByIdTelefone(Integer id);
    public List<Telefone> findAllTelefone();
    public List<Telefone> findAllIdTelefone(Integer idPessoa);
    public Telefone removeTelefone(Integer id);


//    Turma
    public Turma saveTurma(Turma turma);
    public Turma findByIdTurma(Integer id);
    public List<Turma> findAllTurma();
    public Turma removeTurma(Integer id);


    //Responsavel
    public Responsavel saveResponsavel(Responsavel responsavel );
    public Responsavel findByIdResponsavel(Integer id);
    public List<Responsavel> findAllResponsavel();
    public Responsavel removeResponsavel(Integer id);


    //Notas
    public Nota saveNota(Nota notaDisciplina );
    public Nota findByIdNota(Integer id);
    public Nota findByIdNotaDisciplina(Integer idDisciplina);
    public List<DisciplinaNotasView> findAllNotas(Integer idAluno);
    public Nota removeNota(Integer id);

    //Configuração
    public Configuracao saveConfiguracao(Configuracao configuracao);
    public Configuracao findByIdConfiguracao(Integer id);
    public List<Configuracao> findAllConfiguracao();
    public Configuracao removeConfiguracao(Integer id);
}
