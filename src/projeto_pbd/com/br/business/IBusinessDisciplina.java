package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IBusinessDisciplina {

    public Disciplina saveDisciplina(Disciplina disciplina );

    public Disciplina findByIdDisciplina(Integer id);

    public List<Disciplina> findAllDisciplina();

    public Disciplina removeDisciplina(Integer id);
}
