package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.*;

import java.util.List;

public interface IFacade {

    //Aluno
    public Aluno saveAluno(Aluno aluno );

    public Aluno findByIdAluno(Integer id);

    public List<Aluno> findAllAluno();

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

    public Disciplina removeDisciplina(Integer id);


    //Pedagogo
    public Pedagogo savePedagogo(Pedagogo pedagogo);

    public Pedagogo findByIdPedagogo(Integer id);

    public List<Pedagogo> findAllPedagogo();

    public List<Pedagogo> findAllStringPedagogo(String nome);

    public Pedagogo removePedagogo(Integer id);


    //Professor
    public Professor saveProfessor(Professor professor);

    public Professor findByIdProfessor(Integer id);

    public List<Professor> findAllProfessor();

    public Professor removeProfessor(Integer id);


    //Usuario
    public Usuario saveUsuario(Usuario usuario);

    public Usuario findByIdUsuario(Integer id);

    public List<Usuario> findAllUsuario();

    public Usuario removeUsuario(Integer id);


    //Telefone
    public Telefone saveTelefone(Telefone telefone);

    public Telefone findByIdTelefone(Integer id);

    public List<Telefone> findAllTelefone();

    public List<Telefone> findAllIdTelefone(Integer idPessoa);

    public Telefone removeTelefone(Integer id);


    //Turma
//    public Turma saveTurma(Turma turma);
//
//    public Turma findByIdTurma(Integer id);
//
//    public List<Turma> findAllTurma();
//
//    public Turma removeTurma(Integer id);


    //Responsavel

    public Responsavel saveResponsavel(Responsavel responsavel );

    public Responsavel findByIdResponsavel(Integer id);

    public List<Responsavel> findAllResponsavel();

    public Responsavel removeResponsavel(Integer id);
}
