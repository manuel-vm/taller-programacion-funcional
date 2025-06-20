package org.taller.lambdas.bifunction;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        /**
         * BiFunction: recibe dos valores y retorna un resultado
         */
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum; // (a, b) -> a + b>
        System.out.println(biFunction.apply(20,30));
    }
}
