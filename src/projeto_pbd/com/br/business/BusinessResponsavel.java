package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoResponsavel;
import projeto_pbd.com.br.dao.IDaoResponsavel;
import projeto_pbd.com.br.modell.Responsavel;

import java.util.List;

public class BusinessResponsavel implements IBusinessResponsavel {

    private IDaoResponsavel daoResponsavel;

    public BusinessResponsavel() {

        this.daoResponsavel = new DaoResponsavel();
    }

    @Override
    public Responsavel save(Responsavel responsavel) {
        return this.daoResponsavel.save(responsavel);
    }

    @Override
    public Responsavel findById(Integer id) {
        return this.daoResponsavel.findById(id);
    }

    @Override
    public List<Responsavel> findAll() {
        return this.daoResponsavel.findAll();
    }

    @Override
    public Responsavel remove(Integer id) {
        return this.daoResponsavel.remove(id);
    }
}
