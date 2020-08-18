package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalso extends VBox implements Observador {

    private final BotonExclusividad botonExclusividad = new BotonExclusividad();
    private final Label infoJugador = new Label();
    private final String preguntaLabel;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final LabelTiempo labelTiempo = new LabelTiempo(5);

    public VistaVerdaderoOFalso(Pregunta pregunta, Stage stage) {
        this.preguntaLabel = pregunta.getPregunta();
        this.stage = stage;
        this.jugadores = new LinkedList<>(Juego.getInstance().obtenerJugadores());
        this.setSpacing(20);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        Juego.getInstance().guardarObservador(this);
        this.getChildren().add(infoJugador);
        Label label = new Label("Verdadero o falso clasico : " + this.preguntaLabel);
        this.getChildren().add(label);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso();
        this.getChildren().add(opciones);
        this.getChildren().add(botonExclusividad);
        update();
    }

    @Override
    public void update() {
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage);
        } else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntaje);
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}

