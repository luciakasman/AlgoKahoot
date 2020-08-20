package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.AvanzadorDeRondas;
import edu.fiuba.algo3.vista.LabelTiempo;
import edu.fiuba.algo3.vista.Observador;
import edu.fiuba.algo3.vista.VistaOpcionesGroupChoice;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaGroupChoice extends VBox implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private final Stage stage;
    private Queue<Jugador> jugadores;
    private final List<Opcion> opciones = new ArrayList<>();
    private final PreguntaGroupChoice pregunta;
    private VistaOpcionesGroupChoice vistaOpciones;
    private Juego juego;
    private final int tiempoDisponible = 20;
    private LabelTiempo labelTiempo;
    private BotonExclusividad botonExclusividad;

    public VistaGroupChoice(PreguntaGroupChoice pregunta, Stage stage, Juego juego) {
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.botonExclusividad = new BotonExclusividad(juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.setSpacing(20);
    }

    public void armarVistaPropia() {
        this.getChildren().add(labelTiempo);
        juego.guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        String pregunta = this.pregunta.getPregunta();
        Label labelPregunta = new Label(pregunta);
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
            botonExclusividad.actualizar(jugadorActual);
        }
    }
}
