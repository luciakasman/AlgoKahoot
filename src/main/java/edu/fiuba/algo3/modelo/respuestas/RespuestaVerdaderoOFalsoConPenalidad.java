package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaVerdaderoOFalsoConPenalidad implements Respuesta {

    private final Opcion respuesta;
    private final RespuestasUtils respuestasUtils = new RespuestasUtils();

    public RespuestaVerdaderoOFalsoConPenalidad(Opcion respuesta) {
        this.respuesta = respuesta;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return respuestasUtils.respuestaEsLaOpcionCorrecta(opcionesCorrectas, respuesta) ?
                1 : -1;
    }
}
