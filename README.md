Código Expressivo? Onde? [![Build Status](https://travis-ci.org/helmedeiros/codigo_expressivo.png?branch=master)](https://travis-ci.org/helmedeiros/codigo_expressivo)
=================

Revisitando alguns post do blog do Phil Calcado [@pcalcado](https://twitter.com/pcalcado), achei esta pérola sobre expressividade de código. 
"Você está pronto para alterar este código. Hmm… alterar pode ser muito rápido e sujo ou devagar e bem feito. Como disse o Uncle Bob recentemente sujo nunca é rápido então você opta pelo caminho com mais qualidade (e mais ético)."

Imagine que você recebeu um email do seu usuário dizendo: “Precisamos fazer com que clientes do sexo feminino que comprem mais de R$1000,00 ganhem 10% de desconto.”. Tente implementar isso no código a baixo enquanto eu vou almoçar.

Após umas cinquenta páginas de diagramas de alto nível inúteis explicando tudo que acontece no container web você chega a uma descrição de algo como:

> A classe A tem a lógica abstrata de uma venda. As vendas são sempre feitas de acordo com critérios específicos por isso existem classes que implementam vendas específicas. No momento (01/10/2003) só existe uma implementação, na classe B, que é a venda para uma pessoa física.

> O méodo e questão recebe três argumentos: a quantdade em reais vendida, o sexo da pessoa (segundo código vindo do mainframe na tabela ETXS32) e se a compra é casada ou não (um booleano).

> De acordo com o caso de uso UC171 o sexo do comprador é utilizado para aplicar descontos.

> Se a compra for casada o processamento é feito delegando para outra classe, mantendo o padrão Strategy, Composite e Adapter do Decorator. Note que o Chain of Responsibility do Bridge é usado com Visitors para passar as instâncias de Flyweight pelos Interpreters[...]


TABELA ETXS32

| Código        | Sexo           |
| ------------- | -------------:|
| 15      | masculino |
| 22      | feminino  |


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
        if(this.z==15) return this.x - this.x * 0.15;
        else return this.x;
    }
}
```
