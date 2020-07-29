package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaMultipleChoiceParcial implements Respuesta {

    private final List<Opcion> respuesta;

    public RespuestaMultipleChoiceParcial(List<Opcion> respuesta){this.respuesta = respuesta ; }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        boolean exists = respuesta.stream()
                .allMatch(key -> opcionesCorrectas.stream().anyMatch(key2 -> key.equals(key2)));

        return exists ? respuesta.size() : 0 ;
    }
}
