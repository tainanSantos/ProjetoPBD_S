package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public interface IBusinessAluno {

    public Aluno saveAluno(Aluno aluno );

    public Aluno findByIdAluno(Integer id);

    public List<Aluno> findAllAluno();

    public List<Aluno> findAllNomeAluno(String nomeAluno);

    public List<Aluno> findAllAlunosIdTurma(Integer idTurma);

    public Aluno removeAluno(Integer id);
}
