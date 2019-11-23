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
    public Disciplina saveDisciplina(Disciplina disciplina) {
        return this.daoDisciplina.save (disciplina);
    }

    @Override
    public Disciplina findByIdDisciplina(Integer id) {
        return this.daoDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo) {
        return this.daoDisciplina.findAllIdCurriculo(idCurriculo);
    }

    @Override
    public List<Disciplina> findAllDisciplina() {
        return this.daoDisciplina.findAll ();
    }

    @Override
    public List<Disciplina> findAllNomeDisciplina(String nomeDisciplina) {
        return this.daoDisciplina.findAllNome(nomeDisciplina);
    }

    @Override
    public List<Disciplina> findAllNomeCurriculoDisiplina(String nomeCurriculo) {
        return this.daoDisciplina.findAllNomeCurriculo(nomeCurriculo);
    }

    @Override
    public Disciplina removeDisciplina(Integer id) {
        return this.daoDisciplina.remove (id);
    }
}
