package org.taller.introduccion;
import java.util.function.Function;

/**
  Composición de Funciones: Saludo Personalizado
  La composición nos permite encadenar funciones simples para crear una más compleja.
  Aquí, unimos una función que extrae un nombre con otra que saluda, creando
  una nueva función que hace tod0 el proceso de una sola vez.
*/
public class DemoComposicionSimple {

    public static void main(String[] args) {

        // ? Función 1: Recibe un nombre completo y devuelve solo el primer nombre.
        // ? ej: "Diana Rojas" -> "Diana"
        Function<String, String> extraerPrimerNombre = nombreCompleto -> nombreCompleto.split(" ")[0];

        // ? Función 2: Recibe un nombre y le añade un saludo.
        // ? ej: "Diana" -> "¡Bienvenida, Diana!"
        Function<String, String> crearSaludo = nombre -> "¡Bienvenida, " + nombre + "!";


        // ? COMPOSICIÓN: Creamos una nueva función que primero extrae el nombre
        // ?/ y LUEGO (andThen) crea el saludo con el resultado.
        Function<String, String> generarSaludoCompleto = extraerPrimerNombre.andThen(crearSaludo);


        //?  --- Ejecución ---
        String usuario = "Laura Victoria Gómez";

        //?  Al aplicar la función compuesta, se ejecutan ambas en orden.
        String saludoFinal = generarSaludoCompleto.apply(usuario);

        System.out.println("Entrada: " + usuario);
        System.out.println("Salida : " + saludoFinal); //? Imprime "¡Bienvenida, Laura!"
    }
}