package Objetos.Objetos1.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo();
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la longitud: ");
        double longitud = sc.nextDouble();
        r.setLongitud(longitud);
        System.out.print("Introduce el ancho: ");
        double ancho = sc.nextDouble();
        r.setAncho(ancho);

        System.out.println("Longitud: " + r.getLongitud());
        System.out.println("Ancho: " + r.getAncho());
        System.out.println("Perimetro: " + r.calcularPerimetro());
        System.out.println("Area: " + r.calcularArea());
    }
}
