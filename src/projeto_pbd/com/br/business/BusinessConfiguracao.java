package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoConfiguracao;
import projeto_pbd.com.br.dao.IDaoConfiguracao;
import projeto_pbd.com.br.modell.Configuracao;

import java.util.List;

public class BusinessConfiguracao implements IBusinessConfiguracao {

    private IDaoConfiguracao daoConfiguracao;

    public BusinessConfiguracao(){
        this.daoConfiguracao= new DaoConfiguracao();
    }

    @Override
    public Configuracao saveConfiguracao(Configuracao configuracao) {
        return this.daoConfiguracao.saveConfiguracao(configuracao);
    }

    @Override
    public Configuracao findByIdConfiguracao(Integer id) {
        return this.daoConfiguracao.findByIdConfiguracao(id);
    }

    @Override
    public List<Configuracao> findAllConfiguracao() {
        return this.daoConfiguracao.findAllConfiguracao();
    }

    @Override
    public Configuracao removeConfiguracao(Integer id) {
        return this.daoConfiguracao.removeConfiguracao(id);
    }
}
