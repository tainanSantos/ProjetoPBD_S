package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoNotas;
import projeto_pbd.com.br.dao.IDaoNotas;
import projeto_pbd.com.br.modell.DisciplinaNotasView;
import projeto_pbd.com.br.modell.Nota;

import java.util.List;

public class BusinessNotas implements IBusinessNotas{

    private IDaoNotas daoNotas;

    public BusinessNotas() {

        this.daoNotas = new DaoNotas();
    }

    @Override
    public Nota saveNota(Nota notaDisciplina) {
        return this.daoNotas.saveNota(notaDisciplina);
    }

    @Override
    public Nota findByIdNota(Integer id) {
        return this.daoNotas.findByIdNota(id);
    }

    @Override
    public Nota findByIdNotaDisciplina(Integer idDisciplina) {
        return this.daoNotas.findByIdNotaDisciplina(idDisciplina);
    }

    @Override
    public List<DisciplinaNotasView> findAllNotas(Integer idCurriculo) {
        return this.daoNotas.findAllNotas(idCurriculo);
    }

    @Override
    public Nota removeNota(Integer id) {
        return this.daoNotas.removeNota(id);
    }
}
