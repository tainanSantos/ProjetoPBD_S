package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public interface IDaoAluno {

    public Aluno save(Aluno aluno );

    public Aluno findById(Integer id);

    public List<Aluno> findAll();

    public Aluno remove(Integer id);
}
