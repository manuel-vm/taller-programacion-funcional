package org.taller.lambdas.unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        /**
         * UnaryOperator: recibe un valor y retorna un resultado
         */
        UnaryOperator<Integer> unaryOperator = (num) -> num * 2;
        System.out.println(unaryOperator.apply(20));
    }
}
