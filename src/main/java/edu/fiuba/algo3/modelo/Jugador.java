package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntaje;
    private Respuesta respuesta;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void asignarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public Respuesta obtenerRespuesta() {
        return respuesta;
    }

    public void asignarRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}
