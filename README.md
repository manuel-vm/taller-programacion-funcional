# Taller de Programación Funcional en Java

Este proyecto es un taller práctico que explora los conceptos fundamentales de la programación funcional utilizando Java. A través de ejemplos claros y concisos, se abordan los principios y técnicas esenciales de este paradigma de programación.

## 📚 Conceptos Clave

### 1. Estilo Declarativo vs Imperativo
- **Estilo Imperativo**: Describe el "cómo" se realizan las operaciones (paso a paso).
- **Estilo Declarativo**: Enfocado en el "qué" se quiere lograr, dejando los detalles de implementación al lenguaje.

### 2. Funciones de Primera Clase
- Las funciones pueden ser tratadas como cualquier otro valor.
- Pueden ser pasadas como argumentos, retornadas como resultados y asignadas a variables.

### 3. Transparencia Referencial
- Las funciones puras siempre devuelven el mismo resultado para los mismos argumentos.
- No producen efectos secundarios observables.

### 4. Inmutabilidad
- Los objetos no se modifican después de su creación.
- Las operaciones devuelven nuevos objetos en lugar de modificar los existentes.

### 5. Composición de Funciones
- Creación de funciones complejas combinando funciones más simples.
- Permite un código más modular y reutilizable.

### 6. Recursión
- Alternativa a los bucles tradicionales.
- Las funciones se llaman a sí mismas para resolver problemas más pequeños.

## 🛠️ Operaciones con Streams

### 1. Filter
- Filtra elementos de una colección según un predicado.
- Ejemplo: Filtrar correos no leídos de una bandeja de entrada.

### 2. Map
- Transforma cada elemento de una colección aplicando una función.
- Ejemplo: Convertir una lista de nombres a sus longitudes.

### 3. Reduce
- Combina todos los elementos de una colección en un solo resultado.
- Ejemplo: Calcular el total de una lista de precios.

### 4. Otras Operaciones
- **sorted()**: Ordena elementos.
- **forEach()**: Ejecuta una acción para cada elemento.
- **anyMatch()/allMatch()/noneMatch()**: Verifican condiciones sobre los elementos.

## 🏗️ Estructura del Proyecto

```
src/main/java/org/taller/
├── introduccion/      # Conceptos básicos
│   ├── EstiloDeclarativo.java
│   ├── EstiloImperativo.java
│   ├── FuncionesDePrimeraClase.java
│   └── ...
├── streams/           # Operaciones con Streams
│   ├── DemoFilter.java
│   ├── DemoMap.java
│   ├── DemoReduce.java
│   └── DemoStreams.java
└── Main.java          # Punto de entrada
```

## 🚀 Cómo Usar

1. Clona el repositorio.
2. Abre el proyecto en tu IDE favorito con soporte para Java.
3. Explora los ejemplos en los paquetes `introduccion` y `streams`.
4. Ejecuta las clases individuales para ver los resultados.

## 📝 Requisitos

- Java 8 o superior
- Maven (opcional, para gestión de dependencias)

## 📚 Recursos Adicionales

- [Documentación oficial de Java Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Java 8 Functional Programming](https://www.oracle.com/technical-resources/articles/java/architect-lambdas-part1.html)
