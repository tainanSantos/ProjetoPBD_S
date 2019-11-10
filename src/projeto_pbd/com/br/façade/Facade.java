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
    private IBusinessTurma businessTurma;
    private IBusinessResponsavel businessResponsavel;

    private Facade() {
        this.businessAluno = new BusinessAluno ();
        this.businessCurriculo = new BusinessCurriculo ();
        this.businessDisciplina = new BusinessDisciplina ();
        this.businessProfessor = new BusinessProfessor ();
        this.businessPedagogo = new BusinessPedagogo ();
        this.businessUsuario = new BusinessUsuario ();
        this.businessTelefone = new BusinessTelefone();
        this.businessTurma = new BusinessTurma();
        this.businessResponsavel = new BusinessResponsavel();

    }


    //ALUNO
    @Override
    public Aluno saveAluno(Aluno aluno) {
        return this.businessAluno.saveAluno(aluno);
    }

    @Override
    public Aluno findByIdAluno(Integer id) {
        return this.businessAluno.findByIdAluno(id);
    }

    @Override
    public List<Aluno> findAllAluno() {
        return this.businessAluno.findAllAluno();
    }

    @Override
    public Aluno removeAluno(Integer id) {
        return this.businessAluno.removeAluno(id);
    }



    //CURRICULO
    @Override
    public Curriculo saveCurriculo(Curriculo curriculo) {
        return this.businessCurriculo.saveCurriculo(curriculo);
    }

    @Override
    public Curriculo findByIdCurriculo(Integer id) {
        return this.businessCurriculo.findByIdCurriculo(id);
    }

    @Override
    public List<Curriculo> findAllCurriculo() {
        return this.businessCurriculo.findAllCurriculo();
    }

    @Override
    public Curriculo removeCurriculo(Integer id) {
        return this.businessCurriculo.removeCurriculo(id);
    }



    //DISCIPLINA
    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        return this.businessDisciplina.saveDisciplina(disciplina);
    }

    @Override
    public Disciplina findByIdDisciplina(Integer id) {
        return this.businessDisciplina.findByIdDisciplina(id);
    }

    @Override
    public List<Disciplina> findAllDisciplina() {
        return this.businessDisciplina.findAllDisciplina();
    }

    @Override
    public Disciplina removeDisciplina(Integer id) {
        return this.businessDisciplina.removeDisciplina(id);
    }



    //PEDAGOGO
    @Override
    public Pedagogo savePedagogo(Pedagogo pedagogo) {
        return this.businessPedagogo.savePedagogo(pedagogo);
    }

    @Override
    public Pedagogo findByIdPedagogo(Integer id) {
        return this.businessPedagogo.findByIdPedagogo(id);
    }

    @Override
    public List<Pedagogo> findAllPedagogo() {
        return this.businessPedagogo.findAllPedagogo();
    }

    @Override
    public List<Pedagogo> findAllStringPedagogo(String nome) {
        return this.businessPedagogo.findAllStringPedagogo(nome);
    }

    @Override
    public Pedagogo removePedagogo(Integer id) {
        return this.businessPedagogo.removePedagogo(id);
    }


    //PROFESSOR
    @Override
    public Professor saveProfessor(Professor professor) {
        return this.businessProfessor.saveProfessor(professor);
    }

    @Override
    public Professor findByIdProfessor(Integer id) {
        return this.businessProfessor.findByIdProfessor (id);
    }

    @Override
    public List<Professor> findAllProfessor() {
        return this.businessProfessor.findAllProfessor();
    }

    @Override
    public Professor removeProfessor(Integer id) {
        return this.businessProfessor.removeProfessor(id);
    }



    //USUARIO
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        System.out.println("passei aqui");
        return this.businessUsuario.saveUsuario(usuario);
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return this.businessUsuario.findByIdUsuario(id);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return this.businessUsuario.findAllUsuario();
    }

    @Override
    public Usuario removeUsuario(Integer id) {
        return this.businessUsuario.removeUsuario(id);
    }


    //TELEFONE
    @Override
    public Telefone saveTelefone(Telefone telefone) {
        return this.businessTelefone.saveTelefone(telefone);
    }

    @Override
    public Telefone findByIdTelefone(Integer id) {
        return this.businessTelefone.findByIdTelefone(id);
    }

    @Override
    public List<Telefone> findAllTelefone() {
        return this.businessTelefone.findAllTelefone();
    }

    @Override
    public List<Telefone> findAllIdTelefone(Integer idPessoa) {
        return this.businessTelefone.findAllIdTelefone(idPessoa);
    }

    @Override
    public Telefone removeTelefone(Integer id) {
        return this.businessTelefone.removeTelefone(id);
    }



//    TURMA
    @Override
    public Turma saveTurma(Turma turma) {
        return this.businessTurma.saveTurma(turma);
    }

    @Override
    public Turma findByIdTurma(Integer id) {
        return this.businessTurma.findByIdTurma(id);
    }

    @Override
    public List<Turma> findAllTurma() {
        return this.businessTurma.findAllTurma();
    }

    @Override
    public Turma removeTurma(Integer id) {
        return this.businessTurma.removeTurma(id);
    }


    //RESPONSÁVEL
    @Override
    public Responsavel saveResponsavel(Responsavel responsavel) {
        return this.businessResponsavel.saveResponsavel(responsavel);
    }

    @Override
    public Responsavel findByIdResponsavel(Integer id) {
        return this.businessResponsavel.removeResponsavel(id);
    }

    @Override
    public List<Responsavel> findAllResponsavel() {
        return this.businessResponsavel.findAllResponsavel();
    }

    @Override
    public Responsavel removeResponsavel(Integer id) {
        return this.businessResponsavel.removeResponsavel(id);
    }
}
