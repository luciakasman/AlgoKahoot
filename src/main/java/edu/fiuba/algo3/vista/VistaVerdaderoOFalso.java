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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalso extends StackPane implements Observador {

    private final BotonExclusividad botonExclusividad = new BotonExclusividad();
    private final Label infoJugador = new Label();
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final LabelTiempo labelTiempo = new LabelTiempo(5);
    private final ImageView imagenVista;
    private final Label pregunta;
    private final VistaOpcionesVerdaderoOFalso opciones;
    private final SonidoHandler sonido;

    public VistaVerdaderoOFalso(Pregunta pregunta, Stage stage, ImageView imagenVista,  SonidoHandler sonido) {
        String preguntaLabel = pregunta.getPregunta();
        this.stage = stage;
        this.jugadores = new LinkedList<>(Juego.getInstance().obtenerJugadores());
        this.imagenVista = imagenVista;
        this.pregunta = new Label("Verdadero o falso clasico: " + preguntaLabel);
        this.opciones = new VistaOpcionesVerdaderoOFalso();
        this.sonido = sonido;
    }

    public void armarVistaPropia() {
        Juego.getInstance().guardarObservador(this);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, pregunta, opciones, botonExclusividad);
        sonido.reproducirSonido(new File("src/resources/sweet-dreams-kahoot.mp3"));
        crearVistaActual();
        update();
    }

    private void crearVistaActual() {
        Image imagen = new Image("file:src/resources/imagen3.gif",512,250,true,false);
        imagenVista.setImage(imagen);
        pregunta.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        labelTiempo.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        labelTiempo.setTextFill(Color.web("#ff0000"));
        setAlignment(labelTiempo, Pos.TOP_RIGHT);
        setMargin(labelTiempo, new Insets(30, 100, 0, 0));
        setAlignment(infoJugador, Pos.TOP_LEFT);
        setMargin(infoJugador, new Insets(30, 100, 0, 0));
        setAlignment(pregunta, Pos.CENTER);
        setMargin(pregunta, new Insets(0, 0, 300, 0));
        setAlignment(opciones, Pos.BOTTOM_CENTER);
        setAlignment(botonExclusividad, Pos.BOTTOM_CENTER);
        setMargin(botonExclusividad, new Insets(0, 0, 0, 300));

        infoJugador.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonExclusividad.setMaxSize(300, 40);
        botonExclusividad.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonExclusividad.setStyle("-fx-background-radius: 15;");
    }

    @Override
    public void update() {
        labelTiempo.stop();
        if (jugadores.isEmpty()) {
            AvanzadorDeRondas avanzador = new AvanzadorDeRondas();
            avanzador.avanzarRonda(this.stage);
        } else {
            labelTiempo.start();
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntaje);
            botonExclusividad.actualizar(jugadorActual);

        }
    }
}

