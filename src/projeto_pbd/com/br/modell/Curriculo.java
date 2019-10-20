package projeto_pbd.com.br.modell;

import java.util.ArrayList;

public class Curriculo {

    /*
    * ENUM
    *
    * Campos do ENUM:
    *       EF
    *       EF
    *       EM
    * */

    private Integer id;
    private ArrayList<Disciplina> disciplinas;

    // se ele passou ou não de ano
    private boolean statusSemester;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean isStatusSemester() {
        return statusSemester;
    }

    public void setStatusSemester(boolean statusSemester) {
        this.statusSemester = statusSemester;
    }
}
