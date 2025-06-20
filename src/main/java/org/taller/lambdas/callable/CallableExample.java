package org.taller.lambdas.callable;

import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) {
        /**
         * Callable: no recibe ningun valor, pero retorna un resultado.
         * puede lanzar una Exception
         */
        Callable<String> callable = () -> "I am a callable";
        try {
            String callableValue = callable.call();
            System.out.println(callableValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
