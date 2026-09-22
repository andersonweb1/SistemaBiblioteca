import java.util.ArrayList;
import java.util.HashMap;

public class biblioteca {

    private ArrayList<Libro> libros;
    private HashMap<String, ArrayList<Libro>> librosPorAutor;

    public biblioteca() {

        libros = new ArrayList<>();
        librosPorAutor = new HashMap<>();
    }

    // Agregar Libro
    public void agregarLibro(Libro libro) {

        if (existeIsbn(libro.getISBN())) {

            throw new IllegalArgumentException(
                    "Ya existe un Libro con ese ISBN."
            );
        }

        libros.add(libro);

        String autor = libro.getAutor();

        if (!librosPorAutor.containsKey(autor)) {

            librosPorAutor.put(
                    autor,
                    new ArrayList<>()
            );
        }

        librosPorAutor.get(autor).add(libro);
    }

    // Verificar si existe un ISBN
    public boolean existeIsbn(String isbn) {

        for (Libro libro : libros) {

            if (libro.getISBN().equalsIgnoreCase(isbn)) {
                return true;
            }
        }

        return false;
    }

    // Mostrar todos los libros
    public ArrayList<Libro> mostrarTodos() {

        return new ArrayList<>(libros);
    }

    // Filtrar libros por autor
    public ArrayList<Libro> filtrarPorAutor(String autor) {

        if (autor == null || autor.trim().isEmpty()) {
            return mostrarTodos();
        }

        ArrayList<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {

            if (libro.getAutor().equalsIgnoreCase(autor.trim())) {
                resultado.add(libro);
            }
        }

        return resultado;
    }

    // Eliminar Libro
    public void eliminarLibro(String isbn) {

        Libro libroEliminar = null;

        for (Libro libro : libros) {

            if (libro.getISBN().equalsIgnoreCase(isbn)) {

                libroEliminar = libro;
                break;
            }
        }

        if (libroEliminar != null) {

            libros.remove(libroEliminar);

            String autor = libroEliminar.getAutor();

            if (librosPorAutor.containsKey(autor)) {

                librosPorAutor
                        .get(autor)
                        .remove(libroEliminar);

                if (librosPorAutor.get(autor).isEmpty()) {

                    librosPorAutor.remove(autor);
                }
            }
        }
    }
}