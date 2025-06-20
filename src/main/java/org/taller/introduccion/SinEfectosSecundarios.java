package org.taller.introduccion;
class Usuario {
    private final String nombre;

    public Usuario(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    // * Este método devuelve un NUEVO objeto en lugar de modificar el actual
    public Usuario conNombreActualizado(String nuevoNombre) {
        return new Usuario(nuevoNombre);
    }

    @Override
    public String toString() { return "Usuario{" + "nombre='" + nombre + "'}"; }
}

public class SinEfectosSecundarios {
    public static void main(String[] args) {
        Usuario usuarioOriginal = new Usuario("Ana");
        System.out.println("Usuario original: " + usuarioOriginal);

        // * La función no modifica el objeto original, crea uno nuevo
        Usuario usuarioActualizado = usuarioOriginal.conNombreActualizado("Beatriz");

        System.out.println("Usuario original después de la operación: " + usuarioOriginal);
        System.out.println("Nuevo usuario creado: " + usuarioActualizado);
    }
}