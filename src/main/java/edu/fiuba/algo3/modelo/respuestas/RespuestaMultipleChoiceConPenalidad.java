package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.LinkedList;
import java.util.List;

public class RespuestaMultipleChoiceConPenalidad implements Respuesta {

    private final List<Opcion> respuestas;

    public RespuestaMultipleChoiceConPenalidad(List<Opcion> respuestas) {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        List<Opcion> interseccionEntreRespuestasYOpcionesCorrectas = new LinkedList<>(respuestas);
        interseccionEntreRespuestasYOpcionesCorrectas.retainAll(opcionesCorrectas);

        int puntajeRespuestasCorrectas = interseccionEntreRespuestasYOpcionesCorrectas.size();
        int puntajeRespuestasIncorrectas = respuestas.size() - puntajeRespuestasCorrectas;

        return puntajeRespuestasCorrectas - puntajeRespuestasIncorrectas;
    }
}
