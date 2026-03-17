/**
 * @author ManuelPerez
 * @version 1.0
 */

package pruebas.lambdas.d;

import java.util.Objects;

public class Medico {
    private String numcolegiado;
    private String nombre;
    private int anosExperiencia;

    public String getNumcolegiado() {
        return numcolegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public Medico(String numcolegiado, String nombre, int anosExperiencia) {
        this.numcolegiado = numcolegiado;
        this.nombre = nombre;
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Medico medico)) return false;

        return Objects.equals(numcolegiado, medico.numcolegiado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numcolegiado);
    }

    @Override
    public String toString() {
        return "\nMedico " + this.nombre + " - Años de experiencia: " + this.anosExperiencia;
    }
}
