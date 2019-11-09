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
    private IBusinessTelefone businessTelefone;
//    private IBusinessTurma businessTurma;
    private IBusinessResponsavel businessResponsavel;

    private Facade() {
        this.businessAluno = new BusinessAluno ();
        this.businessCurriculo = new BusinessCurriculo ();
        this.businessDisciplina = new BusinessDisciplina ();
        this.businessProfessor = new BusinessProfessor ();
        this.businessPedagogo = new BusinessPedagogo ();
        this.businessUsuario = new BusinessUsuario ();
        this.businessTelefone = new BusinessTelefone();
//        this.businessTurma = new BusinessTurma();
        this.businessResponsavel = new BusinessResponsavel();

    }


    //ALUNO
    @Override
    public Aluno saveAluno(Aluno aluno) {
        return this.businessAluno.save (aluno);
    }

    @Override
    public Aluno findByIdAluno(Integer id) {
        return this.businessAluno.findById (id);
    }

    @Override
    public List<Aluno> findAllAluno() {
        return this.businessAluno.findAll ();
    }

    @Override
    public Aluno removeAluno(Integer id) {
        return this.businessAluno.remove (id);
    }



    //CURRICULO
    @Override
    public Curriculo saveCurriculo(Curriculo curriculo) {
        return this.businessCurriculo.save (curriculo);
    }

    @Override
    public Curriculo findByIdCurriculo(Integer id) {
        return this.businessCurriculo.findById (id);
    }

    @Override
    public List<Curriculo> findAllCurriculo() {
        return this.businessCurriculo.findAll ();
    }

    @Override
    public Curriculo removeCurriculo(Integer id) {
        return this.businessCurriculo.remove (id);
    }



    //DISCIPLINA
    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        return this.businessDisciplina.save (disciplina);
    }

    @Override
    public Disciplina findByIdDisciplina(Integer id) {
        return this.businessDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAllDisciplina() {
        return this.businessDisciplina.findAll ();
    }

    @Override
    public Disciplina removeDisciplina(Integer id) {
        return this.businessDisciplina.remove (id);
    }



    //PEDAGOGO
    @Override
    public Pedagogo savePedagogo(Pedagogo pedagogo) {
        return this.businessPedagogo.save (pedagogo);
    }

    @Override
    public Pedagogo findByIdPedagogo(Integer id) {
        return this.businessPedagogo.findById (id);
    }

    @Override
    public List<Pedagogo> findAllPedagogo() {
        return this.businessPedagogo.findAll ();
    }

    @Override
    public List<Pedagogo> findAllStringPedagogo(String nome) {
        return this.businessPedagogo.findAllString(nome);
    }

    @Override
    public Pedagogo removePedagogo(Integer id) {
        return this.businessPedagogo.remove (id);
    }


    //PROFESSOR
    @Override
    public Professor saveProfessor(Professor professor) {
        return this.businessProfessor.save (professor);
    }

    @Override
    public Professor findByIdProfessor(Integer id) {
        return this.businessProfessor.findById (id);
    }

    @Override
    public List<Professor> findAllProfessor() {
        return this.businessProfessor.findAll ();
    }

    @Override
    public Professor removeProfessor(Integer id) {
        return this.businessProfessor.remove (id);
    }



    //USUARIO
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        System.out.println("passei aqui");
        return this.businessUsuario.save (usuario);
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return this.businessUsuario.findById (id);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return this.businessUsuario.findAll ();
    }

    @Override
    public Usuario removeUsuario(Integer id) {
        return this.businessUsuario.remove (id);
    }


    //TELEFONE
    @Override
    public Telefone saveTelefone(Telefone telefone) {
        return this.businessTelefone.save(telefone);
    }

    @Override
    public Telefone findByIdTelefone(Integer id) {
        return this.businessTelefone.findById(id);
    }

    @Override
    public List<Telefone> findAllTelefone() {
        return this.businessTelefone.findAll();
    }

    @Override
    public List<Telefone> findAllIdTelefone(Integer idPessoa) {
        return this.businessTelefone.findAllId(idPessoa);
    }

    @Override
    public Telefone removeTelefone(Integer id) {
        return this.businessTelefone.remove(id);
    }


//    TURMA
//    @Override
//    public Turma saveTurma(Turma turma) {
//        return this.businessTurma.save(turma);
//    }
//
//    @Override
//    public Turma findByIdTurma(Integer id) {
//        return this.businessTurma.findById(id);
//    }
//
//    @Override
//    public List<Turma> findAllTurma() {
//        return this.businessTurma.findAll();
//    }
//
//    @Override
//    public Turma removeTurma(Integer id) {
//        return this.businessTurma.remove(id);
//    }


    //RESPONSÁVEL
    @Override
    public Responsavel saveResponsavel(Responsavel responsavel) {
        return this.businessResponsavel.save(responsavel);
    }

    @Override
    public Responsavel findByIdResponsavel(Integer id) {
        return this.businessResponsavel.remove(id);
    }

    @Override
    public List<Responsavel> findAllResponsavel() {
        return this.businessResponsavel.findAll();
    }

    @Override
    public Responsavel removeResponsavel(Integer id) {
        return this.businessResponsavel.remove(id);
    }
}
