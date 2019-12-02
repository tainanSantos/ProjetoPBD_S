package projeto_pbd.com.br.dao;

import projeto_pbd.com.br.modell.AuditoriaUsuarios;

import java.util.List;

public interface IDaoAuditoria {

    public List<AuditoriaUsuarios> findAllAuditoriasUser();
}
