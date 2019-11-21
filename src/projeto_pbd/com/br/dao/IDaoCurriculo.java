package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Curriculo;
import projeto_pbd.com.br.modell.Disciplina;

import java.util.List;

public interface IDaoCurriculo {

    public Curriculo save(Curriculo curriculo );

    public Curriculo findById(Integer id);

    public List<Curriculo> findAll();

    public Curriculo remove(Integer id);
}
