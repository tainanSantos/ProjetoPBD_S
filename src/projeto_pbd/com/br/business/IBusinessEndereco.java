package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Endereco;

import java.util.List;

public interface IBusinessEndereco {

    public Endereco save(Endereco endereco);

    public Endereco findById(int id);

    public List<Endereco> findAll();

    public Endereco remove(int id);
}
