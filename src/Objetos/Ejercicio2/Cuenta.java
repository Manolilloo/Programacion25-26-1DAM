package Objetos.Ejercicio2;

public class Cuenta {

    private int ingresosTotales;
    private int reintegrosTotales;
    private double saldo;


    public int getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(int ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public int getReintegrosTotales() {
        return reintegrosTotales;
    }

    public void setReintegrosTotales(int reintegrosTotales) {
        this.reintegrosTotales = reintegrosTotales;
    }

    public double getSaldo(double dinero) {
        return saldo + dinero;
    }

    public double setSaldo(double saldo) {
        this.saldo = saldo;
        return saldo;
    }

    public Cuenta(){
        ingresosTotales = 0;
        reintegrosTotales = 0;
        saldo = 0;
    }
}
