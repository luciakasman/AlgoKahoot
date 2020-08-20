package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.AvanzadorDeRondas;
import edu.fiuba.algo3.vista.LabelTiempo;
import edu.fiuba.algo3.vista.Observador;
import edu.fiuba.algo3.vista.VistaOpcionesOrderedChoice;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaOrderedChoice extends VBox implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final List<Opcion> opciones = new ArrayList<>();
    private final Pregunta pregunta;
    private VistaOpcionesOrderedChoice vistaOpciones;
    private final Juego juego;
    private final int tiempoDisponible = 20;
    private final LabelTiempo labelTiempo;
    private final BotonExclusividad botonExclusividad;

    public VistaOrderedChoice( Pregunta pregunta, Stage stage, Juego juego) {
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.botonExclusividad = new BotonExclusividad(juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.setSpacing(20);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        String pregunta = this.pregunta.getPregunta();
        Label labelPregunta = new Label(pregunta);
        this.getChildren().add(labelPregunta);

        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(this.respuesta, this.juego);
        this.getChildren().add(botonEnviar);

        vistaOpciones = new VistaOpcionesOrderedChoice(this.opciones, this.respuesta, this.pregunta, botonEnviar);
        this.getChildren().add(vistaOpciones);

        update();
    }

    @Override
    public void update() {
     //   labelTiempo.stop()
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, juego);
        } else {
         //   labelTiempo.start();
            respuesta.clear();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntos = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntos);
            vistaOpciones.update();
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}