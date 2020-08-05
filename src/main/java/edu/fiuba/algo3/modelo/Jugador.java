package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntaje;
    private Respuesta respuesta;
    private int multiplicador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.multiplicador = 1;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void asignarPuntaje(int puntaje) {
        this.puntaje += (puntaje * multiplicador);
    }

    public Respuesta obtenerRespuesta() {
        return respuesta;
    }

    public void asignarRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public void activarMultiplicadorx2() {
        this.multiplicador = 2;
    }

    public void activarMultiplicadorx3() {
        this.multiplicador = 3;
    }

    public void desactivarMultiplicador() {
        this.multiplicador = 1;
    }
}