/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioLiga;

import java.lang.management.MemoryNotificationInfo;
import java.util.Set;

public class Equipo {
    private String nombre;
    private String ciudad;
    private String estadio;
    private int partidosGanados;

    public Equipo(String nombre, String ciudad, String estadio){
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int incrementarVictorias(){
        return 0;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estadio='" + estadio + '\'' +
                ", partidosGanados=" + partidosGanados +
                '}';
    }
}
