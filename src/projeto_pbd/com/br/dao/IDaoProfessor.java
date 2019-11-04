package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public interface IDaoProfessor {

    public Professor save(Professor professor);

    public Professor findById(Integer id);

    public List<Professor> findAll();

    public Professor remove(Integer id);
}
