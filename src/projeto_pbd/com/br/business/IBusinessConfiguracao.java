package projeto_pbd.com.br.business;

import projeto_pbd.com.br.modell.Configuracao;

import java.util.List;

public interface IBusinessConfiguracao {

    public Configuracao saveConfiguracao(Configuracao configuracao);

    public Configuracao findByIdConfiguracao(Integer id);

    public List<Configuracao> findAllConfiguracao();

    public Configuracao removeConfiguracao(Integer id);
}

