package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaMultipleChoiceParcial implements Respuesta {

    private final List<Opcion> respuestas;

    public RespuestaMultipleChoiceParcial(List<Opcion> respuestas) {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        boolean exists = respuestas.stream()
                .allMatch(key -> opcionesCorrectas.stream().anyMatch(key::equals));

        return exists ? respuestas.size() : 0;
    }
}
