package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaMultipleChoiceClasico implements Respuesta {

    private final List<Opcion> respuestas;

    public RespuestaMultipleChoiceClasico(List<Opcion> respuestas) {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        boolean exists = respuestas.stream()
                .allMatch(key -> opcionesCorrectas.stream().anyMatch(key::equals));

        return (exists && opcionesCorrectas.size() == respuestas.size()) ? 1 : 0;
    }
}
