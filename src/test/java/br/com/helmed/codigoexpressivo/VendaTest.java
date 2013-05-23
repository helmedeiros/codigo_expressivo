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

    public static final int MASCULINO = 15;
    private static final int FEMININO = 22;
    public static final int SEXO_COMPRADOR_INEXISTENTE = 999;
    public static final int VALOR_DA_COMPRA_QUALQUER = 100;
    public static final int VALOR_COMPRA_ABAIXO_DE_MIL = 900;
    public static final int VALOR_COMPRA_IGUAL_A_MIL = 1000;

    @Test public void testDeveAplicarDescontoSeSexoCompradorMasculino() throws Exception {
        final Venda vendaParaUmHomem = new Venda(MASCULINO, 100);
        final double expected = 85;
        assertEquals("Valor final não sofreu 15% de desconto",expected,vendaParaUmHomem.vender(),0);
    }

    @Test public void testDeveAplicarDescontoSeSexoFemininoECompraMAiorQueMil() throws Exception {
        Venda vendaParaMulherAcimaDeMil = new Venda(FEMININO, 1001);
        double valorFinalEsperado = 900.9;
        assertEquals("Valor final não sofreu 10% de desconto",valorFinalEsperado,vendaParaMulherAcimaDeMil.vender(),0);
    }

    @Test
    public void testNaoDeveAplicarQualquerDescontoQuandoNaoCairEmPromocoes() throws Exception {
        verificaSeValorDaCompraNaoFoiAfetado(SEXO_COMPRADOR_INEXISTENTE, VALOR_DA_COMPRA_QUALQUER);
        verificaSeValorDaCompraNaoFoiAfetado(FEMININO, VALOR_COMPRA_ABAIXO_DE_MIL);
        verificaSeValorDaCompraNaoFoiAfetado(FEMININO, VALOR_COMPRA_IGUAL_A_MIL);
    }

    private void verificaSeValorDaCompraNaoFoiAfetado(int sexoComprador, int valorDaCompra) {
        final Venda vendaSemPromocao = new Venda(sexoComprador, valorDaCompra);
        assertEquals("Valor final não deveria ter descontos", valorDaCompra, vendaSemPromocao.vender(), 0);
    }
}
