package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.List;

public class Turno {

    //Clase que no se usa en esta version (reemplazada por clase Ronda)

    private final Pregunta pregunta;

    public Turno(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void jugarTurno(Jugador jugadorActual,List<Opcion> respuestas) {
        //muestra la pregunta con sus opciones llamando al Controlador
        //recibe las respuestas del front del Controlador
        //evalua las respuestas, guardandose el puntaje
        Respuesta respuestasObtenidas = pregunta.armarRespuesta(respuestas); //arma la respuesta correspondiente
        jugadorActual.guardarPuntajeDePregunta(evaluarRespuesta(pregunta, respuestasObtenidas));
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {
        return pregunta.obtenerPuntaje(respuesta);
    }
}
