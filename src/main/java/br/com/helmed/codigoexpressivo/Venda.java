package br.com.helmed.codigoexpressivo;
/**
 * User: helmed
 * Date: 5/23/13
 * Time: 4:57 PM
 */
public class Venda extends VendaAbstrata {
    public static final int MASCULINO = 15;
    public static final int NAO_INFORMADO = -1;

    private int sexoComprador = NAO_INFORMADO;
    private double valorDaCompra = -1;

    public Venda(int sexoComprador, double valorDaCompra) {
        this.sexoComprador = sexoComprador;
        this.valorDaCompra = valorDaCompra;
    }

    @Override
    public double vender() {
        if(this.sexoComprador == MASCULINO) return this.valorDaCompra - this.valorDaCompra * 0.15;
        else return this.valorDaCompra;
    }
}
