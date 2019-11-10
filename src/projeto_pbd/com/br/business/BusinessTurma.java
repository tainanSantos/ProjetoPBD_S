package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoTurma;
import projeto_pbd.com.br.dao.IDaoTurma;
import projeto_pbd.com.br.modell.Turma;

import java.util.List;

public class BusinessTurma implements IBusinessTurma {

    private IDaoTurma daoTurma;

    public BusinessTurma() {

        this.daoTurma= new DaoTurma();
    }

    @Override
    public Turma saveTurma(Turma turma) {
        return this.daoTurma.save(turma);
    }

    @Override
    public Turma findByIdTurma(Integer id) {
        return this.daoTurma.findById(id);
    }

    @Override
    public List<Turma> findAllTurma() {
        return this.daoTurma.findAll();
    }

    @Override
    public Turma removeTurma(Integer id) {
        return this.daoTurma.remove(id);
    }
}
