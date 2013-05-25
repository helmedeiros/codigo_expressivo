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

    private static final int MASCULINO = 15;
    private static final int FEMININO = 22;
    private static final int SEXO_COMPRADOR_INEXISTENTE = 999;
    private static final int VALOR_DA_COMPRA_QUALQUER = 100;
    private static final int VALOR_COMPRA_ABAIXO_DE_MIL = 900;
    private static final int VALOR_COMPRA_IGUAL_A_MIL = 1000;
    private static final int DELTA_ACEITAVEL = 0;
    private static final Cliente CLIENTE_HOMEM = new Cliente(MASCULINO);
    private static final Cliente CLIENTE_MULHER = new Cliente(FEMININO);
    private static final Cliente CLIENTE_SEXO_NAO_INFORMADO = new Cliente(SEXO_COMPRADOR_INEXISTENTE);

    @Test public void testDeveAplicarDescontoSeSexoCompradorMasculino() throws Exception {

        final Venda vendaParaUmHomem = new Venda(CLIENTE_HOMEM, comValor(100));
        final double expected = 85;
        assertEquals("Valor final não sofreu 15% de desconto",expected,vendaParaUmHomem.vender(), DELTA_ACEITAVEL);
    }

    @Test public void testDeveAplicarDescontoSeSexoFemininoECompraMAiorQueMil() throws Exception {
        Venda vendaParaMulherAcimaDeMil = new Venda(CLIENTE_MULHER, comValor(1001));
        double valorFinalEsperado = 900.9;
        assertEquals("Valor final não sofreu 10% de desconto",valorFinalEsperado,vendaParaMulherAcimaDeMil.vender(), DELTA_ACEITAVEL);
    }

    @Test
    public void testNaoDeveAplicarQualquerDescontoQuandoNaoCairEmPromocoes() throws Exception {
        verificaSeValorDaCompraNaoFoiAfetado(CLIENTE_SEXO_NAO_INFORMADO, VALOR_DA_COMPRA_QUALQUER);
        verificaSeValorDaCompraNaoFoiAfetado(CLIENTE_MULHER, VALOR_COMPRA_ABAIXO_DE_MIL);
        verificaSeValorDaCompraNaoFoiAfetado(CLIENTE_MULHER, VALOR_COMPRA_IGUAL_A_MIL);
    }

    private void verificaSeValorDaCompraNaoFoiAfetado(Cliente cliente, int valorDaCompra) {
        final Venda vendaSemPromocao = new Venda(cliente, comValor(valorDaCompra));
        assertEquals("Valor final não deveria ter descontos", valorDaCompra, vendaSemPromocao.vender(), DELTA_ACEITAVEL);
    }

    private double comValor(double valorDaCompra) {
        return valorDaCompra;
    }
}
