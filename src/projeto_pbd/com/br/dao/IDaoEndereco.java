package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Endereco;

import java.util.List;

public interface IDaoEndereco {

    public Endereco save(Endereco endereco);

    public Endereco findById(int id);

    public List<Endereco> findAll();

    public Endereco remove(int id);
}
