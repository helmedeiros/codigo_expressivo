package br.com.helmed.codigoexpressivo;

/**
 * User: helmed
 * Date: 5/25/13
 * Time: 3:18 PM
 */
public class Cliente {
    private final Sexo sexo;
    private final String cpf;

    public Cliente (final String cpf, final int sexo){
        if("".equals(cpf)) throw new IllegalArgumentException("Nome deve ser preenchido");
        this.sexo = Sexo.peloCodigo(sexo);
        this.cpf = cpf;
    }

    public Cliente(final int sexo) {
        this("",sexo);
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }
}
