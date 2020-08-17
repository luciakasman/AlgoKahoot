package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntajeTotal;
    private final Multiplicador duplicadorDePuntos;
    private final Multiplicador triplicadorDePuntos;
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

    public int obtenerExclusividadDisponible() {
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

    public void activarDuplicadorDePuntos() {
        this.multiplicador = this.duplicadorDePuntos.activar();
    }

    public void activarTriplicadorDePuntos() {
        this.multiplicador = this.triplicadorDePuntos.activar();
    }

    public boolean esDuplicadorActivable() {
        return this.duplicadorDePuntos.esActivable();
    }

    public boolean esTriplicadorActivable() {
        return this.triplicadorDePuntos.esActivable();
    }

    public void desactivarMultiplicador() {
        this.multiplicador = 1;
    }
}