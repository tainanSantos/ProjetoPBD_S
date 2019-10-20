package projeto_pbd.com.br.modell;


public class Nota {

    private Integer id;
    private float primeiraVa;
    private float segundaVa;
    private float terceiraVa;
    private float quartaVa;
    private float finalVa;

    private float media;

    // se aprovado ou reprovado na disciplina
    private boolean status;


    public Nota() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrimeiraVa() {
        return primeiraVa;
    }

    public void setPrimeiraVa(float primeiraVa) {
        this.primeiraVa = primeiraVa;
    }

    public float getSegundaVa() {
        return segundaVa;
    }

    public void setSegundaVa(float segundaVa) {
        this.segundaVa = segundaVa;
    }

    public float getTerceiraVa() {
        return terceiraVa;
    }

    public void setTerceiraVa(float terceiraVa) {
        this.terceiraVa = terceiraVa;
    }

    public float getFinalVa() {
        return finalVa;
    }

    public void setFinalVa(float finalVa) {
        this.finalVa = finalVa;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
