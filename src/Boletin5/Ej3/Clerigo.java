/**
 * @author ManuelPerez
 * @version 1.0
 */

package Boletin5.Ej3;

public class Clerigo extends Personaje {

    private String nombreDios;

    public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int ptosVidaMax, int ptosVidaAct, String nombreDios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, ptosVidaMax, ptosVidaAct);

        setFuerza(fuerza);
        setInteligencia(inteligencia);
        this.nombreDios = nombreDios;
    }


    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza >= 18) {
            super.setFuerza(fuerza);
        } else throw new PersonajeException("No puedes tener esa cantidad de fuerza.");
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia <= 12 || inteligencia >= 16) {
            throw new PersonajeException("No puedes tener esa cantidad de inteligencia.");
        }
        super.setInteligencia(inteligencia);
    }

    public void curar(Personaje tioAlQueCuras) throws PersonajeException {
        if (tioAlQueCuras.getNombre().equals(this.getNombre())) {
            throw new PersonajeException("No te puedes curar a ti mismo.");
        }

        if (tioAlQueCuras.getPtosVidaAct() < tioAlQueCuras.getPtosVidaMax()){
            tioAlQueCuras.setPtosVidaAct(tioAlQueCuras.getPtosVidaAct() + 10);
        } else {
            tioAlQueCuras.setPtosVidaAct(tioAlQueCuras.getPtosVidaMax());
            throw new PersonajeException("No puedes curar a alguien que esta al tope de vida.");
        }
    }

    @Override
    public String toString() {
        return "Clerigo{" +
                "nombreDios='" + nombreDios + '\'' +
                '}' + super.toString();
    }
}
