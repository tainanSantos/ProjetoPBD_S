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
    public Pedagogo savePedagogo(Pedagogo pedagogo) {
        return this.daoPedagogo.save (pedagogo);
    }

    @Override
    public Pedagogo findByIdPedagogo(Integer id) {
        return this.daoPedagogo.findById (id);
    }

    @Override
    public List<Pedagogo> findAllPedagogo() {
        return this.daoPedagogo.findAll ();
    }

    @Override
    public List<Pedagogo> findAllStringPedagogo(String nome) {
        return this.daoPedagogo.findAllString(nome);
    }

    @Override
    public Pedagogo removePedagogo(Integer id) {
        return this.daoPedagogo.remove (id);
    }
}
