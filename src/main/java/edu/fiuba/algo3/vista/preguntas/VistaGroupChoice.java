package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaGroupChoice extends StackPane implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private final Stage stage;
    private Queue<Jugador> jugadores;
    private final List<Opcion> opciones = new ArrayList<>();
    private final PreguntaGroupChoice pregunta;
    private VistaOpcionesGroupChoice vistaOpciones;
    private Juego juego;
    private final int tiempoDisponible = 100;
    private LabelTiempo labelTiempo;
    private final ImageView imagenVista;
    private final SonidoHandler sonido;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;


    public VistaGroupChoice(PreguntaGroupChoice pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.imagenVista = imagenVista;
        this.sonido = sonido;
        this.vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        Label tipoPregunta = new Label("Pregunta Group Choice:");

        //Agregado de la pregunta
        String pregunta = this.pregunta.getPregunta();
        Label labelPregunta = new Label(pregunta);

        this.opciones.addAll(this.pregunta.getOpcionesIncorrectas());
        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        vistaOpciones = new VistaOpcionesGroupChoice(opciones, respuesta, this.pregunta);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(respuesta, juego);

        Image imagen = new Image("file:src/resources/imagen1.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);
        VBox vBox = new VBox(vistaOpciones, botonEnviar, vistaBotonesMultiplicadores);
        vBox.setSpacing(30.0);
        vBox.setTranslateY(250);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, labelPregunta, vBox);

        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaGroupChoice(tipoPregunta, labelPregunta, labelTiempo, infoJugador, botonEnviar);

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
            respuesta.clear();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntos = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntos);
            vistaOpciones.update();
            vistaBotonesMultiplicadores.actualizar();
        }
    }
}
