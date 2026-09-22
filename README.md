# Sistema de Gestión de Biblioteca

Proyecto desarrollado en Java utilizando Swing para crear una interfaz gráfica que permita gestionar los libros de una biblioteca.

## Descripción

El sistema permite registrar, visualizar, buscar y eliminar libros.

Cada libro contiene la siguiente información:

- Título
- Autor
- ISBN
- Categoría o género
- Año de publicación
- Copias disponibles

El programa utiliza Programación Orientada a Objetos y estructuras de datos como `ArrayList` y `HashMap`.

## Funcionalidades

El sistema permite:

- Agregar nuevos libros.
- Evitar registros con ISBN repetidos.
- Mostrar todos los libros registrados.
- Buscar libros por autor.
- Eliminar libros seleccionados.
- Validar que todos los campos estén completos.
- Validar el año de publicación.
- Validar la cantidad de copias disponibles.
- Mostrar los libros registrados en una tabla.

## Tecnologías utilizadas

- Java
- Java Swing
- ArrayList
- HashMap
- Programación Orientada a Objetos

## Estructura del proyecto

El proyecto está compuesto por cuatro clases principales:

### Libro.java

Representa un libro dentro del sistema.

Contiene los siguientes atributos:

- `titulo`
- `autor`
- `ISBN`
- `categoria`
- `añoPublicacion`
- `copiasDisponibles`

También contiene sus respectivos métodos `get` y `set` para consultar y modificar los datos de cada libro.

### Biblioteca.java

Se encarga de administrar los libros registrados en el sistema.

Contiene métodos para:

- Agregar libros.
- Verificar si un ISBN ya existe.
- Mostrar todos los libros.
- Filtrar libros por autor.
- Eliminar libros.

Para almacenar la información se utilizan las siguientes estructuras:

```java
ArrayList<Libro>
```

y:

```java
HashMap<String, ArrayList<Libro>>
```

El `ArrayList` permite almacenar todos los libros registrados.

El `HashMap` permite organizar los libros según su autor.

### VentanaPrincipal.java

Contiene la interfaz gráfica del programa.

Utiliza componentes de Java Swing como:

```java
JFrame
JPanel
JButton
JTextField
JTable
JLabel
JOptionPane
```

Desde esta ventana el usuario puede:

- Ingresar los datos de un libro.
- Agregar libros al sistema.
- Visualizar los libros registrados.
- Buscar libros por autor.
- Seleccionar y eliminar libros.
- Ver mensajes de validación.

### Main.java

Es la clase principal del programa.

Se encarga de iniciar la aplicación y mostrar la ventana principal.

El funcionamiento general del sistema es:

```text
Main
  ↓
VentanaPrincipal
  ↓
Biblioteca
  ↓
Libro
```

`Main` inicia el programa.

`VentanaPrincipal` permite la interacción con el usuario.

`Biblioteca` administra la información de los libros.

`Libro` representa los datos de cada libro.

## Validaciones

El sistema cuenta con diferentes validaciones para evitar errores durante el registro de libros.

Entre ellas se encuentran:

- Todos los campos son obligatorios.
- No se permiten libros con el mismo ISBN.
- El año de publicación debe ser un número entero.
- El año de publicación debe ser mayor que cero.
- El año de publicación no puede ser mayor al año actual.
- La cantidad de copias debe ser un número entero.
- La cantidad de copias no puede ser negativa.
- Para eliminar un libro se debe seleccionar primero una fila de la tabla.

## Ejemplo de registro

Un ejemplo de un libro registrado en el sistema sería:

```text
Título: El Principito
Autor: Antoine de Saint-Exupéry
ISBN: 9780156012195
Categoría: Novela
Año de publicación: 1943
Copias disponibles: 5
```

## Requisitos

Para ejecutar el proyecto se necesita:

- Java JDK 17 o superior.
- IntelliJ IDEA, NetBeans, Eclipse u otro entorno de desarrollo compatible con Java.

## Ejecución

Para ejecutar el programa:

1. Abrir el proyecto en el entorno de desarrollo.
2. Configurar correctamente el JDK.
3. Ejecutar la clase `Main.java`.
4. Se abrirá la ventana principal del sistema.

## Conceptos aplicados

Durante el desarrollo del proyecto se aplicaron conceptos como:

- Clases.
- Objetos.
- Encapsulamiento.
- Constructores.
- Getters.
- Setters.
- Métodos.
- Herencia.
- Manejo de excepciones.
- ArrayList.
- HashMap.
- Eventos.
- Interfaces gráficas con Swing.
- Validación de datos.

## Organización de archivos

```text
SistemaBiblioteca/
│
bibliotecaSistema/
│
src/
│
├── Main.java
├── VentanaPrincipal.java
├── Biblioteca.java
├── Libro.java
└── README.md
```

