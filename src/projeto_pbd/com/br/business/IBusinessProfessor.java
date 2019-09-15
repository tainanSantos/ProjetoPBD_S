package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Professor;

import java.util.ArrayList;

public interface IBusinessProfessor {

    public void salvar(Professor professor);
    public Aluno buscar(int idProfessor);
    public ArrayList<Professor> listar();
    public void Deletar(int idProfessor);
}
