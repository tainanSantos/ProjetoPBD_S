package projeto_pbd.com.br.enums;

public enum Grupo {

    GRUPO_SECRETARIA(1),
    GRUPO_COORDENACAO_PEDAGOGICA(2),
    GRUPO_DIRECAO_ESCOLA(3);

    private int valor;

    private  Grupo(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
