package org.taller.introduccion;
import java.util.List;

// * Ejemplo: Sumar los números pares de una lista
public class EstiloDeclarativo {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
        int suma = numeros.stream()        // ? Convierte la lista en un stream
                .filter(n -> n % 2 == 0)   // ? Filtramos los números pares
                .mapToInt(n -> n)          // ? Conviértelos a un stream de enteros
                .sum();                    // ? Súmalos
        System.out.println("Suma declarativa: " + suma); // ? Salida: 12
    }
}