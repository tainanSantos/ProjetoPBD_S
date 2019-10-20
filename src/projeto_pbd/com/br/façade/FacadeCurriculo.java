package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.BusinessCurriculo;
import projeto_pbd.com.br.business.IBusinessCurriculo;
import projeto_pbd.com.br.modell.Curriculo;

import java.util.List;

public class FacadeCurriculo implements IFacadeCurriculo {

    private IBusinessCurriculo businessCurriculo;

    public FacadeCurriculo() {
        this.businessCurriculo = new BusinessCurriculo ();
    }

    @Override
    public Curriculo save(Curriculo curriculo) {
        return this.businessCurriculo.save (curriculo);
    }

    @Override
    public Curriculo findById(int id) {
        return this.businessCurriculo.findById (id);
    }

    @Override
    public List<Curriculo> findAll() {
        return this.businessCurriculo.findAll ();
    }

    @Override
    public Curriculo remove(int id) {
        return this.businessCurriculo.remove (id);
    }
}
