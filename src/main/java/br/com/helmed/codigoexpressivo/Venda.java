package br.com.helmed.codigoexpressivo;
/**
 * User: helmed
 * Date: 5/23/13
 * Time: 4:57 PM
 */
public class Venda extends VendaAbstrata {

    private Sexo sexoComprador = Sexo.NAO_INFORMADO;
    private double valorDaCompra = -1;

    public Venda(int sexoComprador, double valorDaCompra) {
        this.sexoComprador = Sexo.peloCodigo(sexoComprador);
        this.valorDaCompra = valorDaCompra;
    }

    public double vender() {
        return aplicarDescontosSobreValorDaCompra();
    }

    private double aplicarDescontosSobreValorDaCompra() {
        double valorComDesconto = this.valorDaCompra;

        if(this.sexoComprador == Sexo.MASCULINO) {
            valorComDesconto = descontarPorcentagem(15, valorComDesconto);
        } else if (this.sexoComprador == Sexo.FEMININO && valorComDesconto > 1000){
            valorComDesconto = descontarPorcentagem(10, valorComDesconto);
        }

        return valorComDesconto;
    }

    private double descontarPorcentagem(double porcentagem, double valorOriginalDaCompra) {
        return valorOriginalDaCompra - (valorOriginalDaCompra * (porcentagem/100));
    }
}
