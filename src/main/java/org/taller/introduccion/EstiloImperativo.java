package org.taller.introduccion;
import java.util.List;

// *  Ejemplo: Sumar los números pares de una lista
public class EstiloImperativo {
    public static void main(String[] args) {

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
        int suma = 0;

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                suma += numero;
            }
        }
        System.out.println("Suma imperativa: " + suma); //? Salida: 12
    }
}