/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio1;

// Le ponemos la etiqueta Comparable para darle un orden por defecto
public class Videojuego implements Comparable<Videojuego> {

    private String titulo;
    private int puntuacion;

    public Videojuego(String titulo, int puntuacion) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
    }

    public String getTitulo() { return titulo; }

    // --- EL ORDEN NATURAL ---
    // Este método es obligatorio al usar Comparable.
    // Compara "este" juego (this) con el "otro" juego.
    @Override
    public int compareTo(Videojuego otro) {
        // Le pedimos a Java que compare las dos puntuaciones directamente [cite: 261]
        return Integer.compare(this.puntuacion, otro.puntuacion);
    }

    // Un toString para que al imprimir no salgan símbolos raros
    @Override
    public String toString() {
        return titulo + " (" + puntuacion + ")";
    }
}
