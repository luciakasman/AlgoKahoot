package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import edu.fiuba.algo3.vista.opciones.VistaOpcionesMultipleChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class VistaMultipleChoiceClasico extends VistaAbstracta implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final VistaOpcionesMultipleChoice vistaOpciones;
    private final BotonExclusividad botonExclusividad;
    private final int tiempoDisponible = 15;
    private final Label tipoPregunta;
    private final Label pregunta;
    private final List<Opcion> opciones;
    private final BotonEnviarRespuesta botonEnviar;

    public VistaMultipleChoiceClasico(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.botonExclusividad = new BotonExclusividad(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.tipoPregunta = new Label("Multiple Choice Clasico: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = pregunta.obtenerOpciones();
        this.botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        Image imagen = new Image("file:src/resources/imagen12.jpg", 512, 250, true, false);
        imagenVista.setImage(imagen);
        VBox vBox = new VBox(vistaOpciones, botonEnviar);
        vBox.setTranslateY(350);
        vBox.setSpacing(50.0);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        setAlignment(botonExclusividad, Pos.BOTTOM_CENTER);
        setMargin(botonExclusividad, new Insets(0, 0, 0, 300));
        botonExclusividad.armarDiseño();
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaMultipleChoice(tipoPregunta, pregunta, labelTiempo, infoJugador, botonEnviar);
        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual){
        respuesta.clear();
        vistaOpciones.update();
        botonExclusividad.actualizar(jugadorActual);
    }
}