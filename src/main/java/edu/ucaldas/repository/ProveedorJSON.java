package edu.ucaldas.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.ucaldas.model.Proveedor;

public class ProveedorJSON implements IleerJSON<Proveedor> {
    private final List<Proveedor> listaProveedores = new ArrayList<>();
    protected String ruta = "src\\\\main\\\\java\\\\edu\\\\ucaldas\\\\data\\\\Proveedores.json";

    public ProveedorJSON() {
        obtenerDatosJSON();
    }

    @Override
    public List<Proveedor> cargarDatos() {
        return listaProveedores;
    }

    @Override
    public void obtenerDatosJSON() {
        String contenidoArchivo = "";
        try {
            contenidoArchivo = new String(Files.readAllBytes(
                    Paths.get(ruta)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON de proveedores: " + e.getMessage());
        }

        JSONArray jsonArray = new JSONArray(contenidoArchivo);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String nombre = jsonObject.getString("nombre");
            double precioEnvio = jsonObject.getDouble("precioEnvio");

            Proveedor proveedor = new Proveedor(nombre, precioEnvio);
            listaProveedores.add(proveedor);
        }
    }
}