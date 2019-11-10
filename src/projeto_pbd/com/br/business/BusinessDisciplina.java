package projeto_pbd.com.br.business;

import projeto_pbd.com.br.dao.DaoDisciplina;
import projeto_pbd.com.br.dao.IDaoDisciplina;
import projeto_pbd.com.br.modell.Disciplina;
import projeto_pbd.com.br.msg.Mensagem;

import javax.persistence.PersistenceException;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

public class BusinessDisciplina implements IBusinessDisciplina {

    private IDaoDisciplina daoDisciplina;

    public BusinessDisciplina() {
        this.daoDisciplina = new DaoDisciplina ();
    }

    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {

        try {
            if (disciplina.getNome()!=null || !disciplina.getNome().equalsIgnoreCase(""))
                return this.daoDisciplina.save (disciplina);
            else Mensagem.mensagemErro("Campo 'nome da disciplina' não peenchido");
        }catch (PersistenceException e){
            Mensagem.mensagemErro ("Erro! Nenhum professor foi Selecionado");
        }finally {
            return null;
        }
    }

    @Override
    public Disciplina findByIdDisciplina(Integer id) {
        return this.daoDisciplina.findById (id);
    }

    @Override
    public List<Disciplina> findAllDisciplina() {
        return this.daoDisciplina.findAll ();
    }

    @Override
    public Disciplina removeDisciplina(Integer id) {
        return this.daoDisciplina.remove (id);
    }
}
