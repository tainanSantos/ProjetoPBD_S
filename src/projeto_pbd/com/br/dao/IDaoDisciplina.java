package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IDaoDisciplina {

    public Disciplina save(Disciplina disciplina );

    public Disciplina findById(Integer id);

    public List<Disciplina> findAll();

    public Disciplina remove(Integer id);
}
