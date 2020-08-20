package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import edu.fiuba.algo3.vista.opciones.VistaOpcionesGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
    private final ImageView imagenVista;
    private final SonidoHandler sonido;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final BotonExclusividad botonExclusividad;


    public VistaGroupChoice(PreguntaGroupChoice pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.botonExclusividad = new BotonExclusividad(juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.imagenVista = imagenVista;
        this.sonido = sonido;
        this.vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        Label tipoPregunta = new Label("Pregunta Group Choice:");

        //Agregado de la pregunta
        Label labelPregunta = new Label(this.pregunta.getPregunta());

        this.opciones.addAll(this.pregunta.getOpcionesIncorrectas());
        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        vistaOpciones = new VistaOpcionesGroupChoice(opciones, respuesta, this.pregunta);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(respuesta, juego);

        Image imagen = new Image("file:src/resources/imagen1.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);

        vistaBotonesMultiplicadores.setAlignment(Pos.BOTTOM_CENTER);
        VBox vBox = new VBox(vistaOpciones, botonEnviar, vistaBotonesMultiplicadores);
        vBox.setTranslateY(200);
        vBox.setSpacing(50);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, labelPregunta, vBox);

        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaGroupChoice(tipoPregunta, labelPregunta, labelTiempo, infoJugador, botonEnviar);

        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual) {
        vistaOpciones.update();
        botonExclusividad.actualizar(jugadorActual);
    }
}
