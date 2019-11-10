package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Turma;

import java.util.List;

public interface IBusinessTurma {

    public Turma saveTurma(Turma turma);

    public Turma findByIdTurma(Integer id);

    public List<Turma> findAllTurma();

    public Turma removeTurma(Integer id);
}
