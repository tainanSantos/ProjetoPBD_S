package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Responsavel;

import java.util.List;

public interface IBusinessResponsavel {

    public Responsavel saveResponsavel(Responsavel responsavel );

    public Responsavel findByIdResponsavel(Integer id);

    public List<Responsavel> findAllResponsavel();

    public Responsavel removeResponsavel(Integer id);
}
