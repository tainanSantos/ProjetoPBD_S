package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Professor;

import java.util.List;

public interface IBusinessProfessor {

    public Professor saveProfessor(Professor professor);

    public Professor findByIdProfessor(Integer id);

    public List<Professor> findAllProfessor();

    public Professor removeProfessor(Integer id);
}
