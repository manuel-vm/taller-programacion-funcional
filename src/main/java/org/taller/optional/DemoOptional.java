package org.taller.optional;

/**
 * Imagina que null es ese amigo que a veces se aparece a la fiesta… y a veces no, pero nunca avisa.
 * Optional es la invitación formal: te dice explícitamente “puede que venga alguien, puede que no, pero aquí está la lista”.
 * Esa transparencia—saber desde el tipo mismo si habrá valor—es puro espíritu funcional:
 */

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

public class DemoOptional {

    //? Simulamos una base de datos de usuarios
    private static List<Usuario> usuarios = Arrays.asList(
            new Usuario(1, "Ana", "ana@email.com"),
            new Usuario(2, "Carlos", "carlos@email.com"),
            new Usuario(3, "María", null) // Usuario sin email
    );

    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE OPTIONAL EN JAVA ===\n");

        //? 1. CREANDO OPTIONAL - Las tres formas principales
        ejemploCreacionOptional();

        //? 2. USANDO OPTIONAL DE FORMA PRÁCTICA
        ejemploPractico();

        //? 3. MÉTODOS FUNCIONALES DE OPTIONAL
        ejemploMetodosFuncionales();
    }

    // ? ==================== CREACIÓN DE OPTIONAL ====================
    private static void ejemploCreacionOptional() {
        System.out.println("1. CREANDO OPTIONAL:\n");

        //? Forma 1: Optional.of() - cuando SABEMOS que el valor NO es null
        Optional<String> nombreCompleto = Optional.of("Juan Pérez");
        System.out.println("Optional.of(): " + nombreCompleto);

        //? Forma 2: Optional.ofNullable() - cuando el valor PUEDE ser null
        String emailPosiblementeNull = null;
        Optional<String> email = Optional.ofNullable(emailPosiblementeNull);
        System.out.println("Optional.ofNullable(): " + email);

        //? Forma 3: Optional.empty() - cuando queremos un Optional vacío
        Optional<String> telefono = Optional.empty();
        System.out.println("Optional.empty(): " + telefono);

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    //? ==================== EJEMPLO PRÁCTICO ====================
    private static void ejemploPractico() {
        System.out.println("2. EJEMPLO PRÁCTICO - BUSCAR USUARIO:\n");

        //? Buscamos usuarios que pueden o no existir
        System.out.println("Buscando usuario con ID 1:");
        Optional<Usuario> usuario1 = buscarUsuario(1);
        manejarUsuario(usuario1);

        System.out.println("\nBuscando usuario con ID 999 (no existe):");
        Optional<Usuario> usuarioInexistente = buscarUsuario(999);
        manejarUsuario(usuarioInexistente);

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    // ? ==================== MÉTODOS FUNCIONALES ====================
    private static void ejemploMetodosFuncionales() {
        System.out.println("3. MÉTODOS FUNCIONALES DE OPTIONAL:\n");

        Optional<Usuario> usuario = buscarUsuario(1);

        //? map() - Transforma el valor si está presente
        Optional<String> nombreEnMayusculas = usuario.map(u -> u.nombre.toUpperCase());
        System.out.println("Nombre en mayúsculas: " + nombreEnMayusculas.orElse("Sin nombre"));

        //? filter() - Filtra basado en una condición
        Optional<Usuario> usuarioConEmailValido = usuario.filter(u -> u.email != null && u.email.contains("@"));
        System.out.println("Usuario con email válido: " + usuarioConEmailValido.isPresent());

        //? flatMap() - Para transformaciones que devuelven Optional
        Optional<String> dominioEmail = usuario.flatMap(this::extraerDominio);
        System.out.println("Dominio del email: " + dominioEmail.orElse("Sin dominio"));

        //? Ejemplo con usuario sin email
        System.out.println("\nProbando con usuario sin email:");
        Optional<Usuario> usuarioSinEmail = buscarUsuario(3);
        Optional<String> dominioSinEmail = usuarioSinEmail.flatMap(this::extraerDominio);
        System.out.println("Dominio del email: " + dominioSinEmail.orElse("Sin dominio"));
    }

    //? ==================== MÉTODOS AUXILIARES ====================

    //? Simula buscar un usuario en la base de datos
    private static Optional<Usuario> buscarUsuario(int id) {
        return usuarios.stream()
                .filter(u -> u.id == id)
                .findFirst(); // findFirst() devuelve Optional<Usuario>
    }

    //? Maneja un Optional<Usuario> de forma segura
    private static void manejarUsuario(Optional<Usuario> usuarioOpt) {
        // ? Forma 1: isPresent() y get() (no recomendado para principiantes)
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            System.out.println("Usuario encontrado: " + usuario.nombre);
        } else {
            System.out.println("Usuario no encontrado");
        }

        // ? Forma 2: orElse() - Proporciona un valor por defecto
        Usuario usuario = usuarioOpt.orElse(new Usuario(0, "Desconocido", "sin-email"));
        System.out.println("Usuario (con valor por defecto): " + usuario.nombre);

        // ? Forma 3: ifPresent() - Ejecuta código solo si hay valor (PROGRAMACIÓN FUNCIONAL)
        usuarioOpt.ifPresent(u -> System.out.println("Email del usuario: " +
                (u.email != null ? u.email : "Sin email")));

        // ? Forma 4: orElseThrow() - Lanza excepción si no hay valor
        try {
            Usuario usuarioSeguro = usuarioOpt.orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado"));
            System.out.println("Usuario obtenido de forma segura: " + usuarioSeguro.nombre);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ? Extrae el dominio de un email, devolviendo Optional
    private Optional<String> extraerDominio(Usuario usuario) {
        if (usuario.email != null && usuario.email.contains("@")) {
            String dominio = usuario.email.split("@")[1];
            return Optional.of(dominio);
        }
        return Optional.empty(); // No hay email válido
    }

    // ? ==================== CLASE USUARIO ====================
    static class Usuario {
        int id;
        String nombre;
        String email;

        Usuario(int id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }
    }
}

/**
=== ¿POR QUÉ OPTIONAL ES PROGRAMACIÓN FUNCIONAL? ===

1. INMUTABILIDAD: Optional es inmutable, no cambia después de crearse

2. COMPOSICIÓN DE FUNCIONES: Los métodos map(), filter(), flatMap()
   permiten encadenar operaciones de forma fluida

3. EVITA EFECTOS SECUNDARIOS: En lugar de modificar variables o lanzar
   excepciones, devuelve nuevos Optional

4. FUNCIONES DE ORDEN SUPERIOR: Acepta funciones como parámetros
   (lambdas, referencias a métodos)

5. MANEJO DECLARATIVO: Describes QUÉ quieres hacer, no CÓMO hacerlo

Ejemplo de estilo funcional:
usuario.map(User::getName)           // Transformación
       .filter(name -> name.length() > 3)  // Filtrado
       .map(String::toUpperCase)     // Otra transformación
       .ifPresent(System.out::println); // Acción final

Esto es más limpio y expresivo que múltiples if-else y assignments.
*/
