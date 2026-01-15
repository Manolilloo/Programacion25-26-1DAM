package pokemonExamen.interfaces;

import pokemonExamen.enums.WeatherCondition;
import pokemonExamen.exceptions.MuerteException;

public interface Atacador {
    public void atacar();

    void atacar(Atacable atacable, WeatherCondition weatherCondition) throws MuerteException;
}
