package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoDisciplina;
import projeto_pbd.com.br.dao.IDaoDisciplina;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.msg.Mensagem;

import javax.persistence.PersistenceException;
import java.util.List;

public class BusinessDisciplina implements IBusinessDisciplina {

    private IDaoDisciplina daoDisciplina;

    public BusinessDisciplina() {
        this.daoDisciplina = new DaoDisciplina ();
    }

    @Override
    public Disciplina save(Disciplina disciplina) {

        try {
            return this.daoDisciplina.save (disciplina);
        }catch (PersistenceException e){
            Mensagem.mensagemErro ("Erro! Nenhum professor foi Selecionado");
        }finally {
            return null;
        }
    }

    @Override
    public Disciplina findById(Integer id) {
        return this.daoDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAll() {
        return this.daoDisciplina.findAll ();
    }

    @Override
    public Disciplina remove(Integer id) {
        return this.daoDisciplina.remove (id);
    }
}
