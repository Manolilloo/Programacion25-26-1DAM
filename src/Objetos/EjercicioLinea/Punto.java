/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioLinea;

public class Punto {

    private double coordenadaY;
    private double coordenadaX;


    public Punto(double coordenadaX, double coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Punto punto = (Punto) o;
        return Double.compare(coordenadaY, punto.coordenadaY) == 0 && Double.compare(coordenadaX, punto.coordenadaX) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(coordenadaY);
        result = 31 * result + Double.hashCode(coordenadaX);
        return result;
    }
}
