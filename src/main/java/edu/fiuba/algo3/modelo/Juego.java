package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.LinkedList;
import java.util.List;

public class Juego {

    private final List<Jugador> jugadores = new LinkedList<>();

    public void comenzarJuego() {
        List<Pregunta> preguntas = crearPreguntas();
        agregarJugador("A0");
        agregarJugador("Cardozo");

        preguntas.forEach(this::jugarRonda);
    }

    private void jugarRonda(Pregunta pregunta) {
        List<Integer> puntaje = new LinkedList<>();
        Ronda ronda = new Ronda(pregunta);
        jugadores.forEach(jugador -> puntaje.add(ronda.jugarRonda(jugador)));
        darPuntosAJugadores(jugadores, puntaje);
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
    }

    private List<Pregunta> crearPreguntas() {
        GeneradorDePreguntas generador = new GeneradorDePreguntas();
        return generador.obtenerPreguntas();
    }

    public void darPuntosAJugadores(List<Jugador> jugadores, List<Integer> puntos) {
        //meter exclusividad

        jugadores.get(0).asignarPuntaje(puntos.get(0));
    }
}
