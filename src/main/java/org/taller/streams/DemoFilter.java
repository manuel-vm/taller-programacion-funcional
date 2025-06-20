package org.taller.streams;
/**

Métodos clave: Internamente, la operación filter() de un Stream usa
la interfaz Predicate<T> y su método boolean test(T t)
Ejemplo práctico: De una lista de correos, quedarnos solo con los no leídos.
*/


import java.util.List;
import java.util.stream.Collectors;

public class DemoFilter {
    public static void main(String[] args) {
        List<String> emails = List.of(
                "importante: Capacitación con Manuel (leído)",
                "spam (leído)",
                "URGENTE: No leer (leído)",
                "Descuento especial para ti"
        );

        List<String> correosNoLeidos = emails.stream()
                .filter(email -> !email.contains("(leído)")) // ? La regla: si no contiene "(leído)", pasa.
                .collect(Collectors.toList());

        System.out.println("Correos no leídos: " + correosNoLeidos);
    }
}