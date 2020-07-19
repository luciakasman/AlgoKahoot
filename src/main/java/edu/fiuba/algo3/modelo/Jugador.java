package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public void asignarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje(){
        return this.puntaje;
    }
}
