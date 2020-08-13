package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.asignadores.Asignador;
import edu.fiuba.algo3.modelo.asignadores.AsignadorComun;
import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.Observador;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Juego {

    private static Juego INSTANCE;
    private final LinkedList<Jugador> jugadores = new LinkedList<>();
    private GeneradorDePreguntas generadorDePreguntas;
    private List<Observador> observadores = new LinkedList<Observador>();
    private Queue<Pregunta> preguntas;
    private Asignador asignador = new AsignadorComun();
    private Pregunta preguntaActual;
    private Jugador jugadorActual;

    private Juego(GeneradorDePreguntas generadorDePreguntas) {
        this.generadorDePreguntas = generadorDePreguntas;
        preguntas = crearPreguntas();
    }

    public static Juego getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Juego(new GeneradorDePreguntas());
        }
        return INSTANCE;
    }

    public Ronda armarSiguienteRonda(){
        return new Ronda(jugadores, preguntas.remove());
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
        actualizarObservadores();

    }

    public void aplicarExclusividad(){
        asignador = asignador.aplicarExclusividad();
    }

    private Queue<Pregunta> crearPreguntas() {
        return generadorDePreguntas.obtenerPreguntas();
    }

    public void darPuntosAJugadores(List<Jugador> jugadores) {
        asignador.asignarPuntos(jugadores);
        asignador = new AsignadorComun();
    }

    public List<Jugador> obtenerJugadores() {
        return this.jugadores;
    }

    public void agregarObservador(Observador nuevoObservador){
        observadores.add(nuevoObservador);
        actualizarObservadores();
    }

    private void actualizarObservadores(){
        observadores.stream().forEach((observador -> observador.update()));
    }

    public void jugarTurno(List<Opcion> listaRespuesta) {
        Turno turno = new Turno(this.preguntaActual);
        turno.jugarTurno(this.jugadorActual,listaRespuesta);
    }

    public Pregunta obtenerPreguntaNueva() {
        this.preguntaActual = preguntas.poll();
        return this.preguntaActual;
    }
}
