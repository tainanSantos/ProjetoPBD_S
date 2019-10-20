package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public interface IFacadeAluno {

    public Aluno save(Aluno aluno );

    public Aluno findById(int id);

    public List<Aluno> findAll();

    public Aluno remove(int id);

}
