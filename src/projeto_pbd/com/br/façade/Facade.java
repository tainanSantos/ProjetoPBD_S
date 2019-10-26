package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.*;
import projeto_pbd.com.br.modell.*;

import java.util.List;

public class Facade implements IFacade {

    public static  Facade instance;

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    private IBusinessDisciplina businessDisciplina;
    private IBusinessCurriculo businessCurriculo;
    private IBusinessAluno businessAluno;
    private IBusinessPedagogo businessPedagogo;
    private IBusinessProfessor businessProfessor;
    private IBusinessUsuario businessUsuario;


    private Facade() {
        this.businessAluno = new BusinessAluno ();
        this.businessCurriculo = new BusinessCurriculo ();
        this.businessDisciplina = new BusinessDisciplina ();
        this.businessProfessor = new BusinessProfessor ();
        this.businessPedagogo = new BusinessPedagogo ();
        this.businessUsuario = new BusinessUsuario ();

    }


    //ALUNO
    @Override
    public Aluno saveAluno(Aluno aluno) {
        return this.businessAluno.save (aluno);
    }

    @Override
    public Aluno findByIdAluno(int id) {
        return this.businessAluno.findById (id);
    }

    @Override
    public List<Aluno> findAllAluno() {
        return this.businessAluno.findAll ();
    }

    @Override
    public Aluno removeAluno(int id) {
        return this.businessAluno.remove (id);
    }



    //CURRICULO
    @Override
    public Curriculo saveCurriculo(Curriculo curriculo) {
        return this.businessCurriculo.save (curriculo);
    }

    @Override
    public Curriculo findByIdCurriculo(int id) {
        return this.businessCurriculo.findById (id);
    }

    @Override
    public List<Curriculo> findAllCurriculo() {
        return this.businessCurriculo.findAll ();
    }

    @Override
    public Curriculo removeCurriculo(int id) {
        return this.businessCurriculo.remove (id);
    }



    //DISCIPLINA
    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        return this.businessDisciplina.save (disciplina);
    }

    @Override
    public Disciplina findByIdDisciplina(int id) {
        return this.businessDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAllDisciplina() {
        return this.businessDisciplina.findAll ();
    }

    @Override
    public Disciplina removeDisciplina(int id) {
        return this.businessDisciplina.remove (id);
    }



    //PEDAGOGO
    @Override
    public Pedagogo savePedagogo(Pedagogo pedagogo) {
        return this.businessPedagogo.save (pedagogo);
    }

    @Override
    public Pedagogo findByIdPedagogo(int id) {
        return this.businessPedagogo.findById (id);
    }

    @Override
    public List<Pedagogo> findAllPedagogo() {
        return this.businessPedagogo.findAll ();
    }

    @Override
    public Pedagogo removePedagogo(int id) {
        return this.businessPedagogo.remove (id);
    }


    //PROFESSOR
    @Override
    public Professor saveProfessor(Professor professor) {
        return this.businessProfessor.save (professor);
    }

    @Override
    public Professor findByIdProfessor(int id) {
        return this.businessProfessor.findById (id);
    }

    @Override
    public List<Professor> findAllProfessor() {
        return this.businessProfessor.findAll ();
    }

    @Override
    public Professor removeProfessor(int id) {
        return this.businessProfessor.remove (id);
    }



    //USUARIO
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return this.businessUsuario.save (usuario);
    }

    @Override
    public Usuario findByIdUsuario(int id) {
        return this.businessUsuario.findById (id);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return this.businessUsuario.findAll ();
    }

    @Override
    public Usuario removeUsuario(int id) {
        return this.businessUsuario.remove (id);
    }
}
