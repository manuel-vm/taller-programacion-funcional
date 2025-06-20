package org.taller.introduccion;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * <p>En Java, las <em>expresiones lambda</em> y las <em>interfaces funcionales</em>
 * elevan el comportamiento (fragmentos de código) a ciudadanos de primera clase.
 * Esto nos permite:</p>
 *
 * <ul>
 *   <li>Pasar funciones como argumentos a métodos.</li>
 *   <li>Devolver funciones como resultado de otros métodos.</li>
 *   <li>Guardar referencias a comportamientos en variables o colecciones.</li>
 * </ul>
 *
 * <p>De manera que podemos encadenar (componer) pequeñas funciones
 * puras hasta construir operaciones complejas de forma declarativa, manteniendo
 * el código legible, reutilizable y expresivo.</p>
 */
public class FuncionesDePrimeraClase {

    //? Este método acepta una lista y una función (Predicate) como argumentos
    public static List<String> filtrar(List<String> lista, Predicate<String> condicion) {
        return lista.stream()
                .filter(condicion)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> nombres = List.of("Carlos", "Ana", "Cristina", "Andrés");

        //? Pasamos una función lambda que define la condición de filtro
        Predicate<String> empiezaConA = texto -> texto.startsWith("A");
        List<String> nombresConA = filtrar(nombres, empiezaConA);
        System.out.println("Nombres que empiezan con A: " + nombresConA);

        //? También podemos pasar la función directamente en la llamada
        List<String> nombresLargos = filtrar(nombres, texto -> texto.length() > 5);
        System.out.println("Nombres con más de 5 letras: " + nombresLargos);
    }
}