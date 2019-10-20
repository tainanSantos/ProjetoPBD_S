package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoPedagogo;
import projeto_pbd.com.br.dao.IDaoPedagogo;
import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public class BusinessPedagogo implements IBusinessPedagogo {

    private IDaoPedagogo daoPedagogo;


    public BusinessPedagogo() {
        this.daoPedagogo = new DaoPedagogo ();
    }

    @Override
    public Pedagogo save(Pedagogo pedagogo) {
        return this.daoPedagogo.save (pedagogo);
    }

    @Override
    public Pedagogo findById(int id) {
        return this.daoPedagogo.findById (id);
    }

    @Override
    public List<Pedagogo> findAll() {
        return this.daoPedagogo.findAll ();
    }

    @Override
    public Pedagogo remove(int id) {
        return this.daoPedagogo.remove (id);
    }
}
