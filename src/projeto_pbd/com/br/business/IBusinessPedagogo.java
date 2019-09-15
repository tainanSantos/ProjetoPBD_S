package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Pedagogo;

import java.util.ArrayList;

public interface IBusinessPedagogo {

    public void salvar(Pedagogo pedagogo);
    public Pedagogo buscar(int idPedagogo);
    public ArrayList<Pedagogo> listar();
    public void Deletar(int idPedagogo);
}
