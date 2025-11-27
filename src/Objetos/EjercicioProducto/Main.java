/**
 * @author ManuelPerez
 * @version 1.0
 */

package Objetos.EjercicioProducto;


import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Producto p = new Producto(999.999, 9834934, "Jamón de bellota de Suecia de 1998 con aceites\n de la República de Italia", 0.2);
        Scanner sc = new Scanner(System.in);

        System.out.println("Estas en el Mercadona y vienes a comprar...");
        System.out.println();
        System.out.println("Que es lo que quieres hacer? ");
        int opcion = sc.nextInt();
        boolean activoPapi = true;

        while (activoPapi){
                 switch (opcion){
                     case 1:
                         p.consulta();
                         break;

                     case 2:
                         p.modificarAtributos();
                 }
         }

    }
}
