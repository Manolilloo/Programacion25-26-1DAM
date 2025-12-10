/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.ExamenesdeOtrosAños.Examen2;

import java.time.LocalDate;
import java.time.Period;

public class RegistroRevisiones {
    private DepositoComb depositoComb;
    private LocalDate fecha;
    private boolean estado; //correcto o incorrecto
    private Period periodoValidez;

    public RegistroRevisiones(LocalDate fecha, boolean estado) {
        this.fecha = fecha;
        periodoValidez = Period.between(fecha, LocalDate.now());
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean listoParaViajar() {
        if (this.estado == true) {
            return true;
        } else if (depositoComb.getCantidadActual() > 0) {
            return true;
        } else if (getEstado() == true) {
            return true;
        } else { return false; }
    }
}
