package Objetos.Objetos1.Ejercicio3;

import Objetos.Objetos1.Ejercicio3.Exceptions.CafeEX;

import java.util.Scanner;

public class Main {
    static void main(String[] args) throws CafeEX {
        Scanner sc = new Scanner(System.in);
        MaquinaCafe m = new MaquinaCafe();

        System.out.println("Bienvenido a la maquina de cafe!");

        boolean funcionando = true;

        while (funcionando){

            System.out.println("Ahora mismo tienes: "+m.getMonedero()+ "€");
            System.out.println("==========================================");
            System.out.println("Selecciona una opcion:\n1. Servir café solo (1 euro)\n2. Servir leche (0.8 euros)\n3. Servir café con leche (1.5 euros)\n4. Consultar estado maquina.\n5. Apagar maquina y salir.");
            System.out.println("==========================================");
            int opcion = sc.nextInt();


            try {
                switch (opcion){
                    case 1:
                        m.servirCafe();
                        break;
                    case 2:
                        m.servirLeche();
                        break;
                    case 3:
                        m.servirCafeConLeche();
                        break;
                    case 4:
                        System.out.println(m.consultarEstado());
                        break;
                    case 5:
                        System.out.println("Gracias por usar la maquina...");
                        funcionando = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (CafeEX e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
