package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.AcompanhamentoPedagogico;

import java.util.List;

public interface IBusinessAcompanhamentoPedagogico {

    public AcompanhamentoPedagogico saveAcompanhamentoPedagogico(AcompanhamentoPedagogico acompanhamentoPedagogico);

    public AcompanhamentoPedagogico findByIdAcompanhamentoPedagogico(Integer id);

    public List<AcompanhamentoPedagogico> findByIdAlunoAcompanhamentoPedagogico(Integer idAluno);

    public List<AcompanhamentoPedagogico> findAllAcompanhamentoPedagogicoList();

    public List<AcompanhamentoPedagogico> findAllStringAcompanhamentoPedagogicos(String nome);

    public List<AcompanhamentoPedagogico> findByIdUsuarioPedagogoAcompanhamentoPedagogico(Integer idPedagogoLogado);

    public AcompanhamentoPedagogico removeAcompanhamentoPedagogico(Integer id);
}
