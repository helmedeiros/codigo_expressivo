package br.com.helmed.codigoexpressivo;
/**
 * User: helmed
 * Date: 5/23/13
 * Time: 4:57 PM
 */
public class Venda extends VendaAbstrata {
    public static final int MASCULINO = 15;
    public static final int NAO_INFORMADO = -1;
    private static final int FEMININO = 22;

    private int sexoComprador = NAO_INFORMADO;
    private double valorDaCompra = -1;

    public Venda(int sexoComprador, double valorDaCompra) {
        this.sexoComprador = sexoComprador;
        this.valorDaCompra = valorDaCompra;
    }

    @Override
    public double vender() {
        return aplicarDescontosSobreValorDaCompra();
    }

    private double aplicarDescontosSobreValorDaCompra() {
        double valorComDesconto = this.valorDaCompra;

        if(this.sexoComprador == MASCULINO) {
            valorComDesconto = descontarPorcentagem(15, valorComDesconto);
        } else if (this.sexoComprador == FEMININO && valorComDesconto > 1000){
            valorComDesconto = descontarPorcentagem(10, valorComDesconto);
        }

        return valorComDesconto;
    }

    private double descontarPorcentagem(double porcentagem, double valorOriginalDaCompra) {
        return valorOriginalDaCompra - (valorOriginalDaCompra * (porcentagem/100));
    }
}
