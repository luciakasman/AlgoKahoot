package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;
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
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, imagenVista, sonido, juego);
        } else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            infoJugador.setText("Turno del jugador: " + jugadorActual.obtenerNombre() + ", puntos: " + jugadorActual.obtenerPuntajeTotal());
            updatePropio(jugadorActual);
        }
    }

    abstract void updatePropio(Jugador jugadorActual);

}