package br.com.helmed.codigoexpressivo;

import org.junit.Before;
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

    private static Cliente clienteHomem;
    private static Cliente clienteMulher;
    private static Cliente clienteSexoNaoInformado;

    @Before public void setup(){
        clienteHomem = new Cliente("12312312312",MASCULINO);
        clienteMulher = new Cliente("12312312312",FEMININO);
        clienteSexoNaoInformado = new Cliente("12312312312",SEXO_COMPRADOR_INEXISTENTE);
    }

    @Test public void testDeveAplicarDescontoSeSexoCompradorMasculino() throws Exception {

        final Venda vendaParaUmHomem = new Venda(clienteHomem, comValor(100));
        final double expected = 85;
        assertEquals("Valor final não sofreu 15% de desconto",expected,vendaParaUmHomem.vender(), DELTA_ACEITAVEL);
    }

    @Test public void testDeveAplicarDescontoSeSexoFemininoECompraMAiorQueMil() throws Exception {
        Venda vendaParaMulherAcimaDeMil = new Venda(clienteMulher, comValor(1001));
        double valorFinalEsperado = 900.9;
        assertEquals("Valor final não sofreu 10% de desconto",valorFinalEsperado,vendaParaMulherAcimaDeMil.vender(), DELTA_ACEITAVEL);
    }

    @Test
    public void testNaoDeveAplicarQualquerDescontoQuandoNaoCairEmPromocoes() throws Exception {
        verificaSeValorDaCompraNaoFoiAfetado(clienteSexoNaoInformado, VALOR_DA_COMPRA_QUALQUER);
        verificaSeValorDaCompraNaoFoiAfetado(clienteMulher, VALOR_COMPRA_ABAIXO_DE_MIL);
        verificaSeValorDaCompraNaoFoiAfetado(clienteMulher, VALOR_COMPRA_IGUAL_A_MIL);
    }

    private void verificaSeValorDaCompraNaoFoiAfetado(Cliente cliente, int valorDaCompra) {
        final Venda vendaSemPromocao = new Venda(cliente, comValor(valorDaCompra));
        assertEquals("Valor final não deveria ter descontos", valorDaCompra, vendaSemPromocao.vender(), DELTA_ACEITAVEL);
    }

    private double comValor(double valorDaCompra) {
        return valorDaCompra;
    }
}
