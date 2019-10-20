package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Curriculo;

import java.util.List;

public interface IBusinessCurriculo {

    public Curriculo save(Curriculo curriculo );

    public Curriculo findById(int id);

    public List<Curriculo> findAll();

    public Curriculo remove(int id);
}
