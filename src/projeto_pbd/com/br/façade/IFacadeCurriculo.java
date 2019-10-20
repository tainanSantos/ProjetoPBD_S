package projeto_pbd.com.br.façade;

import projeto_pbd.com.br.modell.Curriculo;

import java.util.List;

public interface IFacadeCurriculo {
    public Curriculo save(Curriculo curriculo );

    public Curriculo findById(int id);

    public List<Curriculo> findAll();

    public Curriculo remove(int id);
}
