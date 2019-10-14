package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Telefone;

import java.util.List;

public interface IBusinessTelefone {

    public Telefone save(Telefone telefone);

    public Telefone findById(int id);

    public List<Telefone> findAll();

    public Telefone remove(int id);
}
