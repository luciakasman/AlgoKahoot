package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaVerdaderoOFalso implements Respuesta {

    private final Opcion respuesta;
    private final RespuestasHelper respuestasHelper = new RespuestasHelper();

    public RespuestaVerdaderoOFalso(Opcion respuesta) {
        this.respuesta = respuesta;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return respuestasHelper.respuestaEsLaOpcionCorrecta(opcionesCorrectas, respuesta) ?
                1 : 0;
    }
}