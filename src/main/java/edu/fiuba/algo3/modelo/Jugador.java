package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.respuestas.Respuesta;

public class Jugador {

    private final String nombre;
    private int puntajeTotal;
    private Respuesta respuesta;
    private int multiplicador;
    private int puntajeDePregunta;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntajeTotal = 0;
        this.multiplicador = 1;
    }

    public void guardarPuntajeDePregunta(int puntajeDePregunta){
        this.puntajeDePregunta = puntajeDePregunta;
    }

    public int obtenerPuntajeDePregunta(){
        return this.puntajeDePregunta;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerPuntajeTotal() {
        return this.puntajeTotal;
    }

    public void asignarPuntajeTotal() {
        this.puntajeTotal += (puntajeDePregunta * multiplicador);
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