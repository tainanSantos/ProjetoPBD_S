package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IDaoDisciplina {

    public Disciplina save(Disciplina disciplina );

    public Disciplina findById(Integer id);

    public List<Disciplina> findAllIdCurriculo(Integer idCurriculo);

    public List<Disciplina> findAll();

    public List<Disciplina> findAllNome(String nomeDisciplina);

    public List<Disciplina> findAllNomeCurriculo(String nomeCurriculo);

    public Disciplina remove(Integer id);
}
