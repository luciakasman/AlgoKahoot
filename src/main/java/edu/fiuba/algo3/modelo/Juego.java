package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.asignadores.Asignador;
import edu.fiuba.algo3.modelo.asignadores.AsignadorComun;
import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.Observador;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Juego {

    private static Juego INSTANCE;
    private final Queue<Jugador> jugadores = new LinkedList<>();
    private final GeneradorDePreguntas generadorDePreguntas;
    private Observador observador;
    private final Queue<Pregunta> preguntas;
    private Asignador asignador = new AsignadorComun();
    private Pregunta preguntaActual;
    private Jugador jugadorActual;

    private Juego(GeneradorDePreguntas generadorDePreguntas) {
        this.generadorDePreguntas = generadorDePreguntas;
        preguntas = crearPreguntas();
    }

    public static Juego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego(new GeneradorDePreguntas());
        }
        return INSTANCE;
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
        actualizarObservador();
    }

    public void aplicarExclusividad() {
        asignador = asignador.aplicarExclusividad();
    }

    private Queue<Pregunta> crearPreguntas() {
        return generadorDePreguntas.obtenerPreguntas();
    }

    public void darPuntosAJugadores(List<Jugador> jugadores) {
        asignador.asignarPuntos(jugadores);
        asignador = new AsignadorComun();
    }

    public Queue<Jugador> obtenerJugadores() {
        return this.jugadores;
    }

    public void guardarObservador(Observador observador) {
        this.observador = observador;
    }

    private void actualizarObservador() {
        observador.update();
    }

    public void jugarTurno(List<Opcion> listaRespuesta) {
        Turno turno = new Turno(this.preguntaActual);
        turno.jugarTurno(obtenerJugadorActual(), listaRespuesta);
        actualizarObservador();
    }

    public Pregunta obtenerPreguntaNueva() {
        this.preguntaActual = preguntas.poll();
        return this.preguntaActual;
    }

    public Jugador obtenerJugadorActual() {
        this.jugadorActual = jugadores.poll();
        jugadores.add(this.jugadorActual);
        return this.jugadorActual;
    }
}
