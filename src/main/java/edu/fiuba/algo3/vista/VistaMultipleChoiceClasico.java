package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VistaMultipleChoiceClasico extends StackPane implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private final VistaOpcionesMultipleChoice vistaOpciones;
    private final BotonExclusividad botonExclusividad;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final int tiempoDisponible = 15;
    private final LabelTiempo labelTiempo;
    private final SonidoHandler sonido;
    private final ImageView imagenVista;
    private final Juego juego;
    private final Label tipoPregunta;
    private final Label pregunta;
    private final List<Opcion> opciones;
    private final BotonEnviarRespuesta botonEnviar;

    public VistaMultipleChoiceClasico(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        this.botonExclusividad = new BotonExclusividad(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.sonido = sonido;
        this.imagenVista = imagenVista;
        this.tipoPregunta = new Label("Multiple Choice Clasico: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = new LinkedList<>(pregunta.getOpcionesCorrectas());
        opciones.addAll(pregunta.getOpcionesIncorrectas());
        this.botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        Image imagen = new Image("file:src/resources/imagen12.jpg", 512, 250, true, false);
        imagenVista.setImage(imagen);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vistaOpciones, botonExclusividad, botonEnviar);
        Collections.shuffle(opciones);
        setAlignment(botonExclusividad, Pos.BOTTOM_CENTER);
        setMargin(botonExclusividad, new Insets(0, 0, 0, 300));
        botonExclusividad.setMaxSize(300, 40);
        botonExclusividad.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonExclusividad.setStyle("-fx-background-radius: 15;");
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaMultipleChoice(tipoPregunta, pregunta, labelTiempo, infoJugador, botonEnviar);
        update();
    }

    public void update() {
        //labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, imagenVista, sonido, juego);
        } else {
            //  labelTiempo.start();
            respuesta.clear();
            Jugador jugadorActual = jugadores.remove();
            infoJugador.setText("Turno del jugador: " + jugadorActual.obtenerNombre() + ", puntos: " + jugadorActual.obtenerPuntajeTotal());
            vistaOpciones.update();
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}