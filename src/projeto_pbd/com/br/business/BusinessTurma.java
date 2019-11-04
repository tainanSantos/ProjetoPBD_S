package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Turma;

import java.util.List;

public class BusinessTurma implements IBusinessTurma {

    private IBusinessTurma businessTurma;

    public BusinessTurma() {

        this.businessTurma= new BusinessTurma();
    }

    @Override
    public Turma save(Turma turma) {
        return this.businessTurma.save(turma);
    }

    @Override
    public Turma findById(Integer id) {
        return this.businessTurma.findById(id);
    }

    @Override
    public List<Turma> findAll() {
        return this.businessTurma.findAll();
    }

    @Override
    public Turma remove(Integer id) {
        return this.businessTurma.remove(id);
    }
}
