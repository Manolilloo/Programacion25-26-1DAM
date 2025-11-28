/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioLiga;

public class Partido {

    private int jornada;
    private String equipoLocal;
    private String getEquipoVisitante;
    private String quiniela;

    public Partido(int jornada, String equipoLocal, String getEquipoVisitante, String quiniela) {
        this.jornada = jornada;
        this.equipoLocal = equipoLocal;
        this.getEquipoVisitante = getEquipoVisitante;
        this.quiniela = quiniela;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getGetEquipoVisitante() {
        return getEquipoVisitante;
    }

    public void setGetEquipoVisitante(String getEquipoVisitante) {
        this.getEquipoVisitante = getEquipoVisitante;
    }

    public String getQuiniela() {
        return quiniela;
    }

    public void setQuiniela(String quiniela) {
        this.quiniela = quiniela;
    }

    public String ponerResultado(String resultado){
        return "";
    }

    @Override
    public String toString() {
        return "Partido{" +
                "jornada=" + jornada +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", getEquipoVisitante='" + getEquipoVisitante + '\'' +
                ", quiniela='" + quiniela + '\'' +
                '}';
    }
}
