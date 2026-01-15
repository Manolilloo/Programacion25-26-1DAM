/**
 * @author ManuelPerez
 * @version 1.0
 */

package pokemonExamen.models;

import pokemonExamen.interfaces.Atacable;

public class PokemonTierra extends Pokemon implements Atacable {
    public PokemonTierra(String nombre, int ptsSalud, int lvlAttack, int lvlDeffense) {
        super(nombre, ptsSalud, lvlAttack, lvlDeffense);
    }

    @Override
    public void serAtacado() {

    }
}
