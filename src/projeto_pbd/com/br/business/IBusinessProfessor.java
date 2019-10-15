package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public interface IBusinessProfessor {

    public Professor save(Professor professor);

    public Professor findById(int id);

    public List<Professor> findAll();

    public Professor remove(int id);
}
