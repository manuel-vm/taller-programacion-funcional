package org.taller.streams;
/**
 *  Reduce (operación de Stream) — Es como hacer una bola de nieve gigante. Empiezas con una bolita pequeña
(un valor inicial) y la haces rodar. Con cada vuelta, recoge más nieve (el siguiente elemento de la lista)
y se combina con la que ya tenías, haciéndose más grande. Al final, te quedas con una única y gran bola de nieve (el resultado final).

Métodos clave: La operación reduce() usa un BinaryOperator<T> (una BiFunction especializada) y su método T apply(T t, T u).

Ejemplo práctico: Sumar todos los precios de una lista de compras para obtener el total.
*/

import java.util.List;

public class DemoReduce {
    public static void main(String[] args) {
        List<Double> precios = List.of(15.50, 20.00, 7.25, 100.00);

        //* El 0.0 es la "bola de nieve inicial".
        //* (subtotal, precio) -> subtotal + precio es la forma de "acumular la nieve".
        Double total = precios
                .stream()
                .reduce(0.0, Double::sum);

        System.out.printf("El total de la compra es: $%.2f%n", total);
    }
}