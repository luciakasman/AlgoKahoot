package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VistaMultipleChoiceClasico extends VBox implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private VistaOpcionesMultipleChoice vistaOpciones;
    private final BotonExclusividad botonExclusividad;
    private final Pregunta pregunta;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final int tiempoDisponible = 5;
    private final LabelTiempo labelTiempo;
    private final Juego juego;
    private final SonidoHandler sonido;
    private final ImageView imagenVista;

    public VistaMultipleChoiceClasico(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        this.botonExclusividad = new BotonExclusividad(juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.setSpacing(20);
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.sonido = sonido;
        this.imagenVista = imagenVista;
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        Label labelPregunta = new Label("Multiple Choice Clasico: " + this.pregunta.getPregunta());
        this.getChildren().add(labelPregunta);

        //Agregado de las opciones (se resume mucho si hacemos que las preguntas devuelvan todas las opciones)
        List<Opcion> opciones = new LinkedList<>(this.pregunta.getOpcionesCorrectas());
        opciones.addAll(this.pregunta.getOpcionesIncorrectas());
        Collections.shuffle(opciones);
        vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
        this.getChildren().add(vistaOpciones);

        //Agregado de la exclusividad
        this.getChildren().add(botonExclusividad);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.getChildren().add(botonEnviar);

        update();
    }

    public void update() {
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, imagenVista, sonido, juego);
        } else {
            labelTiempo.start();
            respuesta.clear();
            Jugador jugadorActual = jugadores.remove();
            infoJugador.setText("Turno del jugador: " + jugadorActual.obtenerNombre() + ", puntos: " + jugadorActual.obtenerPuntajeTotal());
            vistaOpciones.update();
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}