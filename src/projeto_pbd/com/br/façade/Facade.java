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
    private IBusinessAcompanhamentoPedagogico businessPedagogo;
    private IBusinessProfessor businessProfessor;
    private IBusinessUsuario businessUsuario;
    private IBusinessTelefone businessTelefone;
    private IBusinessTurma businessTurma;
    private IBusinessResponsavel businessResponsavel;
    private IBusinessAcompanhamentoPedagogico businessAcompanhamentoPedagogico;
    private IBusinessNotas businessNotas;
    private IBusinessConfiguracao businessConfiguracao;

    private Facade() {
        this.businessAluno = new BusinessAluno ();
        this.businessCurriculo = new BusinessCurriculo ();
        this.businessDisciplina = new BusinessDisciplina ();
        this.businessProfessor = new BusinessProfessor ();
        this.businessPedagogo = new BusinessAcompanhamentoPedagogico();
        this.businessUsuario = new BusinessUsuario ();
        this.businessTelefone = new BusinessTelefone();
        this.businessTurma = new BusinessTurma();
        this.businessResponsavel = new BusinessResponsavel();
        this.businessAcompanhamentoPedagogico =  new BusinessAcompanhamentoPedagogico();
        this.businessNotas = new BusinessNotas();
        this.businessConfiguracao = new BusinessConfiguracao();

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
    public List<Aluno> findAllNomeAluno(String nomeAluno) {
        return this.businessAluno.findAllNomeAluno(nomeAluno);
    }

    @Override
    public List<Aluno> findAllAlunosIdTurma(Integer idTurma) {
        return this.businessAluno.findAllAlunosIdTurma(idTurma);
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
    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo) {
        return this.businessDisciplina.findAllIdCurriculo(idCurriculo);
    }

    @Override
    public List<Disciplina> findAllNomeDisciplina(String nomeDisciplina) {
        return this.businessDisciplina.findAllNomeDisciplina(nomeDisciplina);
    }

    @Override
    public List<Disciplina> findAllNomeCurriculoDisiplina(String nomeCurriculo) {
        return this.businessDisciplina.findAllNomeCurriculoDisiplina(nomeCurriculo);
    }

    @Override
    public Disciplina removeDisciplina(Integer id) {
        return this.businessDisciplina.removeDisciplina(id);
    }



    //PEDAGOGO
    @Override
    public AcompanhamentoPedagogico saveAcompanhamentoPedagogico(AcompanhamentoPedagogico acompanhamentoPedagogico) {
        return this.businessAcompanhamentoPedagogico.saveAcompanhamentoPedagogico(acompanhamentoPedagogico);
    }

    @Override
    public AcompanhamentoPedagogico findByIdAcompanhamentoPedagogico(Integer id) {
        return this.businessAcompanhamentoPedagogico.findByIdAcompanhamentoPedagogico(id);
    }

    @Override
    public List<AcompanhamentoPedagogico> findByIdAlunoAcompanhamentoPedagogico(Integer idAluno) {
        return this.businessAcompanhamentoPedagogico.findByIdAlunoAcompanhamentoPedagogico(idAluno);
    }

    @Override
    public List<AcompanhamentoPedagogico> findAllAcompanhamentoPedagogicoList() {
        return this.businessAcompanhamentoPedagogico.findAllAcompanhamentoPedagogicoList();
    }

    @Override
    public List<AcompanhamentoPedagogico> findAllStringAcompanhamentoPedagogicos(String nome) {
        return this.businessAcompanhamentoPedagogico.findAllStringAcompanhamentoPedagogicos(nome);
    }

    @Override
    public AcompanhamentoPedagogico removeAcompanhamentoPedagogico(Integer id) {
        return this.businessAcompanhamentoPedagogico.removeAcompanhamentoPedagogico(id);
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
    public UsuarioLogado saveUsuarioLogado(UsuarioLogado usuarioLogado) {
        return this.businessUsuario.saveUsuarioLogado(usuarioLogado);
    }

    @Override
    public Usuario findByIdUsuario(Integer id) {
        return this.businessUsuario.findByIdUsuario(id);
    }

    @Override
    public List<Usuarioview> findAllUsuario() {
        return this.businessUsuario.findAllUsuario();
    }

    @Override
    public List<Usuarioview> findAllUsuarioNome(String nome) {
        return this.businessUsuario.findAllNome(nome);
    }

    @Override
    public Usuario removeUsuario(Integer id) {
        return this.businessUsuario.removeUsuario(id);
    }

    @Override
    public Usuarioview validarLoginSenha(String email, String senha) {
        return this.businessUsuario.validarLoginSenha(email,senha);
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



    //NOTAS
    @Override
    public Nota saveNota(Nota notaDisciplina) {
        return this.businessNotas.saveNota(notaDisciplina);
    }

    @Override
    public Nota findByIdNota(Integer id) {
        return this.businessNotas.findByIdNota(id);
    }

    @Override
    public Nota findByIdNotaDisciplina(Integer idDisciplina) {
        return this.businessNotas.findByIdNotaDisciplina(idDisciplina);
    }

    @Override
    public List<DisciplinaNotasView> findAllNotas(Integer idAluno) {
        return this.businessNotas.findAllNotas(idAluno);
    }

    @Override
    public Nota removeNota(Integer id) {
        return this.businessNotas.removeNota(id);
    }



    //CONFIGURAÇÃO
    @Override
    public Configuracao saveConfiguracao(Configuracao configuracao) {
        return this.businessConfiguracao.saveConfiguracao(configuracao);
    }

    @Override
    public Configuracao findByIdConfiguracao(Integer id) {
        return this.businessConfiguracao.findByIdConfiguracao(id);
    }

    @Override
    public List<Configuracao> findAllConfiguracao() {
        return this.businessConfiguracao.findAllConfiguracao();
    }

    @Override
    public Configuracao removeConfiguracao(Integer id) {
        return this.businessConfiguracao.removeConfiguracao(id);
    }
}
