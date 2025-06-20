package org.taller.lambdas.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        // * BiConsumer
        // * Recibe dos valores y no retorna nada.
        BiConsumer<String, String> biConsumer = (param1, param2) -> {
            System.out.println(param1 + " " + param2);
        };
        BiConsumer<String, String> biConsumerSimpler = (a,b) ->  System.out.println(a + " " + b);
        biConsumer.accept("Hello", "World");
        biConsumerSimpler.accept("Hello", "World");
    }
}
