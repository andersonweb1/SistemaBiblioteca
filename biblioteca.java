import java.util.ArrayList;
import java.util.HashMap;

public class biblioteca {

    private ArrayList<Libro>libros;

    private HashMap<String, ArrayList<Libro>> librosPorAutor;

    public Biblioteca() {
        libros = new ArrayList<>();
        librosPorAutor = new HashMap<>();
    }

    // Agregar libro
    public void agregarLibro(Libro libro) {

        if (existeIsbn(libro.getIsbn())) {
            throw new IllegalArgumentException(
                    "Ya existe un libro con ese ISBN."
            );
        }

        libro.add(libro);

        String autor = libro.getAutor();

        if (!librosPorAutor.containsKey(autor)) {
            librosPorAutor.put(autor, new ArrayList<>());
        }

        librosPorAutor.get(autor).add(libro);
    }


    // Verificar si existe un ISBN
    public boolean existeIsbn(String isbn) {

        for (Libro libro : libros) {

            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }

        return false;
    }

    // Filtrar libros por autor
    public ArrayList<Libro> filtrarPorAutor(String autor) {

        if (autor == null || autor.trim().isEmpty()) {
            return obtenerTodos();
        }

        ArrayList<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {

            if (libro.getAutor().equalsIgnoreCase(autor.trim())) {
                resultado.add(libro);
            }
        }

        return resultado;
    }


}