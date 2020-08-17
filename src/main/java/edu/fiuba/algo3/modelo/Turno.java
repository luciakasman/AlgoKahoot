package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.List;

public class Turno {
    private final Pregunta pregunta;

    public Turno(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void jugarTurno(Jugador jugadorActual, List<Opcion> respuestas) {
        Respuesta respuestasObtenidas = pregunta.armarRespuesta(respuestas);
        jugadorActual.guardarPuntajeDePregunta(evaluarRespuesta(pregunta, respuestasObtenidas));
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {
        return pregunta.obtenerPuntaje(respuesta);
    }
}
