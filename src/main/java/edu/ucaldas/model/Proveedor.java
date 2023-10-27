package edu.ucaldas.model;

public class Proveedor {
    private String nombre;
    private double precioEnvio;

    public Proveedor(String nombre, double precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    @Override
    public String toString() {
        return nombre + " - precio de envío: $" + precioEnvio + ",0.";
    }
}