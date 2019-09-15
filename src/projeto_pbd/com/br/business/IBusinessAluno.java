package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Aluno;

import java.util.ArrayList;

public interface IBusinessAluno {

    public void salvar(Aluno aluno);
    public Aluno buscar(int idAluno);
    public ArrayList<Aluno> listar();
    public void Deletar(int idAluno);
}
