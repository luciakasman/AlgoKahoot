package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.LinkedList;
import java.util.Queue;

public class Juego {

    private Queue<Jugador> jugadores = new LinkedList<>();
    private Queue<Pregunta> preguntas;
    private Jugador jugadorActual;


    public void agregarJugador(String nombre) {

        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
        jugadorActual = jugador;
    }

    public void cambiarJugador() {

        jugadorActual = jugadores.remove();
        jugadores.add(jugadorActual);
    }

    public void comenzarJuego() {

        preguntas = crearPreguntas();
    }

    private Queue<Pregunta> crearPreguntas() {

        GeneradorDePreguntas generador = new GeneradorDePreguntas();
        return generador.obtenerPreguntas();
    }

    public Jugador obtenerJugadorActual() {

        return jugadorActual;
    }

    public void darPuntosAJugador(Pregunta pregunta, Respuesta respuesta) {

        int puntos = evaluarRespuesta(pregunta, respuesta);
        jugadorActual.asignarPuntaje(puntos);
    }

    private int evaluarRespuesta(Pregunta pregunta, Respuesta respuesta) {

        return pregunta.obtenerPuntaje(respuesta);
    }
}
