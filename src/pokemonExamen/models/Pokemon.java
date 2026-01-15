/**
 * @author ManuelPerez
 * @version 1.0
 */

package pokemonExamen.models;

import pokemonExamen.enums.WeatherCondition;
import pokemonExamen.exceptions.MuerteException;
import pokemonExamen.exceptions.RoundStartException;
import pokemonExamen.interfaces.Atacable;
import pokemonExamen.interfaces.Atacador;

public abstract class Pokemon implements Atacador {
    private String nombre;
    private int ptsSalud;
    private int lvlAttack;
    private int lvlDeffense;

    public Pokemon(String nombre, int ptsSalud, int lvlAttack, int lvlDeffense) {
        this.nombre = nombre;
        this.ptsSalud = ptsSalud;
        this.lvlAttack = lvlAttack;
        this.lvlDeffense = lvlDeffense;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPtsSalud() {
        return ptsSalud;
    }

    public void setPtsSalud(int ptsSalud) {
        this.ptsSalud = ptsSalud;
    }

    public int getLvlAttack() {
        return lvlAttack;
    }

    public void setLvlAttack(int lvlAttack) {
        this.lvlAttack = lvlAttack;
    }

    public int getLvlDeffense() {
        return lvlDeffense;
    }

    public void setLvlDeffense(int lvlDeffense) {
        this.lvlDeffense = lvlDeffense;
    }

    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
    }

    public boolean estaVivo() {
        return false;
    }

    @Override
    public void atacar(Atacable atacable, WeatherCondition weatherCondition) throws MuerteException {

    }
}