package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoAluno;
import projeto_pbd.com.br.dao.IDaoAluno;
import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public class BusinessAluno implements  IBusinessAluno {


    private IDaoAluno daoAluno;


    public BusinessAluno() {
        this.daoAluno = new DaoAluno ();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return this.daoAluno.save (aluno);
    }

    @Override
    public Aluno findById(int id) {
        return this.daoAluno.findById (id);
    }

    @Override
    public List<Aluno> findAll() {
        return this.daoAluno.findAll ();
    }

    @Override
    public Aluno remove(int id) {
        return this.daoAluno.remove (id);
    }
}
