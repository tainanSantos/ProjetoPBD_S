package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoEndereco;
import projeto_pbd.com.br.dao.IDaoEndereco;
import projeto_pbd.com.br.modell.Endereco;

import java.util.List;

public class BusinessEndereco implements IBusinessEndereco {

    private IDaoEndereco daoEndereco;

    public BusinessEndereco() {
        this.daoEndereco = new DaoEndereco ();

    }

    @Override
    public Endereco save(Endereco endereco) {
        return this.daoEndereco.save (endereco);
    }

    @Override
    public Endereco findById(int id) {
        return this.daoEndereco.findById (id);
    }

    @Override
    public List<Endereco> findAll() {
        return this.daoEndereco.findAll ();
    }

    @Override
    public Endereco remove(int id) {
        return this.daoEndereco.remove (id);
    }
}
