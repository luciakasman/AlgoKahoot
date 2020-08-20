package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public abstract class VistaAbstracta extends StackPane {

    protected final Label infoJugador = new Label();
    protected Stage stage;
    protected Queue<Jugador> jugadores;
    protected LabelTiempo labelTiempo;
    protected SonidoHandler sonido;
    protected ImageView imagenVista;
    protected Juego juego;


    public VistaAbstracta(Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        this.stage = stage;
        this.sonido = sonido;
        this.imagenVista = imagenVista;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
    }

    public void update() {
        if(labelTiempo != null) {
            labelTiempo.stop();
        }
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, imagenVista, sonido, juego);
        } else {
            if(labelTiempo != null) {
                labelTiempo.start();
            }
            Jugador jugadorActual = jugadores.remove();
            infoJugador.setText("Turno del jugador: " + jugadorActual.obtenerNombre() + ", puntos: " + jugadorActual.obtenerPuntajeTotal());
            updatePropio(jugadorActual);
        }
    }

    protected abstract void updatePropio(Jugador jugadorActual);

}