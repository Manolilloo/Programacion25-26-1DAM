package Objetos.Ejercicio3;

import java.util.Scanner;

public class MaquinaCafe {
    private int depCafe;
    private int depLeche;
    private int depVasos;
    private double monedero;

    Scanner sc = new Scanner(System.in);

    public MaquinaCafe() {
        this.depCafe = 50;
        this.depLeche = 50;
        this.depVasos = 80;
        this.monedero = 10;

    }


    public void servirCafe(double dinero) {
        int precioCafe = 1;
        if (dinero == precioCafe) {
            depCafe--;
            depVasos--;
            System.out.println("Gracias por tu compra!");
            System.out.println("Quedan " + depCafe + " depósitos de café\ny " + depVasos + " vasos.");
        } else if (dinero > precioCafe) {
            depCafe--;
            depVasos--;
            dinero -= precioCafe;
            System.out.println("Gracias por tu compra!");
            System.out.println("Quedan " + depCafe + " depósitos de café.");
        }
        while (dinero < precioCafe) {
            System.out.println("El dinero que has introducido no llega al precio\nindicado. Vuelve a intentarlo: ");
            dinero = sc.nextDouble();
        }
    }

    public void servirLeche(double dinero) {
        double precioLeche = 0.8;
        if (dinero == precioLeche) {
            depCafe--;
            depVasos--;
            System.out.println("Gracias por tu compra!");
        } else if (dinero > precioLeche) {
            depCafe--;
            depVasos--;
            dinero -= precioLeche;
            System.out.println("Gracias por tu compra!");
        }
        while (dinero < precioLeche) {
            System.out.println("El dinero que has introducido no llega al precio\nindicado. Vuelve a intentarlo: ");
            dinero = sc.nextDouble();
        }
    }

    public void servirCafeConLeche(double dinero) {
        double precioCafeConLeche = 1.5;
        if (dinero == precioCafeConLeche) {
            depCafe--;
            depLeche--;
            depVasos--;
            System.out.println("Gracias por la compra!");
        } else if (dinero > precioCafeConLeche) {
            dinero -= precioCafeConLeche;
            depCafe--;
            depLeche--;
            depVasos--;
            System.out.println("Gracias por la compra!");
        }
        while (dinero < precioCafeConLeche) {
            System.out.println("El dinero que has introducido no llega al precio\nindicado. Vuelve a intentarlo: ");
            dinero = sc.nextDouble();
        }
    }

    public void consultarEstado(){
        toString();
    }

    public int getDepCafe() {
        return depCafe;
    }

    public int getDepLeche() {
        return depLeche;
    }

    public int getDepVasos() {
        return depVasos;
    }

    public double getMonedero(int dinero) {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    @Override
    public String toString() {
        return "MaquinaCafe{" +
                "Depositos de cafe = " + depCafe +
                ", Depositos de leche = " + depLeche +
                ", Depositos de vasos = " + depVasos +
                ", Monedero actual = " + monedero +
                '}';
    }
}