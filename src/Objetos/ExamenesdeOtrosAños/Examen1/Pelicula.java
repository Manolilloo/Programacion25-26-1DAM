/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen1;

public class Pelicula {
    private String titulo;
    private int añoDeEstreno;
    private String director;
    private double presupuesto;
    private double recaudacion;
    private String sinopsis;
    private String etiqueta;
    private double valoracion;

    public Pelicula(String titulo, int añoDeEstreno, String director, double presupuesto, double recaudacion, String sinopsis, String etiqueta, double valoracion) {
        this.titulo = titulo;
        this.añoDeEstreno = añoDeEstreno;
        this.director = director;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.sinopsis = sinopsis;
        this.etiqueta = etiqueta;
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAñoDeEstreno() {
        return añoDeEstreno;
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

    public String getEtiqueta() {
        return etiqueta;
    }

    public double getValoracion() {
        return valoracion;
    }
}

