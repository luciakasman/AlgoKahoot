package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.*;

public class VistaOrderedChoice extends VistaAbstracta implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final List<Opcion> opciones = new ArrayList<>();
    private final Pregunta pregunta;
    private VistaOpcionesOrderedChoice vistaOpciones;
    private final int tiempoDisponible = 30;
    private final BotonExclusividad botonExclusividad;

    public VistaOrderedChoice(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.botonExclusividad = new BotonExclusividad(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        Label labelPregunta = new Label(this.pregunta.getPregunta());
        this.getChildren().add(labelPregunta);

        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(this.respuesta, this.juego);
        this.getChildren().add(botonEnviar);

        vistaOpciones = new VistaOpcionesOrderedChoice(this.opciones, this.respuesta, botonEnviar);
        this.getChildren().add(vistaOpciones);

        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual){
        vistaOpciones.update();
        botonExclusividad.actualizar(jugadorActual);
    }
}
