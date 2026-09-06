public class libro {
    private String titulo;
    private String autor;
    private int ISBN;
    private String categoria;
    private int añoPublicacion;
    private int copiasDisponibles;

    public libro(String titulo, String autor, int ISBN, String categoria, int añoPublicacion , int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.categoria = categoria;
        this.añoPublicacion = añoPublicacion;
        this.copiasDisponibles = copiasDisponibles;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }
    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public String toString() {
        return titulo + "-" + autor + "-" + ISBN;
    }
}
