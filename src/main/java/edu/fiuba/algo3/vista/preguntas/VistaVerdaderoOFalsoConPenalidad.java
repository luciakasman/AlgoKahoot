package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import edu.fiuba.algo3.vista.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalsoConPenalidad extends StackPane implements Observador {
    private final Label infoJugador = new Label();
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final LabelTiempo labelTiempo;
    private final ImageView imagenVista;
    private final Label pregunta;
    private final Label tipoPregunta;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final Juego juego;
    private final VistaOpcionesVerdaderoOFalso opciones;
    private final SonidoHandler sonido;
    private int tiempoDisponible = 15;

    public VistaVerdaderoOFalsoConPenalidad(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        this.juego = juego;
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.imagenVista = imagenVista;
        this.tipoPregunta = new Label("Verdadero o falso con penalidad: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = new VistaOpcionesVerdaderoOFalso(juego);
        this.sonido = sonido;
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        VBox vBox = new VBox(opciones, vistaBotonesMultiplicadores);
        vBox.setTranslateY(350);
        vBox.setSpacing(50.0);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        Image imagen = new Image("file:src/resources/imagen2.jpg", 512, 250, true, false);
        imagenVista.setImage(imagen);
        tipoPregunta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        setMargin(tipoPregunta, new Insets(100, 5, 0, 0));
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
            vistaBotonesMultiplicadores.actualizar();
        }
    }
}
