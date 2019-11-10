package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoProfessor;
import projeto_pbd.com.br.dao.IDaoProfessor;
import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public class BusinessProfessor implements IBusinessProfessor {

    /* questão de validação ainda não implementada deve ser tratada aqui */

    private IDaoProfessor daoProfessor;


    public BusinessProfessor() {
        this.daoProfessor = new DaoProfessor ();
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return this.daoProfessor.save (professor);
    }

    @Override
    public Professor findByIdProfessor(Integer id) {
        return this.daoProfessor.findById (id);
    }

    @Override
    public List<Professor> findAllProfessor() {
        return this.daoProfessor.findAll ();
    }

    @Override
    public Professor removeProfessor(Integer id) {
        return this.daoProfessor.remove (id);
    }
}
