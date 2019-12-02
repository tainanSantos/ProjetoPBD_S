package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoAcompanhamentoPedagogico;
import projeto_pbd.com.br.dao.IDaoAcompanhamentoPedagogico;
import projeto_pbd.com.br.modell.AcompanhamentoPedagogico;

import java.util.List;

public class BusinessAcompanhamentoPedagogico implements IBusinessAcompanhamentoPedagogico {

    private IDaoAcompanhamentoPedagogico daoAcompanhamentoPedagogico;


    public BusinessAcompanhamentoPedagogico() {
        this.daoAcompanhamentoPedagogico = new DaoAcompanhamentoPedagogico();
    }

    @Override
    public AcompanhamentoPedagogico saveAcompanhamentoPedagogico(AcompanhamentoPedagogico acompanhamentoPedagogico) {
        return this.daoAcompanhamentoPedagogico.saveAcompanhamentoPedagogico(acompanhamentoPedagogico);
    }

    @Override
    public AcompanhamentoPedagogico findByIdAcompanhamentoPedagogico(Integer id) {
        return this.daoAcompanhamentoPedagogico.findByIdAcompanhamentoPedagogico(id);
    }

    @Override
    public List<AcompanhamentoPedagogico> findByIdAlunoAcompanhamentoPedagogico(Integer idAluno) {
        return this.daoAcompanhamentoPedagogico.findByIdAlunoAcompanhamentoPedagogico(idAluno);
    }

    @Override
    public List<AcompanhamentoPedagogico> findAllAcompanhamentoPedagogicoList() {
        return this.daoAcompanhamentoPedagogico.findAllAcompanhamentoPedagogicoList();
    }

    @Override
    public List<AcompanhamentoPedagogico> findAllStringAcompanhamentoPedagogicos(String nome) {
        return this.daoAcompanhamentoPedagogico.findAllStringAcompanhamentoPedagogicos(nome);
    }

    @Override
    public List<AcompanhamentoPedagogico> findByIdUsuarioPedagogoAcompanhamentoPedagogico(Integer idPedagogoLogado) {
        return this.daoAcompanhamentoPedagogico.findByIdUsuarioPedagogoAcompanhamentoPedagogico(idPedagogoLogado);
    }

    @Override
    public AcompanhamentoPedagogico removeAcompanhamentoPedagogico(Integer id) {
        return this.daoAcompanhamentoPedagogico.removeAcompanhamentoPedagogico(id);
    }
}
