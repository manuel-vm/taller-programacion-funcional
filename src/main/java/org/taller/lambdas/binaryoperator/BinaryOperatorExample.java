package org.taller.lambdas.binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        /**
         * BinaryOperator: recibe dos valores de un mismo tipo y retorna un resultado
         */
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
        System.out.println(binaryOperator.apply(20,30));
    }
}
