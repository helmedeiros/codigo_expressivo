package br.com.helmed.codigoexpressivo;
/**
 * User: helmed
 * Date: 5/23/13
 * Time: 4:57 PM
 */
public class B extends A {
    private int z;
    private double x;

    public B(int z, double x) {
        this.z = z;
        this.x = x;
    }

    @Override
    public double d() {
        if(this.z==15) return this.x - this.x * 0.15;
        else return this.x;
    }
}
