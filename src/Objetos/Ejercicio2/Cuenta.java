package Objetos.Ejercicio2;

public class Cuenta {

    private int ingresosTotales;
    private int reintegrosTotales;
    private double saldoInicial;


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

    public double getSaldoInicial(double dinero) {
        return saldoInicial + dinero;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Cuenta(){
        ingresosTotales = 0;
        reintegrosTotales = 0;
        saldoInicial = 30000;
    }

}
