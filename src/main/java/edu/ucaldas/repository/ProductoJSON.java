package edu.ucaldas.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.ucaldas.model.Producto;

public class ProductoJSON implements IleerJSON<Producto> {
    private final List<Producto> listaProductos = new ArrayList<>();
    protected String ruta = "src\\main\\java\\edu\\ucaldas\\data\\Productos.json";

    public ProductoJSON() {
        obtenerDatosJSON();
    }

    @Override
    public List<Producto> cargarDatos() {
        return listaProductos;
    }

    @Override
    public void obtenerDatosJSON() {
        String contenidoArchivo = "";
        try {
            contenidoArchivo = new String(Files.readAllBytes(
                    Paths.get(ruta)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON de productos: " + e.getMessage());
        }

        JSONArray jsonArray = new JSONArray(contenidoArchivo);
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            String nombre = jsonObject.getString("nombre");
            int edad = jsonObject.getInt("edad");
            double precio = jsonObject.getDouble("precio");
            String proveedor = jsonObject.getString("proveedor");

            Producto producto = new Producto(nombre, edad, precio, proveedor, 0);
            listaProductos.add(producto);
        }
    }

}
