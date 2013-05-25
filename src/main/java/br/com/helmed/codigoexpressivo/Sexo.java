package br.com.helmed.codigoexpressivo;

/**
 * User: helmed
 * Date: 5/24/13
 * Time: 6:54 PM
 */
public enum Sexo {
    MASCULINO(15),
    FEMININO(22),
    NAO_INFORMADO(-1);

    private final int codigo;

    Sexo(int codigo) {
        this.codigo = codigo;
    }

    protected int getCodigo() {
        return codigo;
    }

    public static Sexo peloCodigo(final int codigo){
        Sexo sexo = NAO_INFORMADO;

        if(MASCULINO.getCodigo() == codigo) sexo = MASCULINO;
        else if(FEMININO.getCodigo() == codigo) sexo = FEMININO;

        return sexo;
    }
}
