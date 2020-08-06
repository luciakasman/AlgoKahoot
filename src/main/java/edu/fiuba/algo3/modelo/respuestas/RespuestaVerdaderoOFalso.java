package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaVerdaderoOFalso implements Respuesta {

    private final Opcion respuesta;

    public RespuestaVerdaderoOFalso(Opcion respuesta) {
        this.respuesta = respuesta;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return opcionesCorrectas.stream().anyMatch(opcionCorrecta ->
                opcionCorrecta.equals(respuesta)) ? 1 : 0;
    }
}