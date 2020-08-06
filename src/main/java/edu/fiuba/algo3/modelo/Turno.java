package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.List;

public class Turno {

    private final Pregunta pregunta;
    private Servicio servicio;

    public Turno(Pregunta pregunta, Servicio servicio) {
        this.pregunta = pregunta;
        this.servicio = servicio;
    }

    public void jugarTurno(Jugador jugadorActual) {
        //muestra la pregunta con sus opciones llamando al Controlador
        //recibe las respuestas del front del Controlador
        //evalua las respuestas, guardandose el puntaje
        List<Opcion> respuestas = servicio.obtenerRespuestas();
        Respuesta respuestasObtenidas = pregunta.armarRespuesta(respuestas); //arma la respuesta correspondiente
        jugadorActual.guardarPuntajeDePregunta(evaluarRespuesta(pregunta, respuestasObtenidas));
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {
        return pregunta.obtenerPuntaje(respuesta);
    }
}
