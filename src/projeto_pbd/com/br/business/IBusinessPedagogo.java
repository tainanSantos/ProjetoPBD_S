package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public interface IBusinessPedagogo {

    public Pedagogo save(Pedagogo pedagogo);

    public Pedagogo findById(Integer id);

    public List<Pedagogo> findAll();

    public List<Pedagogo> findAllString(String nome);

    public Pedagogo remove(Integer id);
}
