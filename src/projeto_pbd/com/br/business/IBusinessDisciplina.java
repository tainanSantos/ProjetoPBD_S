package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IBusinessDisciplina {
    public Disciplina save(Disciplina disciplina );

    public Disciplina findById(Integer id);

    public List<Disciplina> findAll();

    public Disciplina remove(Integer id);
}
