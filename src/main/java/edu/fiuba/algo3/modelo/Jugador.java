package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.respuestas.Respuesta;

public class Jugador {

    private final String nombre;
    private int puntajeTotal;
    private Respuesta respuesta;
    private Multiplicador duplicadorDePuntos;
    private Multiplicador triplicadorDePuntos;
    private int multiplicador;
    private int puntajeDePregunta;
    private int exclusividadDisponible;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntajeTotal = 0;
        this.multiplicador = 1;
        this.exclusividadDisponible = 2;
        this.duplicadorDePuntos = new Multiplicador(2);
        this.triplicadorDePuntos = new Multiplicador(3);
    }

    public void usarExclusividad() {
        if (exclusividadDisponible > 0) {
            exclusividadDisponible -= 1;
        }
    }

    public Multiplicador getDuplicadorDePuntos(){
        return this.duplicadorDePuntos;
    }
    public Multiplicador getTriplicadorDePuntos(){
        return this.triplicadorDePuntos;
    }

    public int getExclusividadDisponible() {
        return exclusividadDisponible;
    }

    public void guardarPuntajeDePregunta(int puntajeDePregunta) {
        this.puntajeDePregunta = puntajeDePregunta;
    }

    public int obtenerPuntajeDePregunta() {
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
        desactivarMultiplicador();
    }

    public Respuesta obtenerRespuesta() {
        return respuesta;
    }

    public void asignarRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public void activarDuplicadorDePuntos() {
        this.multiplicador = this.duplicadorDePuntos.activar();
    }

    public void activarTriplicadorDePuntos() {
        this.multiplicador = this.triplicadorDePuntos.activar();
    }

    public Boolean esDuplicadorActivable(){ return this.duplicadorDePuntos.esActivable(); }

    public Boolean esTriplicadorActivable(){
        return this.triplicadorDePuntos.esActivable();
    }

    public void desactivarMultiplicador() {
        this.multiplicador = 1;
    }
}