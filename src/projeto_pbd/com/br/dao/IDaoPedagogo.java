package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Pedagogo;

import java.util.List;

public interface IDaoPedagogo {


    public Pedagogo save(Pedagogo pedagogo);

    public Pedagogo findById(int id);

    public List<Pedagogo> findAll();

    public Pedagogo remove(int id);
}
