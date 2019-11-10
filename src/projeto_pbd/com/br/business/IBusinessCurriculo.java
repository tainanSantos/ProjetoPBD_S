package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Curriculo;

import java.util.List;

public interface IBusinessCurriculo {

    public Curriculo saveCurriculo(Curriculo curriculo );

    public Curriculo findByIdCurriculo(Integer id);

    public List<Curriculo> findAllCurriculo();

    public Curriculo removeCurriculo(Integer id);
}
