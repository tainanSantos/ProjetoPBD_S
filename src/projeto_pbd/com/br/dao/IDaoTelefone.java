package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Telefone;

import java.util.ArrayList;
import java.util.List;

public interface IDaoTelefone {

    public Telefone save(Telefone telefone);

    public Telefone findById(int id);

    public List<Telefone> findAll();

    public Telefone remove(int id);


}
