package projeto_pbd.com.br.facade;

import projeto_pbd.com.br.business.BusinessTelefone;
import projeto_pbd.com.br.business.IBusinessTelefone;
import projeto_pbd.com.br.modell.Telefone;

import java.util.List;

public class FacadeTelefone implements IFacadeTelefone {

    private IBusinessTelefone businessTelefone;

    public FacadeTelefone() {
        this.businessTelefone = new BusinessTelefone ();
    }


    @Override
    public Telefone save(Telefone telefone) {
        return this.businessTelefone.save (telefone);
    }

    @Override
    public Telefone findById(int id) {
        return this.businessTelefone.findById (id);
    }

    @Override
    public List<Telefone> findAll() {
        return this.businessTelefone.findAll ();
    }

    @Override
    public Telefone remove(int id) {
        return this.businessTelefone.remove (id);
    }
}
