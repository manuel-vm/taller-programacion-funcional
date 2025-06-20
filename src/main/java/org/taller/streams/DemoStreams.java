package org.taller.streams;

import java.util.List;

public class DemoStreams {
    private static List<String> list = List.of("z", "Ana", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public static void main(String[] args) {

        // ? Map: Transformar elementos de un tipo a otro mediante una funcion.
        list.stream().
                map((name) -> name.toUpperCase()).
                forEach(System.out::print);
        // ? Sorted : Ordenar elementos de una coleccion.
        System.out.println();
        list.stream().
                sorted().
                forEach(System.out::print);
        // ? Reduce: Reducir elementos de una coleccion a un unico valor.
        System.out.println();
        System.out.println(list.stream().reduce((a, b) -> a + ", " + b).get());
        // ? Collect: Recoger elementos de una coleccion en una coleccion.
        List<String> collection = list.stream().map(String::toUpperCase).toList();
        System.out.println("Print collection: ");
        collection.forEach(System.out::print);
        //? Distinct: Eliminar elementos duplicados de una coleccion.
        System.out.println();
        System.out.println("Print distinct collection: ");
        list.stream().distinct().forEach(System.out::print);
        // ? Limit: Limitar la cantidad de elementos de una coleccion.
        System.out.println();
        System.out.println("Print limit collection: ");
        list.stream().limit(5).forEach(System.out::print);
        // ? Limit: Limitar la cantidad de elementos de una coleccion.
        System.out.println();
        System.out.println("Print limit collection: ");
        list.stream().limit(5).forEach(System.out::print);
        // ? Skip: Saltar elementos de una coleccion.
        System.out.println();
        System.out.println("Print skip collection: ");
        list.stream().skip(10).forEach(System.out::print);
        //? anyMatch: Verificar si al menos un elemento de una coleccion cumple una condicion.
        System.out.println();
        System.out.println("Print anyMatch collection: ");
        System.out.println(list.stream().anyMatch((name) -> name.startsWith("a")));
        //? allMatch: Verificar si todos los elementos de una coleccion cumplen una condicion.
        System.out.println();
        System.out.println("Print allMatch collection: ");
        System.out.println(list.stream().allMatch((name) -> name.startsWith("a")));
        // ? AllMatch: Verificar si todos los elementos de una coleccion cumplen una condicion.
        System.out.println("Print allMatch collection: ");
        System.out.println(list.stream().allMatch((name) -> name.startsWith("0")));

        // ? noneMatch: Verificar si ningun elemento de una coleccion cumple una condicion.
        System.out.println();
        System.out.println("Print noneMatch collection: ");
        System.out.println(list.stream().noneMatch((name) -> name.startsWith("a")));
    }

    private static void filtrar() {
        // ? Filter: Filtrar elementos que cumplen una condicion.
        list.stream().
                filter((name) -> name.startsWith("a")).
                forEach(System.out::print);
    }
}
