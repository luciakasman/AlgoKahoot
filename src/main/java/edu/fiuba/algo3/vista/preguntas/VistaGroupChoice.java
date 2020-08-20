package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class VistaGroupChoice extends VistaAbstracta implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final Stage stage;
    private final List<Opcion> opciones = new ArrayList<>();
    private final PreguntaGroupChoice pregunta;
    private VistaOpcionesGroupChoice vistaOpciones;
    private final Juego juego;
    private final int tiempoDisponible = 20;
    private final LabelTiempo labelTiempo;
    private final BotonExclusividad botonExclusividad;

    public VistaGroupChoice(PreguntaGroupChoice pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.botonExclusividad = new BotonExclusividad(juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        Label labelPregunta = new Label(this.pregunta.getPregunta());
        this.getChildren().add(labelPregunta);

        this.opciones.addAll(this.pregunta.getOpcionesIncorrectas());
        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        vistaOpciones = new VistaOpcionesGroupChoice(opciones, respuesta, this.pregunta);
        this.getChildren().add(vistaOpciones);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.getChildren().add(botonEnviar);

        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual) {
        vistaOpciones.update();
        botonExclusividad.actualizar(jugadorActual);
    }
}
