package org.taller.lambdas.consumer;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

// * Recibe un valor y no retorna nada (void)
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = String::toLowerCase;
        consumer.accept("Hello");
        Consumer<String> consumerSimpler =  System.out::println;
        consumer.accept("Hello");
        consumerSimpler.accept("Hello");
        List<String> lista = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    }
}