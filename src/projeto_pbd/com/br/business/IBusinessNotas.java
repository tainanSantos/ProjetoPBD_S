package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.DisciplinaNotasView;
import projeto_pbd.com.br.modell.Nota;

import java.util.List;

public interface IBusinessNotas {

    public Nota saveNota(Nota notaDisciplina );

    public Nota findByIdNota(Integer id);

    public Nota findByIdNotaDisciplina(Integer idDisciplina);

    public List<DisciplinaNotasView> findAllNotas(Integer idCurriculo);

    public Nota removeNota(Integer id);
}
