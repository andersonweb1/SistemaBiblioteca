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

}
