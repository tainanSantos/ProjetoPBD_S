package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.BusinessDisciplina;
import projeto_pbd.com.br.business.IBusinessDisciplina;
import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public class FacadeDisciplina implements IFacadeDisciplina {

    private IBusinessDisciplina businessDisciplina;

    public FacadeDisciplina() {
        this.businessDisciplina = new BusinessDisciplina ();
    }

    @Override
    public Disciplina save(Disciplina disciplina) {
        return this.businessDisciplina.save (disciplina);
    }

    @Override
    public Disciplina findById(int id) {
        return this.businessDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAll() {
        return this.businessDisciplina.findAll ();
    }

    @Override
    public Disciplina remove(int id) {
        return this.businessDisciplina.remove (id);
    }
}
