/**
 * @author ManuelPerez
 * @version 1.0
 */

package Boletin5.Ej3;

import java.util.Objects;

public class Personaje {

    private String nombre;
    private Raza raza;
    private int fuerza;
    private int inteligencia;
    private int ptosVidaMax;
    private int ptosVidaAct;

    public Personaje(String nombre, Raza raza, int fuerza, int inteligencia, int ptosVidaMax, int ptosVidaAct) throws PersonajeException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setPtosVidaMax(ptosVidaMax);
        setPtosVidaAct(ptosVidaAct);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza > 0 && fuerza <= 20) {
            this.fuerza = fuerza;
        } else {
            throw new PersonajeException("No puedes tener esa cantidad de fuerza.");
        }
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia > 0 && inteligencia <= 20) {
            this.inteligencia = inteligencia;
        } else {
            throw new PersonajeException("No puedes tener esa cantidad de inteligencia.");
        }
    }

    public int getPtosVidaMax() {
        return ptosVidaMax;
    }

    public void setPtosVidaMax(int ptosVidaMax) throws PersonajeException {
        if (ptosVidaMax <= 0 || ptosVidaMax > 100){
            throw new PersonajeException("No puedes tener esa cantidad de vida max.");
        }
        this.ptosVidaMax = ptosVidaMax;
    }

    public int getPtosVidaAct() {
        return ptosVidaAct;
    }

    public void setPtosVidaAct(int ptosVidaAct) throws PersonajeException {
        if (ptosVidaAct < 0 || ptosVidaAct > getPtosVidaMax()){
            throw new PersonajeException("No puedes tener esa cantidad de vida.");
        }
        this.ptosVidaAct = ptosVidaAct;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", ptosVidaMax=" + ptosVidaMax +
                ", ptosVidaAct=" + ptosVidaAct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Personaje)) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public int compareTo(Personaje o){
        return Integer.compare(this.ptosVidaAct, o.ptosVidaAct);
    }
}
