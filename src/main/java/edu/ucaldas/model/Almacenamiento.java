package edu.ucaldas.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ucaldas.repository.IleerJSON;
import edu.ucaldas.repository.ProductoJSON;
import edu.ucaldas.repository.ProveedorJSON;

public class Almacenamiento {
    private IleerJSON<Proveedor> proveedoresJson = new ProveedorJSON();
    private IleerJSON<Producto> productosJson = new ProductoJSON();
    private List<Producto> regalos = new ArrayList<Producto>();

    public boolean crearRegalos() {

        try {
            for (Producto producto : productosJson.cargarDatos()) {
                for (Proveedor proveedor : proveedoresJson.cargarDatos()) {
                    if (producto.getProveedor().equals(proveedor.getNombre())) {
                        Producto nuevoRegalo = new Producto(
                                producto.getNombre(), producto.getEdad(), producto.getPrecioBase(),
                                proveedor.getNombre(), proveedor.getPrecioEnvio());
                        regalos.add(nuevoRegalo);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }

    public List<Producto> getRegalos() {
        return regalos;
    }
}