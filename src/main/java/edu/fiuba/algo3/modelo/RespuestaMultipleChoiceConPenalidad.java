package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.List;

public class RespuestaMultipleChoiceConPenalidad implements Respuesta {

    private final List<Opcion> respuesta;

    public RespuestaMultipleChoiceConPenalidad(List<Opcion> respuesta){this.respuesta = respuesta ; }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectas) {

        //List<Opcion> interseccion = intersection(respuesta,opcionesCorrectas);
        //puntaje = (interseccion.size() * 2) - respuesta.size();

        List<Opcion> interseccion = new LinkedList<>(respuesta);
        interseccion.retainAll(opcionesCorrectas);
        return (interseccion.size() * 2) - respuesta.size();

    }

}
