package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.Aluno;
import projeto_pbd.com.br.modell.Telefone;

import java.util.List;

public interface IDaoTelefone {

    public Telefone save(Telefone telefone);

    public Telefone findById(int id);

    public List<Telefone> findAll();

    public List<Telefone> findAllId(int idPessoa);

    public Telefone remove(int id);
}
