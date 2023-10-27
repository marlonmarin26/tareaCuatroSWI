package edu.ucaldas.services;

import java.util.ArrayList;
import java.util.List;

import edu.ucaldas.model.Producto;

public class FiltroRegalo {
    public FiltroRegalo() {
    }

    public List<Producto> filtrarPorEdad(List<Producto> regalos, int edad) {
        List<Producto> regalosFiltrados = new ArrayList<>();
        for (Producto product : regalos) {
            if (product.getEdad() == edad) {

                regalosFiltrados.add(product);
            }
        }
        return regalosFiltrados;

    }

    public List<Producto> filtrarPorCosto(List<Producto> regalos, double costo) {
        List<Producto> regalosFiltrados = new ArrayList<>();
        for (Producto producto : regalos) {
            if (producto.getPrecioBase() < costo) {
                regalosFiltrados.add(producto);
            }
        }
        return regalosFiltrados;

    }
}
