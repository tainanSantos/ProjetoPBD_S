package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoCurriculo;
import projeto_pbd.com.br.dao.IDaoCurriculo;
import projeto_pbd.com.br.modell.Curriculo;

import java.util.List;

public class BusinessCurriculo implements IBusinessCurriculo {


    private IDaoCurriculo daoCurriculo;

    public BusinessCurriculo() {

        this.daoCurriculo =  new DaoCurriculo ();
    }


    @Override
    public Curriculo saveCurriculo(Curriculo curriculo) {
        return this.daoCurriculo.save (curriculo);
    }

    @Override
    public Curriculo findByIdCurriculo(Integer id) {
        return this.daoCurriculo.findById (id);
    }

    @Override
    public List<Curriculo> findAllCurriculo() {
        return this.daoCurriculo.findAll ();
    }

    @Override
    public Curriculo removeCurriculo(Integer id) {
        return this.daoCurriculo.remove (id);
    }
}
