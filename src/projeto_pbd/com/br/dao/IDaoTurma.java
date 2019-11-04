package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Turma;

import java.util.List;

public interface IDaoTurma {

    public Turma save(Turma turma);

    public Turma findById(Integer id);

    public List<Turma> findAll();

    public Turma remove(Integer id);
}
