package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.List;

public class Turno {

    private final Pregunta pregunta;
    private Controlador controlador;

    public Turno(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.controlador = new Controlador();
    }

    public void jugarTurno(Jugador jugadorActual) {
        //muestra la pregunta con sus opciones llamando al Controlador
        //recibe las respuestas del front del Controlador
        //evalua las respuestas, guardandose el puntaje
        List<Opcion> respuestas = controlador.obtenerRespuestas();
        Respuesta respuestasObtenidas = pregunta.armarRespuesta(respuestas); //arma la respuesta correspondiente
        jugadorActual.guardarPuntajeDePregunta(evaluarRespuesta(pregunta, respuestasObtenidas));
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {
        return pregunta.obtenerPuntaje(respuesta);
    }
}
