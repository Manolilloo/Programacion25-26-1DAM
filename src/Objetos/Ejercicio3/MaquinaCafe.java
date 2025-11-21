package Objetos.Ejercicio3;

import Objetos.Ejercicio3.Exceptions.CafeEX;

import java.time.MonthDay;
import java.util.Scanner;

public class MaquinaCafe {
    private int depCafe;
    private int depLeche;
    private int depVasos;
    private double monedero;

    Scanner sc = new Scanner(System.in);

    public MaquinaCafe() throws CafeEX {
        this.depCafe = 50;
        this.depLeche = 50;
        this.depVasos = 80;
        this.monedero = 10;

    }


    public void servirCafe() throws CafeEX {
        int precioCafe = 1;
        if (monedero >= precioCafe) {
            depCafe--;
            depVasos--;
            monedero -= precioCafe;
            monedero = (double) Math.round(monedero * 10) / 10;
            throw new CafeEX("Gracias por la compra.");
        } else if (monedero < precioCafe) {
            throw new CafeEX("⛔El dinero que has introducido no llega al precio indicado.⛔");
        } else if (depCafe < 0 || depVasos < 0) {
            throw new CafeEX("Faltan depósitos...");
        }
    }

    public void servirLeche() throws CafeEX {
        double precioLeche = 0.8;
        if (monedero >= precioLeche) {
            depCafe--;
            depVasos--;
            monedero -= precioLeche;
            monedero = (double) Math.round(monedero * 10) / 10;
            throw new CafeEX("Gracias por tu compra!");
        } else if (monedero < precioLeche) {
            throw new CafeEX("⛔El dinero que has introducido no llega al precio indicado.⛔");
        } else if (depLeche < 0 || depVasos < 0) {
            throw new CafeEX("Faltan depósitos...");
        }
    }

    public void servirCafeConLeche() throws CafeEX {
        double precioCafeConLeche = 1.5;
        if (monedero >= precioCafeConLeche) {
            depCafe--;
            depLeche--;
            depVasos--;
            monedero -= precioCafeConLeche;
            monedero = (double) Math.round(monedero * 10) / 10;
            throw new CafeEX("Gracias por tu compra!");
        } else if (monedero < precioCafeConLeche) {
            throw new CafeEX("⛔El dinero que has introducido no llega al precio indicado.⛔");
        } else if (depCafe < 0 || depLeche < 0 || depVasos < 0) {
            throw new CafeEX("Faltan depósitos...");
        }


    }

    public String consultarEstado() {
        return toString();
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

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    @Override
    public String toString() {
        return "========================================" +
                "\nMaquinaCafe:" +
                "\n☕Depositos de cafe = " + depCafe +
                "\n🥛Depositos de leche = " + depLeche +
                "\n🫗Depositos de vasos = " + depVasos +
                "\n👛Monedero actual = " + monedero +
                "\n========================================";
    }
}