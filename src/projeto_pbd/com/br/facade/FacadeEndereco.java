package projeto_pbd.com.br.facade;

import projeto_pbd.com.br.business.BusinessEndereco;
import projeto_pbd.com.br.business.IBusinessEndereco;
import projeto_pbd.com.br.modell.Endereco;

import java.util.List;

public class FacadeEndereco implements IFacadeEndereco{

    private IBusinessEndereco businessEndereco;


    public FacadeEndereco() {
        this.businessEndereco = new BusinessEndereco ();
    }

    @Override
    public Endereco save(Endereco endereco) {
        return this.businessEndereco.save (endereco);
    }

    @Override
    public Endereco findById(int id) {
        return this.businessEndereco.findById (id);
    }

    @Override
    public List<Endereco> findAll() {
        return this.businessEndereco.findAll ();
    }

    @Override
    public Endereco remove(int id) {
        return this.businessEndereco.remove (id);
    }
}
