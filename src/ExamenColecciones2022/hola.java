/**
 * @author ManuelPerez
 * @version 1.0
 */

package ExamenColecciones2022;

import java.util.*;

public class hola {

    static void main(String[] args) {

        /*Collection<String> collection = new ArrayList<>();

        collection.add("Hola");
        collection.add("Mundo");


        Iterator<String> it = collection.iterator();
        while(it.hasNext()) {
            String elem = it.next();
            if(elem.equals("Mundo") ) {
                it.remove(); // elimina de la colección
            }
        }

        // Ejemplo para imprimir elementos limpios
        for (String s : collection) {
            System.out.print(s + " ");
        }*/


       /* Set<String> conjunto = new HashSet<>();

        conjunto.add("a");
        conjunto.add("Hola mundo");
        conjunto.add("ia");
        conjunto.add("ia");

        System.out.println(conjunto);
*/
/*

        HashSet<String> ciudades = new HashSet<>();

        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Madrid");

        System.out.println(ciudades.size());
        System.out.println(ciudades);
*/

        /*HashSet<String> correos = new HashSet<>();

        correos.add("pepe@gmail.com");
        correos.add("ana@gmail.com");
        correos.add("ana@gmail.com");
        correos.add("luis@gmail.com");

        System.out.println(correos);
        System.out.println(correos.size());
*/

        /*HashSet<String> amigos = new HashSet<>();

        amigos.add("Pablo");
        amigos.add("Juan");
        amigos.add("Cesar");
        amigos.add("Manuel");

        String miNombre = "Manuel";

        if (amigos.contains(miNombre)){
            System.out.println("Estoy en la lista!");
        } else System.out.println("No estoy en la lista ;(");
*/


        /*HashSet<String> invitados = new HashSet<>();

        System.out.println(invitados.isEmpty());

        invitados.add("Carlos");
        invitados.add("Lucia");

        System.out.println(invitados.isEmpty());
*/

        /*HashSet<String> frutas = new HashSet<>();

        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Platano");
        frutas.add("kiwi");

        Iterator<String> it = frutas.iterator();
        while (it.hasNext()) {

            String frutaActual = it.next();
            System.out.println(frutaActual);
        }*/

        /*TreeSet<String> nombres = new TreeSet<>();

        nombres.add("Zacarías");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Beatriz");
        nombres.add("Ana");

        System.out.println(nombres);*/

        /*TreeSet<Integer> numeros = new TreeSet<>();

        numeros.add(50);
        numeros.add(10);
        numeros.add(30);
        numeros.add(10);
        numeros.add(5);

        System.out.println(numeros);*/


       /* ArrayList<String> cine = new ArrayList<>();

        cine.add("Batman");
        cine.add("Spiderman");
        cine.add("Batman");
        cine.add("Superman");

        System.out.println(cine);
        System.out.println(cine.getFirst());*/

       /* LinkedList<String> conga = new LinkedList<>();

        conga.add("Juan");
        conga.add("Maria");
        conga.add(0, "Pedro");

        System.out.println(conga);*/



        /*ArrayList<String> palabras = new ArrayList<>();

        palabras.add("Hola");
        palabras.add("Mundo");
        palabras.add("Bomba");

        Iterator<String> it = palabras.iterator();
        while (it.hasNext()){
            String palabra = it.next();
            if (palabra.equals("Bomba")){
                it.remove();
            }
        }

        System.out.println(palabras);*/



        /*ArrayList<Integer> puntuaciones = new ArrayList<>();

        puntuaciones.add(85);
        puntuaciones.add(20);
        puntuaciones.add(100);
        puntuaciones.add(45);

        System.out.println(puntuaciones);

        Collections.sort(puntuaciones);

        System.out.println(puntuaciones);*/


        /*Stack<String> historial = new Stack<>();

        historial.push("Google");
        historial.push("Wikipedia");
        historial.push("YouTube");

        System.out.println(historial.peek());
        System.out.println();

        while (!historial.isEmpty()){
            System.out.println(historial.pop());
        }

        */


        /*ArrayList<Videojuego> videojuegos = new ArrayList<>();

        Videojuego v1 = new Videojuego("MGS Snake Eater", 89);
        Videojuego v2 = new Videojuego("Mario kart 5", 34);
        Videojuego v3 = new Videojuego("Bongo Cat", 78);
*/

    }
}
