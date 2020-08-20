package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
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

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalso extends StackPane implements Observador {

    private final BotonExclusividad botonExclusividad;
    private final Label infoJugador = new Label();
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final int tiempoDisponible = 5;
    private final LabelTiempo labelTiempo;
    private final ImageView imagenVista;
    private final Label pregunta;
    private final Label tipoPregunta;
    private final VistaOpcionesVerdaderoOFalso opciones;
    private final SonidoHandler sonido;
    private final Juego juego;

    public VistaVerdaderoOFalso(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        botonExclusividad = new BotonExclusividad(juego);
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.imagenVista = imagenVista;
        this.tipoPregunta = new Label("Verdadero o falso clasico: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = new VistaOpcionesVerdaderoOFalso(juego);
        this.sonido = sonido;
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, opciones, botonExclusividad);
        sonido.reproducirSonido(new File("src/resources/sweet-dreams-kahoot.mp3"));
        Image imagen = new Image("file:src/resources/imagen3.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);
        setAlignment(botonExclusividad, Pos.BOTTOM_CENTER);
        setMargin(botonExclusividad, new Insets(0, 0, 0, 300));
        botonExclusividad.setMaxSize(300, 40);
        botonExclusividad.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonExclusividad.setStyle("-fx-background-radius: 15;");
        tipoPregunta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        setMargin(tipoPregunta, new Insets(80, 5, 0, 0));

        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaVerdaderoOFalso(tipoPregunta, pregunta, labelTiempo, opciones, infoJugador);
        update();
    }

    @Override
    public void update() {
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage, imagenVista, sonido, juego);
        } else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            infoJugador.setText("Turno del jugador: " + jugadorActual.obtenerNombre() + ", puntos: " + jugadorActual.obtenerPuntajeTotal());
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}