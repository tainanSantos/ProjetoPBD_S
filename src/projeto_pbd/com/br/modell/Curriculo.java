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

    private int id;
    private ArrayList<Disciplina> disciplinas;

    // se ele passou ou não de ano
    private boolean statusSemester;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
