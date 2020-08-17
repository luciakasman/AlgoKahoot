package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaMultipleChoiceParcial implements Respuesta {

    private final List<Opcion> respuestas;
    private final RespuestasHelper respuestasHelper = new RespuestasHelper();

    public RespuestaMultipleChoiceParcial(List<Opcion> respuestas) {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return respuestasHelper.todasLasRespuestasCoincidenConLasOpcionesCorrectas(opcionesCorrectas, respuestas) ?
                respuestas.size() : 0;
    }
}