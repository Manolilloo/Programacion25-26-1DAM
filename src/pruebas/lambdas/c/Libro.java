/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.c;

public class Libro {

    private String isbn;
    private String titulo;
    private int paginas;

    public Libro(String isbn, String titulo, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "" +
                "\nNombre y paginas: " + this.titulo + " - " +  this.paginas;
    }
}
