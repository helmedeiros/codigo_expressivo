package br.com.helmed.codigoexpressivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: helmed
 * Date: 5/25/13
 * Time: 4:05 PM
 */
public class ClienteTest {

    public static final String QUALQUER_CPF = "12312312332";
    public static final Sexo QUALQUER_SEXO = Sexo.MASCULINO;
    public static final int CODIGO_QUALQUER_SEXO = QUALQUER_SEXO.getCodigo();

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarClientesSemCpf() throws Exception {
        new Cliente(CODIGO_QUALQUER_SEXO);
    }

    @Test public void deveRetornarCpfDoCliente() throws Exception {
        final String cpfEsperado = QUALQUER_CPF;
        final Cliente clienteComCpf = new Cliente(cpfEsperado, CODIGO_QUALQUER_SEXO);

        assertEquals("O cpf informado não foi retornado", cpfEsperado, clienteComCpf.getCpf());
    }

    @Test public void deveRetornarSexoDoCliente() throws Exception {
        final Sexo sexoEsperado = QUALQUER_SEXO;
        final int codigoSexoEsperado = CODIGO_QUALQUER_SEXO;

        Cliente clienteComCpfESexo = new Cliente(QUALQUER_CPF, codigoSexoEsperado);
        assertEquals("O sexo informado não foi retornado", sexoEsperado, clienteComCpfESexo.getSexo());
    }
}
