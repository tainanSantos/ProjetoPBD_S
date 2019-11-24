package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;

import java.util.List;

public interface IDaoAluno {

    public Aluno save(Aluno aluno );

    public Aluno findById(Integer id);

    public List<Aluno> findAll();

    public List<Aluno> findAllNome(String nome);

    public List<Aluno> findAllAlunosIdTurma(Integer idTurma);

    public Aluno remove(Integer id);
}
