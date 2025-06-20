package org.taller.lambdas.runnable;

public class RunnableExample {
    public static void main(String[] args) {
        /**
         * Runnable: no recibe ningun valor, pero retorna un resultado.
         */
        Runnable runnable = () -> System.out.println("I am a runnable");
        runnable.run();
    }
}
