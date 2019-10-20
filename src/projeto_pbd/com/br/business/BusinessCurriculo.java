package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoCurriculo;
import projeto_pbd.com.br.dao.IDaoCurriculo;
import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public class BusinessCurriculo implements IBusinessCurriculo {


    private IDaoCurriculo daoCurriculo;

    public BusinessCurriculo() {

        this.daoCurriculo =  new DaoCurriculo ();
    }


    @Override
    public Curriculo save(Curriculo curriculo) {
        return this.daoCurriculo.save (curriculo);
    }

    @Override
    public Curriculo findById(int id) {
        return this.daoCurriculo.findById (id);
    }

    @Override
    public List<Curriculo> findAll() {
        return this.daoCurriculo.findAll ();
    }

    @Override
    public Curriculo remove(int id) {
        return this.daoCurriculo.remove (id);
    }
}
