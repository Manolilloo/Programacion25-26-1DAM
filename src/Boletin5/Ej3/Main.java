/**
 * @author ManuelPerez
 * @version 1.0
 */

package Boletin5.Ej3;

public class Main {

    static void main(String[] args) {
        try {
            Mago magoA = new Mago("Panchito", Raza.HUMANO, 17, 20, 80, 80);
            magoA.aprenderHechizo("Cabezazo Cipotil");
            magoA.aprenderHechizo("Vaina de fuego");

            Mago magoB = new Mago("Eustaquio", Raza.ORCO, 20, 17, 100, 100);
            magoB.aprenderHechizo("Habichuela");

            System.out.println(magoA);
            System.out.println(magoB);

            Clerigo clerigo = new Clerigo("Francis", Raza.ELFO, 19, 15, 90, 90, "EnriqueRamos");

            magoA.lanzaHechizo(magoB, "Cabezazo Cipotil");
            magoB.lanzaHechizo(magoA, "Habichuela");
            clerigo.curar(magoB);
            magoA.lanzaHechizo(magoB, "Vaina de fuego");

            System.out.println(magoA);
            System.out.println(magoB);
            System.out.println(clerigo);

        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

    }
}
