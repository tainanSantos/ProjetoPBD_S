package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.BusinessProfessor;
import projeto_pbd.com.br.business.IBusinessProfessor;
import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public class FacadeProfessor implements IFacadeProfessor {


    private IBusinessProfessor businessProfessor;


    public FacadeProfessor() {
        this.businessProfessor = new BusinessProfessor ();
    }


    @Override
    public Professor save(Professor professor) {
        return this.businessProfessor.save (professor);
    }

    @Override
    public Professor findById(int id) {
        return this.businessProfessor.findById (id);
    }

    @Override
    public List<Professor> findAll() {
        return this.businessProfessor.findAll ();
    }

    @Override
    public Professor remove(int id) {
        return this.businessProfessor.remove (id);
    }
}
