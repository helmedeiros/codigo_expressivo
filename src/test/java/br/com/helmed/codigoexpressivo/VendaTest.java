package br.com.helmed.codigoexpressivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for {@link Venda}.
 * User: helmed
 * Date: 5/23/13
 * Time: 5:17 PM
 */
public class VendaTest {
    @Test public void testDeveAplicarDescontoSeSexoCompradorMasculino() throws Exception {
        final Venda vendaParaUmHomem = new Venda(15, 100);
        final double expected = 85;
        assertEquals("Valor final não sofreu 15% de desconto",expected,vendaParaUmHomem.vender(),0);
    }

    @Test
    public void testNaoDeveAplicarQualquerDescontoQuandoNaoCairEmPromocoes() throws Exception {
        final Venda vendaSemPromocao = new Venda(999,100);
        assertEquals("Valor final não deveria ter descontos", 100, vendaSemPromocao.vender(), 0);

    }
}
