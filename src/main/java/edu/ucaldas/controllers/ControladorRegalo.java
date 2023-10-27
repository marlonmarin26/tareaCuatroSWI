package edu.ucaldas.controllers;

import java.util.List;

import edu.ucaldas.model.Almacenamiento;
import edu.ucaldas.model.Producto;
import edu.ucaldas.services.FiltroRegalo;

public class ControladorRegalo {
    FiltroRegalo filtro = new FiltroRegalo();

    public ControladorRegalo() {

    }

    public List<Producto> buscarRegalos(int edad, double costo) {
        Almacenamiento almacen = new Almacenamiento();
        almacen.crearRegalos();
        List<Producto> regalos = almacen.getRegalos();
        regalos = filtro.filtrarPorEdad(regalos, edad);
        regalos = filtro.filtrarPorCosto(regalos, costo);

        return regalos;
    }
}
