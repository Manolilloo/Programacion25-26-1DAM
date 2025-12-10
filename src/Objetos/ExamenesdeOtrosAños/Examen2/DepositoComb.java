/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen2;

public class DepositoComb {

    private static final int CAPACIDAD_MAXIMA = 310000;
    private double cantidadActual;

    public DepositoComb(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual() throws AvionException {
        this.cantidadActual = cantidadActual;
        if (cantidadActual > CAPACIDAD_MAXIMA) {
            throw new AvionException("No puede tener mas capacidad que la maxima");
        }
    }
}
