package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoTelefone;
import projeto_pbd.com.br.dao.IDaoTelefone;
import projeto_pbd.com.br.modell.Telefone;

import java.util.List;

public class BusinessTelefone implements IBusinessTelefone {

    private IDaoTelefone daoTelefone;


    public BusinessTelefone() {
        this.daoTelefone = new DaoTelefone ();
    }


    @Override
    public Telefone save(Telefone telefone) {
        return this.daoTelefone.save (telefone);
    }

    @Override
    public Telefone findById(int id) {
        return this.daoTelefone.findById (id);
    }

    @Override
    public List<Telefone> findAll() {
        return this.daoTelefone.findAll ();
    }

    @Override
    public Telefone remove(int id) {
        return this.daoTelefone.remove (id);
    }
}
