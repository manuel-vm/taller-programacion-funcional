package org.taller.introduccion;
/**
Una función es referencialmente transparente si, para una misma entrada,
siempre produce la misma salida, sin depender de ningún estado externo.
 */

public class TransparenciaReferencial {

    //* Función PURA: siempre devuelve lo mismo para la misma entrada
    public static int sumaPura(int a, int b) {
        return a + b;
    }

    //* Función IMPURA: su resultado depende de un estado externo y mutable
    private static int acumulador = 0;
    public static int sumaImpura(int a, int b) {
        acumulador += a + b;
        return acumulador; // ? El resultado cambia si 'acumulador' cambia
    }

    public static void main(String[] args) {
        System.out.println("Suma pura (5, 3): " + sumaPura(5, 3)); //? Siempre será 8
        System.out.println("Suma pura (5, 3): " + sumaPura(5, 3)); //? Sigue siendo 8

        System.out.println("Suma impura (5, 3): " + sumaImpura(5,3)); //? Resultado: 8
        System.out.println("Suma impura (5, 3): " + sumaImpura(5,3)); //? Resultado: 16 (¡diferente!)
    }
}