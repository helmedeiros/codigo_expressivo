package br.com.helmed.codigoexpressivo;

/**
 * User: helmed
 * Date: 5/25/13
 * Time: 3:18 PM
 */
public class Cliente {
    private final Sexo sexo;

    public Cliente(final int sexo) {
        this.sexo = Sexo.peloCodigo(sexo);
    }

    public Sexo getSexo() {
        return sexo;
    }
}
