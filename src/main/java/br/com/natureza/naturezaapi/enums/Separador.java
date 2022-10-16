package br.com.natureza.naturezaapi.enums;
public enum Separador {

    PONTO(1, ".(ponto)"),
    HIFEN(2, "-(hífen)"),
    BARRA(3, "/(barra)"),
    NENHUM(4, "NENHUM");

    private int cod;
    private String descricao;

    private Separador(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }
    public String getDescricao() {
        return descricao;
    }

    public static Separador toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }
        for(Separador x : Separador.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
