package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeTiempo;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class VistaVerdaderoOFalso extends VBox implements Observador {

    private final BotonExclusividad botonExclusividad = new BotonExclusividad();
    private final Label infoJugador = new Label();
    private final String preguntaLabel;
    private final Stage stage;
    private Queue<Jugador> jugadores;
    private LabelTiempo labelTiempo = new LabelTiempo(5);

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
        Label label = new Label(this.preguntaLabel);
        this.getChildren().add(label);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso();
        this.getChildren().add(opciones);
        this.getChildren().add(botonExclusividad);
        update();
    }

    @Override
    public void update() {
        // este if es igual en todas las vistas, difiere el else
        // todo : extraer comportamiento del if en un metodo
        labelTiempo.stop();
        if(jugadores.isEmpty()){
            Juego.getInstance().darPuntosAJugadores(new LinkedList<>(Juego.getInstance().obtenerJugadores()));
            if (Juego.getInstance().noQuedanPreguntas()) {
                VistaMostrarGanador vistaFinal = new VistaMostrarGanador(this.stage);
                vistaFinal.mostrarGanador(Juego.getInstance().obtenerJugadores());
            } else {
                VistaRonda vistaRonda = new VistaRonda(this.stage);
                vistaRonda.armarVistaDeRonda();
                Scene scene = new Scene(vistaRonda);
                this.stage.setScene(scene);
            }
        }else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntaje);
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}

