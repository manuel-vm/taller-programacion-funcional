package org.taller.lambdas.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        /**
         * Predicate: recibe un valor y retorna un booleano
         */
        Predicate<Integer> predicate = (num) -> num > 0;
    }
}
