package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.BusinessAluno;
import projeto_pbd.com.br.business.IBusinessAluno;
import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public class FacadeAluno implements IFacadeAluno {


    private IBusinessAluno businessAluno;

    public FacadeAluno() {

        this.businessAluno = new BusinessAluno ();
    }


    @Override
    public Aluno save(Aluno aluno) {
        return this.businessAluno.save (aluno);
    }

    @Override
    public Aluno findById(int id) {
        return this.businessAluno.findById (id);
    }

    @Override
    public List<Aluno> findAll() {
        return this.businessAluno.findAll ();
    }

    @Override
    public Aluno remove(int id) {
        return this.businessAluno.remove (id);
    }
}
