package edu.ucaldas.model;

public class Producto {

    private String nombre;
    private int edad;
    private double precioBase;
    private double precioEnvio;
    private String proveedor;

    public Producto(String nombre, int edad, double precioBase, String proveedor, double precioEnvio) {
        this.nombre = nombre;
        this.edad = edad;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
        this.precioEnvio = precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public String getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return nombre + " - precio base: $" + precioBase + "- precio envío: $" + precioEnvio + " - precio total: $"
                + (precioEnvio + precioBase);
    }
}