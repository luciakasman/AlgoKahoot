package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VistaMultipleChoiceConPenalidadOParcial extends StackPane implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private final VistaOpcionesMultipleChoice vistaOpciones;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final int tiempoDisponible = 115;
    private final LabelTiempo labelTiempo;
    private final SonidoHandler sonido;
    private final ImageView imagenVista;
    private final Juego juego;
    private final Label pregunta;
    private final List<Opcion> opciones;
    private final BotonEnviarRespuesta botonEnviar;

    public VistaMultipleChoiceConPenalidadOParcial(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        this.vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.sonido = sonido;
        this.imagenVista = imagenVista;
        this.opciones = new LinkedList<>(pregunta.getOpcionesCorrectas());
        this.opciones.addAll(pregunta.getOpcionesIncorrectas());
        this.pregunta = new Label(pregunta.getPregunta());
        this.botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
    }

    public void armarVistaPropia(String clase) {
        juego.guardarObservador(this);
        Label tipoPregunta = new Label("Multiple Choice " + clase + " : ");
        Image imagen = new Image("file:src/resources/imagen1.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);
        VBox vBox = new VBox(vistaOpciones, botonEnviar, vistaBotonesMultiplicadores);
        vBox.setTranslateY(350);
        vBox.setSpacing(30.0);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        Collections.shuffle(opciones);
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaMultipleChoice(tipoPregunta, pregunta, labelTiempo, infoJugador, botonEnviar);
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
            vistaBotonesMultiplicadores.actualizar();
        }
    }
}