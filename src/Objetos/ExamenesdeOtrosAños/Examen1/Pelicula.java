/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen1;

import java.util.Collection;

public class Pelicula {

    private String titulo;
    private int anioEstreno;
    private String director;
    private double presupuesto;
    private double recaudacion;
    private String sinopsis;
    private String etiquetas;   // una sola cadena
    private double valoracion;  // de 0 a 10

    public Pelicula(String titulo, int anioEstreno, String director,
                    double presupuesto, double recaudacion,
                    String sinopsis, String etiquetas, double valoracion) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.director = director;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.sinopsis = sinopsis;
        this.etiquetas = etiquetas;
        this.valoracion = valoracion;
    }

    // Método estático para calcular la valoración
    public static double calcularValoracion(double presupuesto, double recaudacion) {
        if (recaudacion <= 0) {
            return 0.0;
        } else if (recaudacion == presupuesto) {
            return 5.0;
        } else if (recaudacion >= 2 * presupuesto) {
            return 10.0;
        } else {
            // regla de 3 entre 0–5–10 según recaudación/presupuesto
            double ratio = recaudacion / presupuesto; // 0 -> 2
            return ratio * 5.0;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public String getDirector() {
        return director;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nAño: " + anioEstreno +
                "\nDirector: " + director +
                "\nPresupuesto: " + presupuesto +
                "\nRecaudación: " + recaudacion +
                "\nValoración: " + valoracion +
                "\nEtiquetas: " + etiquetas +
                "\nSinopsis: " + sinopsis;
    }
}


