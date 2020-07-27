package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaVerdaderoOFalsoConPenalidad implements Respuesta{

    private final Opcion respuesta;

    public RespuestaVerdaderoOFalsoConPenalidad(Opcion respuesta) {
        this.respuesta = respuesta;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        return opcionesCorrectas.stream().anyMatch(opcionCorrecta ->
                opcionCorrecta.obtenerOpcion().equals(respuesta.obtenerOpcion())) ? 1 : -1;
    }
}
