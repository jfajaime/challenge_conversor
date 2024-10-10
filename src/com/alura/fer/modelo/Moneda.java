package com.alura.fer.modelo;

public class Moneda {
    private String monedaBase;
    private String monedaObjetivo;
    private double conversion;

    public Moneda(String monedaBase, String monedaObjetivo, double conversion) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.conversion = conversion;
    }

    public Moneda(MonedaOmdb monedaOmdb) {
        this.monedaBase = monedaOmdb.base_code();
        this.monedaObjetivo = monedaOmdb.target_code();
        this.conversion = Double.parseDouble(monedaOmdb.conversion_rate());
    }


    @Override
    public String toString() {
        return  "(monedaBase='" + monedaBase +
                ", monedaObjetivo='" + monedaObjetivo +
                ", conversion=" + conversion +")";
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(double conversion) {
        this.conversion = conversion;
    }
}
