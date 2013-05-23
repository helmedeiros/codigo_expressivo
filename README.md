Código Expressivo? Onde? 
=================

Revisitando alguns post do blog do Phil Calcado, achei esta pérola sobre expressividade de código. 
"Você está pronto para alterar este código. Hmm… alterar pode ser muito rápido e sujo ou devagar e bem feito. Como disse o Uncle Bob recentemente sujo nunca é rápido então você opta pelo caminho com mais qualidade (e mais ético)."

Imagine que você recebeu um email do seu usuário dizendo: “Precisamos fazer com que clientes do sexo feminino que comprem mais de R$1000,00 ganhem 10% de desconto.”. Tente implementar isso no código a baixo enquanto eu vou almoçar.


```java
public abstract class A {
    public abstract double d();
}
```
```java
public class B extends A {
    private int z;
    private double x;

    public B(int z, double x) {
        this.z = z;
        this.x = x;
    }

    @Override
    public double d() {
        if(this.z==15) return this.x + this.x * 0.15;
        else return this.x;
    }
}
```
