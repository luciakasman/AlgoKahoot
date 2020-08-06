package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaGroupChoice implements Respuesta {

    //Tomamos como supuesto que todas las opciones tienen que pertenecer a un grupo

    private final List<Opcion> respuestasGrupoUno;

    public RespuestaGroupChoice(List<Opcion> respuestasGrupoUno) {
        this.respuestasGrupoUno = respuestasGrupoUno;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectasGrupoUno) {

        boolean exists = respuestasGrupoUno.stream()
                .allMatch(key -> opcionesCorrectasGrupoUno.stream().anyMatch(key::equals));

        return (exists && opcionesCorrectasGrupoUno.size() == respuestasGrupoUno.size()) ? 1 : 0;
    }
}
