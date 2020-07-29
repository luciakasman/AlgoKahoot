package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaMultipleChoice implements Respuesta {

    private final List<Opcion> respuesta;

    public RespuestaMultipleChoice(List<Opcion> respuesta){this.respuesta = respuesta ; }


    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {
        boolean exists = respuesta.stream()
                .allMatch(key -> opcionesCorrectas.stream().anyMatch(key2 -> key.equals(key2)));
        return (exists && opcionesCorrectas.size() == respuesta.size()) ? 1 : 0 ;
    }

}
