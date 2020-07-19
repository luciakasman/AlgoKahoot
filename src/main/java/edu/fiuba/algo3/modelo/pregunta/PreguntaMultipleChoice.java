package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

public class PreguntaMultipleChoice extends Pregunta {
    public PreguntaMultipleChoice(String pregunta, List<String> opciones, List<String> opcionesCorrectas) {
        super(pregunta, opciones, opcionesCorrectas);
    }

    //private Integer cantRespuestasCorrectas;

    //Todo el proceso de responder devuelve un puntaje

    //if ( puntaje == cantRespuestasCorrectas ) -> Return 1
}
