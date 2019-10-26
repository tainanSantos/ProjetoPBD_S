package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.*;

import java.util.List;

public interface IFacade {

    //Aluno
    public Aluno saveAluno(Aluno aluno );

    public Aluno findByIdAluno(int id);

    public List<Aluno> findAllAluno();

    public Aluno removeAluno(int id);


    //Curriculo
    public Curriculo saveCurriculo(Curriculo curriculo );

    public Curriculo findByIdCurriculo(int id);

    public List<Curriculo> findAllCurriculo();

    public Curriculo removeCurriculo(int id);


    //Disciplina
    public Disciplina saveDisciplina(Disciplina disciplina );

    public Disciplina findByIdDisciplina(int id);

    public List<Disciplina> findAllDisciplina();

    public Disciplina removeDisciplina(int id);


    //Pedagogo
    public Pedagogo savePedagogo(Pedagogo pedagogo);

    public Pedagogo findByIdPedagogo(int id);

    public List<Pedagogo> findAllPedagogo();

    public Pedagogo removePedagogo(int id);


    //Professor
    public Professor saveProfessor(Professor professor);

    public Professor findByIdProfessor(int id);

    public List<Professor> findAllProfessor();

    public Professor removeProfessor(int id);


    //Usuario
    public Usuario saveUsuario(Usuario usuario);

    public Usuario findByIdUsuario(int id);

    public List<Usuario> findAllUsuario();

    public Usuario removeUsuario(int id);
}
