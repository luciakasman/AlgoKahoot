package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.LinkedList;
import java.util.Queue;

public class Ronda {

    private final Pregunta pregunta;
    private Respuesta respuesta;
    private Queue<Jugador> jugadores = new LinkedList<>();
    private Jugador jugadorActual;

    public Ronda(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public int jugarRonda(Jugador jugadorActual){
        //muestra la pregunta con sus opciones llamando al Controlador
        //recibe las respuestas del front del Controlador
        //evalua las respuestas, guardandose el puntaje
        Respuesta respuestasObtenidas = pregunta.armarRespuesta(new Opcion("v")); //arma la respuesta correspondiente
        return evaluarRespuesta(pregunta, respuestasObtenidas);
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {
        return pregunta.obtenerPuntaje(respuesta);
    }
}
