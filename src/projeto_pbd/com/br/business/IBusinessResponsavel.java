package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Responsavel;

import java.util.List;

public interface IBusinessResponsavel {

    public Responsavel save(Responsavel responsavel );

    public Responsavel findById(Integer id);

    public List<Responsavel> findAll();

    public Responsavel remove(Integer id);
}
