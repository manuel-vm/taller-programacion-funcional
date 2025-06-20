package org.taller.lambdas.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        /**
         * BiPredicate: recibe dos valores y retorna un booleano
         */
        BiPredicate<Integer, Integer> biPredicate = (num1, num2) -> num1 > num2;
        System.out.println(biPredicate.test(20, 30));
    }
}
