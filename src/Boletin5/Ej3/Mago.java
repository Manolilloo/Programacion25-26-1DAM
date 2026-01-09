/**
 * @author ManuelPerez
 * @version 1.0
 */

package Boletin5.Ej3;

import java.util.Arrays;

public class Mago extends Personaje {

    private static final int CANTIDAD_HECHIZOS = 4;
    private final String[] hechizos;

    public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int ptosVidaMax, int ptosVidaAct) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, ptosVidaMax, ptosVidaAct);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        this.hechizos = new String[CANTIDAD_HECHIZOS];
    }


    public void aprenderHechizo(String hechizo) throws PersonajeException {
        boolean iguales = false;
        int espacio = -1;

        for (int i = 0; i < hechizos.length && !iguales; i++) {
            if (hechizo.equals(hechizos[i])) {
                iguales = true;
            }
            if (hechizos[i] == null && espacio == -1) {
                espacio = i;
            }
        }
        if (!iguales && espacio != -1) {
            hechizos[espacio] = hechizo;
        } else {
            throw new PersonajeException("El mago no puede aprender este hechizo.");
        }
    }

    public void lanzaHechizo(Personaje personaje, String hechizo) throws PersonajeException {

        boolean hechizoEncontrado = false;

        if (personaje.getNombre().equals(this.getNombre())) {
            throw new PersonajeException("No te puedes tirar un hechizo a ti mismo.");
        }

        for (int i = 0; i < hechizos.length; i++) {
            if (hechizo.equals(hechizos[i])) {
                hechizoEncontrado = true;
                hechizos[i] = null;

                if (personaje.getPtosVidaAct() > 10){
                    personaje.setPtosVidaAct(personaje.getPtosVidaAct() - getFuerza());
                } else {
                    personaje.setPtosVidaAct(0);
                    System.out.println("El enemigo murió.");
                }
            }

        }

        if (!hechizoEncontrado){
            throw new PersonajeException("Todavia no has aprendido este hechizo");
        }
    }

    @Override
    public String toString() {
        return "Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}' + super.toString();
    }
}
