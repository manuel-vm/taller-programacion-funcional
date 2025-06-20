package org.taller.streams;
/**
 * Toma cada elemento de una lista y lo transforma en OTRA COSA,
 * generando una nueva lista con los elementos ya transformados.
 * Métodos clave: Internamente, la operación map() de un Stream usa la interfaz Function<T, R> y su método R apply(T t).

Ejemplo práctico: De una lista de nombres de clientes, obtener una lista con la longitud de cada nombre.
*/

import java.util.List;
import java.util.stream.Collectors;

public class DemoMap {
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Bernardo", "Catalina");

        List<Integer> longitudes = nombres
                .stream()
                .map(nombre ->  nombre.length()) // ? La transformación: de String a su longitud (Integer).
                .collect(Collectors.toList());
        System.out.println("Longitud de cada nombre: " + longitudes);
    }

}
