package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaOrderedChoice implements Respuesta {
    private final List<Opcion> respuestas;

    public RespuestaOrderedChoice(List<Opcion> respuestas) {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return respuestas.equals(opcionesCorrectas) ? 1 : 0;
    }
}
