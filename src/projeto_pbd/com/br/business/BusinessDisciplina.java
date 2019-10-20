package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoDisciplina;
import projeto_pbd.com.br.dao.IDaoDisciplina;
import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public class BusinessDisciplina implements IBusinessDisciplina {

    private IDaoDisciplina daoDisciplina;

    public BusinessDisciplina() {
        this.daoDisciplina = new DaoDisciplina ();
    }

    @Override
    public Disciplina save(Disciplina disciplina) {
        return this.daoDisciplina.save (disciplina);
    }

    @Override
    public Disciplina findById(int id) {
        return this.daoDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAll() {
        return this.daoDisciplina.findAll ();
    }

    @Override
    public Disciplina remove(int id) {
        return this.daoDisciplina.remove (id);
    }
}
