package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaVerdaderoOFalso implements Respuesta{

    private final Opcion respuesta;

    public RespuestaVerdaderoOFalso(Opcion respuesta) {
        this.respuesta = respuesta;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas){
        return opcionesCorrectas.stream().anyMatch(opcionCorrecta ->
                opcionCorrecta.obtenerOpcion().equals(respuesta.obtenerOpcion())) ? 1 : 0;
    }
}