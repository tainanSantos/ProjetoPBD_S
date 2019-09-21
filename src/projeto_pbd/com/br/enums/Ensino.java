package projeto_pbd.com.br.enums;

public enum Ensino {

    ENSINO_FUNDAMENTAL_INICIAL(1),
    ENSINO_FUNDAMENTAL_FINAL(2),
    ENSINO_MEDIO(3);

    private int valor;

    private  Ensino(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
