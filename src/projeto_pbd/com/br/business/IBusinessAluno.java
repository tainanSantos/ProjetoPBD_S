package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public interface IBusinessAluno {

    public Aluno save(Aluno aluno );

    public Aluno findById(Integer id);

    public List<Aluno> findAll();

    public Aluno remove(Integer id);
}
