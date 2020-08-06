package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public interface Respuesta {

    int obtenerPuntaje(List<Opcion> opcionesCorrectas);
}
