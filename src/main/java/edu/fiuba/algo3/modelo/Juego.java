package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.Queue;

public class Juego {

    private Queue <Jugador>  jugadores;

    public void Juego() {

        this.jugadores = new LinkedList<>();

    }
    public void agregarJugador(String nombre){

        jugadores.add(new Jugador(nombre));

    }
}
