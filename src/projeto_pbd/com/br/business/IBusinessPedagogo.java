package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public interface IBusinessPedagogo {

    public Pedagogo savePedagogo(Pedagogo pedagogo);

    public Pedagogo findByIdPedagogo(Integer id);

    public List<Pedagogo> findAllPedagogo();

    public List<Pedagogo> findAllStringPedagogo(String nome);

    public Pedagogo removePedagogo(Integer id);
}
