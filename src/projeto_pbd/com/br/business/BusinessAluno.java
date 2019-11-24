package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoAluno;
import projeto_pbd.com.br.dao.IDaoAluno;
import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public class BusinessAluno implements  IBusinessAluno {


    private IDaoAluno daoAluno;


    public BusinessAluno() {
        this.daoAluno = new DaoAluno ();
    }

    @Override
    public Aluno saveAluno(Aluno aluno) {
        return this.daoAluno.save (aluno);
    }

    @Override
    public Aluno findByIdAluno(Integer id) {
        return this.daoAluno.findById (id);
    }

    @Override
    public List<Aluno> findAllAluno() {
        return this.daoAluno.findAll ();
    }

    @Override
    public List<Aluno> findAllNomeAluno(String nomeAluno) {
        return this.daoAluno.findAllNome(nomeAluno);
    }

    @Override
    public List<Aluno> findAllAlunosIdTurma(Integer idTurma) {
        return this.daoAluno.findAllAlunosIdTurma(idTurma);
    }

    @Override
    public Aluno removeAluno(Integer id) {
        return this.daoAluno.remove (id);
    }
}
