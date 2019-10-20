package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.business.BusinessPedagogo;
import projeto_pbd.com.br.business.IBusinessPedagogo;
import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public class FacadePedagogo implements IFacadePedagogo {

    private IBusinessPedagogo businessPedagogo;


    public FacadePedagogo() {

        this.businessPedagogo = new BusinessPedagogo ();
    }

    @Override
    public Pedagogo save(Pedagogo pedagogo) {
        return this.businessPedagogo.save (pedagogo);
    }

    @Override
    public Pedagogo findById(int id) {
        return this.businessPedagogo.findById (id);
    }

    @Override
    public List<Pedagogo> findAll() {
        return this.businessPedagogo.findAll ();
    }

    @Override
    public Pedagogo remove(int id) {
        return this.businessPedagogo.remove (id);
    }
}
