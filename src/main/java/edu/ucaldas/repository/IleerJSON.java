package edu.ucaldas.repository;

import java.io.IOException;
import java.util.List;

public interface IleerJSON<T> {
    List<T> cargarDatos() throws IOException;

    void obtenerDatosJSON() throws IOException;

}
