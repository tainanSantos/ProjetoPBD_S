package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Telefone;

import java.util.List;

public interface IBusinessTelefone {

    public Telefone saveTelefone(Telefone telefone);

    public Telefone findByIdTelefone(Integer id);

    public List<Telefone> findAllTelefone();

    public List<Telefone> findAllIdTelefone(Integer idPessoa);

    public Telefone removeTelefone(Integer id);
}
