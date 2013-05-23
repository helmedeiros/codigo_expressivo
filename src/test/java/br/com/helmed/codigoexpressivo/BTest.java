package br.com.helmed.codigoexpressivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link B}.
 * User: helmed
 * Date: 5/23/13
 * Time: 5:17 PM
 */
public class BTest {
    @Test public void testDeveAplicarDescontoSeSexoCompradorMasculino() throws Exception {
        final B vendaParaUmHomem = new B(15, 100);
        final double expected = 85;
        assertEquals("Valor final não sofreu 15% de desconto",expected,vendaParaUmHomem.d(),0);
    }

    @Test
    public void testNaoDeveAplicarQualquerDescontoQuandoNaoCairEmPromocoes() throws Exception {
        final B vendaSemPromocao = new B(999,100);
        assertEquals("Valor final não deveria ter descontos", 100, vendaSemPromocao.d(), 0);

    }
}
