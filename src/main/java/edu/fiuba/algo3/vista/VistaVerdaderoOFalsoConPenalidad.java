package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalsoConPenalidad extends VBox implements Observador {
    private final Label infoJugador = new Label();
    private final String preguntaLabel;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final int tiempoDisponible = 5;
    private LabelTiempo labelTiempo;
    private Juego juego;

    public VistaVerdaderoOFalsoConPenalidad(Pregunta pregunta, Stage stage, Juego juego) {
        this.juego = juego;
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
        this.preguntaLabel = pregunta.getPregunta();
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.setSpacing(20);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);
        this.getChildren().add(infoJugador);
        Label label = new Label("Verdadero o falso con penalidad : " + this.preguntaLabel);
        this.getChildren().add(label);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso(juego);
        this.getChildren().add(opciones);
        this.getChildren().add(this.vistaBotonesMultiplicadores);
        update();
    }

    @Override
    public void update() {
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, juego);
        } else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntaje);
            vistaBotonesMultiplicadores.actualizar();
        }
    }
}
