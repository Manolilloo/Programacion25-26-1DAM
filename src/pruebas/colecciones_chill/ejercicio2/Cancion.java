/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.colecciones_chill.ejercicio2;

public class Cancion implements Comparable<Cancion>{

    private String titulo;
    private int duracion;

    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + " - " + duracion;
    }

    @Override
    public int compareTo(Cancion otra) {
        return Integer.compare(this.duracion, otra.duracion);
    }
}
