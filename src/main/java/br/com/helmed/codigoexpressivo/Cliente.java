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
        if(cpf == null || cpf.isEmpty()) throw new IllegalArgumentException("Nome deve ser preenchido");
        this.sexo = Sexo.peloCodigo(sexo);
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }
}
