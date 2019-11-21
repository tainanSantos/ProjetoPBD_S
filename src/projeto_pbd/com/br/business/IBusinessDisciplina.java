package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IBusinessDisciplina {

    public Disciplina saveDisciplina(Disciplina disciplina );

    public Disciplina findByIdDisciplina(Integer id);

    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo);

    public List<Disciplina> findAllDisciplina();

    public List<Disciplina> findAllNomeDisciplina(String nomeDisciplina);

    public List<Disciplina> findAllNomeCurriculoDisiplina(String nomeCurriculo);

    public Disciplina removeDisciplina(Integer id);
}
