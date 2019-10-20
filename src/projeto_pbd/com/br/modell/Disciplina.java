package projeto_pbd.com.br.modell;

public class Disciplina {

    private Integer id;
    private String codigo;
    private String nome;
    private double cargaHoaria;
    private Professor professor;
    private boolean statusAluno;

    private Disciplina(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCargaHoaria() {
        return cargaHoaria;
    }

    public void setCargaHoaria(double cargaHoaria) {
        this.cargaHoaria = cargaHoaria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean isStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(boolean statusAluno) {
        this.statusAluno = statusAluno;
    }
}
