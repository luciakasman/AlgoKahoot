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

    private final Queue<Jugador> jugadores = new LinkedList<>();
    private final GeneradorDePreguntas generadorDePreguntas;
    private Observador observador;
    private final Queue<Pregunta> preguntas;
    private Asignador asignador = new AsignadorComun();
    private Pregunta preguntaActual;

    public Juego(GeneradorDePreguntas generadorDePreguntas) {
        this.generadorDePreguntas = generadorDePreguntas;
        preguntas = crearPreguntas();
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
        actualizarObservador();
    }

    public void aplicarExclusividad() {
        asignador = asignador.aplicarExclusividad();
        jugadorActual().usarExclusividad();
    }
    public int exclusividadDisponibleJugadorActual(){
        return jugadorActual().obtenerExclusividadDisponible();
    }

    public void activarDuplicadorDePuntos() {
        jugadorActual().activarDuplicadorDePuntos();
    }

    public void activarTriplicadorDePuntos() {
        jugadorActual().activarTriplicadorDePuntos();
    }

    public boolean esDuplicadorActivable(){
        return jugadorActual().esDuplicadorActivable();
    }
    public boolean esTriplicadorActivable(){
        return jugadorActual().esTriplicadorActivable();
    }

    private Queue<Pregunta> crearPreguntas() {
        return generadorDePreguntas.obtenerPreguntas();
    }

    public void darPuntosAJugadores(List<Jugador> jugadores) {
        asignador.asignarPuntos(jugadores);
        asignador = new AsignadorComun();
    }

    public boolean noQuedanPreguntas() {
        return this.preguntas.isEmpty();
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
        turno.jugarTurno(jugadorActual(), listaRespuesta);
        actualizarJugadorActual();
        actualizarObservador();
    }

    public Pregunta obtenerPreguntaNueva() {
        this.preguntaActual = preguntas.poll();
        return this.preguntaActual;
    }

    private Jugador jugadorActual(){
        return jugadores.element();
    }

    private void actualizarJugadorActual(){
        Jugador jugadorActual = jugadores.poll();
        jugadores.add(jugadorActual);
    }

}
