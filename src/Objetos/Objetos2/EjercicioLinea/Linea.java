/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.Objetos2.EjercicioLinea;

import java.util.Objects;

public class Linea {
    private Punto puntoA;
    private Punto puntoB;

    public Linea() {
        this.puntoA = new Punto(0.0, 0.0);
        this.puntoB = new Punto(0.0, 0.0);
    }

    public Linea(Punto punto1, Punto punto2) {
        this.puntoA = punto1;
        this.puntoB = punto2;
    }


    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    public void moverDerecha(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa.");
        }
        puntoA.setCoordenadaX((puntoA.getCoordenadaX() + distancia));
        puntoB.setCoordenadaX((puntoB.getCoordenadaX() + distancia));
    }
    public void moverIzquierda(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa.");
        }
        puntoA.setCoordenadaX((puntoA.getCoordenadaX() - distancia));
        puntoB.setCoordenadaX((puntoB.getCoordenadaX() - distancia));
    }

    public void moverArriba(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa.");
        }
        puntoA.setCoordenadaY((puntoA.getCoordenadaY() + distancia));
        puntoB.setCoordenadaY((puntoB.getCoordenadaY() + distancia));
    }

    public void moverAbajo(double distancia) throws LineaException {
        if (distancia < 0) {
            throw new LineaException("La distancia no puede ser negativa.");
        }
        puntoA.setCoordenadaY((puntoA.getCoordenadaY() - distancia));
        puntoB.setCoordenadaY((puntoB.getCoordenadaY() - distancia));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Linea linea = (Linea) o;
        return Objects.equals(puntoA, linea.puntoA) && Objects.equals(puntoB, linea.puntoB);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(puntoA);
        result = 31 * result + Objects.hashCode(puntoB);
        return result;
    }

    @Override
    public String toString() {
        return "Linea{" +
                "puntoA=" + puntoA +
                ", puntoB=" + puntoB +
                '}';
    }
}
