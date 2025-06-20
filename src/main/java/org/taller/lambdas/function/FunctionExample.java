package org.taller.lambdas.function;

import java.util.function.Function;

//* Function: recibe un valor y retorna un resultado.
public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> function = (num) -> "El numero es: " + num;
        System.out.println(function.apply(5));
    }
}
