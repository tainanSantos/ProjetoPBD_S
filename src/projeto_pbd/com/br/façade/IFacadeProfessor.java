package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public interface IFacadeProfessor {

    public Professor save(Professor professor);

    public Professor findById(int id);

    public List<Professor> findAll();

    public Professor remove(int id);
}
