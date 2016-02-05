Final course project
======================

### Mini-mathematica
**Mini-mathematica** is a program that properly computes mathematical expressions over the following
operations and functions:

_1. Arithmetic:_
* Addition: `+`
* Substraction: `-` 
* Negation: `-`
* Multiplication: `*`
* Division: `/`

_2. Advanced:_
* Exponentiation: `pow(x, n)`, `x^n`, or`x^(-n)`
* Square root: `sqrt(x)`, `pow(x, 0.5)` or `x^0.5`
* Nth root: `pow(x, 1/n)` or `x^(1/n)`
* Logarithms: `log(base, n)`
* Max/Min: `max(x, y)` or `min(x, y)`

_3. Trigonometric:_
* Sine `sin(x)`
* Cosine `cos(x)`
* Tangent `tg(x)`
* Cotangent `cotg(x)`,
where `x` = radians

_4. Constants_
* pi `pi`
* e `e`

One example expression would be:

```
5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))
```
The program should output `3` on the example above.

Using [shunting yard](http://en.wikipedia.org/wiki/Shunting-yard_algorithm) and
[reverse polish notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation).
