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

}