package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoAuditoria;
import projeto_pbd.com.br.dao.IDaoAuditoria;
import projeto_pbd.com.br.modell.AuditoriaUsuarios;

import java.util.List;

public class BusinessAuditoriaUsers implements IBusinessAuditoriaUsers {

    private IDaoAuditoria daoAuditoria;

    public BusinessAuditoriaUsers() {
        this.daoAuditoria = new DaoAuditoria();
    }

    @Override
    public List<AuditoriaUsuarios> findAllAuditoriasUser() {
        return this.daoAuditoria.findAllAuditoriasUser();
    }
}
