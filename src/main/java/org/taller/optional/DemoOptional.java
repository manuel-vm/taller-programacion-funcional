package org.taller.optional;

/**
 * Imagina que null es ese amigo que a veces se aparece a la fiesta… y a veces no, pero nunca avisa.
 * Optional es la invitación formal: te dice explícitamente “puede que venga alguien, puede que no, pero aquí está la lista”.
 * Esa transparencia—saber desde el tipo mismo si habrá valor—es puro espíritu funcional:
 */
package org.taller.optional;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

public class DemoOptional {

    // Simulamos una base de datos de usuarios
    private static final List<Usuario> usuarios = Arrays.asList(
            new Usuario(1, "Ana",    "ana@email.com"),
            new Usuario(2, "Carlos", "carlos@email.com"),
            new Usuario(3, "María",  null) // Usuario sin email
    );

    private static final String LINEA = new String(new char[50]).replace('\0', '=');

    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE OPTIONAL EN JAVA ===\n");

        ejemploCreacionOptional();
        ejemploPractico();
        ejemploMetodosFuncionales();
    }

    // ---------- CREACIÓN DE OPTIONAL ----------
    private static void ejemploCreacionOptional() {
        System.out.println("1. CREANDO OPTIONAL:\n");

        Optional<String> nombreCompleto = Optional.of("Juan Pérez");
        System.out.println("Optional.of(): " + nombreCompleto);

        String emailPosiblementeNull = null;
        Optional<String> email = Optional.ofNullable(emailPosiblementeNull);
        System.out.println("Optional.ofNullable(): " + email);

        Optional<String> telefono = Optional.empty();
        System.out.println("Optional.empty(): " + telefono);

        System.out.println("\n" + LINEA + "\n");
    }

    // ---------- EJEMPLO PRÁCTICO ----------
    private static void ejemploPractico() {
        System.out.println("2. EJEMPLO PRÁCTICO - BUSCAR USUARIO:\n");

        System.out.println("Buscando usuario con ID 1:");
        manejarUsuario(buscarUsuario(1));

        System.out.println("\nBuscando usuario con ID 999 (no existe):");
        manejarUsuario(buscarUsuario(999));

        System.out.println("\n" + LINEA + "\n");
    }

    // ---------- MÉTODOS FUNCIONALES ----------
    private static void ejemploMetodosFuncionales() {
        System.out.println("3. MÉTODOS FUNCIONALES DE OPTIONAL:\n");

        Optional<Usuario> usuario = buscarUsuario(1);

        Optional<String> nombreEnMayusculas =
                usuario.map(u -> u.nombre.toUpperCase());
        System.out.println("Nombre en mayúsculas: " +
                nombreEnMayusculas.orElse("Sin nombre"));

        Optional<Usuario> usuarioConEmailValido =
                usuario.filter(u -> u.email != null && u.email.contains("@"));
        System.out.println("Usuario con email válido: " +
                usuarioConEmailValido.isPresent());

        Optional<String> dominioEmail =
                usuario.flatMap(DemoOptional::extraerDominio);
        System.out.println("Dominio del email: " +
                dominioEmail.orElse("Sin dominio"));

        // Usuario sin email
        System.out.println("\nProbando con usuario sin email:");
        Optional<Usuario> usuarioSinEmail = buscarUsuario(3);
        Optional<String> dominioSinEmail =
                usuarioSinEmail.flatMap(DemoOptional::extraerDominio);
        System.out.println("Dominio del email: " +
                dominioSinEmail.orElse("Sin dominio"));
    }

    // ---------- AUXILIARES ----------
    private static Optional<Usuario> buscarUsuario(int id) {
        return usuarios.stream()
                       .filter(u -> u.id == id)
                       .findFirst();
    }

    private static void manejarUsuario(Optional<Usuario> usuarioOpt) {
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            System.out.println("Usuario encontrado: " + usuario.nombre);
        } else {
            System.out.println("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.orElse(
                new Usuario(0, "Desconocido", "sin-email"));
        System.out.println("Usuario (con valor por defecto): " + usuario.nombre);

        usuarioOpt.ifPresent(u ->
                System.out.println("Email del usuario: " +
                        (u.email != null ? u.email : "Sin email")));

        try {
            Usuario usuarioSeguro = usuarioOpt.orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado"));
            System.out.println("Usuario obtenido de forma segura: " +
                    usuarioSeguro.nombre);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Extrae el dominio de un email, devolviendo Optional */
    private static Optional<String> extraerDominio(Usuario usuario) {
        if (usuario.email != null && usuario.email.contains("@")) {
            String dominio = usuario.email.split("@")[1];
            return Optional.of(dominio);
        }
        return Optional.empty();
    }

    // ---------- CLASE USUARIO ----------
    static class Usuario {
        int id;
        String nombre;
        String email;

        Usuario(int id, String nombre, String email) {
            this.id    = id;
            this.nombre = nombre;
            this.email  = email;
        }
    }
}
