package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaMultipleChoiceClasico extends VBox implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final Label infoJugador = new Label();
    private VistaOpcionesMultipleChoice vistaOpciones;
    private final BotonExclusividad botonExclusividad = new BotonExclusividad();
    private final Pregunta pregunta;
    private final Stage stage;
    private final Queue<Jugador> jugadores;

    public VistaMultipleChoiceClasico(Pregunta pregunta, Stage stage) {
        this.setSpacing(20);
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(Juego.getInstance().obtenerJugadores());
    }

    public void armarVistaPropia() {
        Juego.getInstance().guardarObservador(this);

        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);

        //Agregado de la pregunta
        String pregunta = this.pregunta.getPregunta();
        Label labelPregunta = new Label("Multiple Choice Clasico: " + pregunta);
        this.getChildren().add(labelPregunta);

        //Agregado de las opciones (se resume mucho si hacemos que las preguntas devuelvan todas las opciones)
        List<Opcion> opciones = new LinkedList<>(this.pregunta.getOpcionesCorrectas());
        opciones.addAll(this.pregunta.getOpcionesIncorrectas());
        Collections.shuffle(opciones);
        vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
        this.getChildren().add(vistaOpciones);

        //Agregado de la exclusividad
        this.getChildren().add(botonExclusividad);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(respuesta);
        this.getChildren().add(botonEnviar);

        update();
    }

    public void update() {
        if(jugadores.isEmpty()){
            Juego.getInstance().darPuntosAJugadores(new LinkedList<>(Juego.getInstance().obtenerJugadores()));
            if (Juego.getInstance().noQuedanPreguntas()) {
                VistaMostrarGanador vistaFinal = new VistaMostrarGanador(this.stage);
                vistaFinal.mostrarGanador(Juego.getInstance().obtenerJugadores());
            } else {
                VistaRonda vistaRonda = new VistaRonda(this.stage);
                vistaRonda.armarVistaDeRonda();
                Scene scene = new Scene(vistaRonda);
                this.stage.setScene(scene);
            }
        }else{
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

