package org.taller.introduccion;
// * Ejemplo: Calcular el factorial de un número
public class RecursionEnVezDeBucles {
    // * Versión con bucle
    public static int factorialConBucle(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // * Versión con recursión
    public static int factorialConRecursion(int n) {
        // ? Caso base: define cuándo detener la recursión
        if (n == 0) {
            return 1;
        }
        // ? Caso recursivo: la función se llama a sí misma con un problema más pequeño
        return n * factorialConRecursion(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial con bucle: " + factorialConBucle(5));       // * Salida: 120
        System.out.println("Factorial con recursión: " + factorialConRecursion(5)); // * Salida: 120
    }
}