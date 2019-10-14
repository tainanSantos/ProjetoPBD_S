package projeto_pbd.com.br.facade;

import projeto_pbd.com.br.modell.Endereco;

import java.util.List;

public interface IFacadeEndereco {

    public Endereco save(Endereco endereco);

    public Endereco findById(int id);

    public List<Endereco> findAll();

    public Endereco remove(int id);
}
