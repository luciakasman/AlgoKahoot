package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class VistaMultipleChoiceClasico extends VBox implements Observador {

    private List<Opcion> respuesta = new LinkedList<Opcion>();
    private Label infoJugador = new Label();
    private Label labelPregunta;
    private VistaOpcionesMultipleChoice vistaOpciones;
    private BotonExclusividad botonExclusividad;
    private Pregunta pregunta;

    public VistaMultipleChoiceClasico(Pregunta pregunta){
        this.setSpacing(20);
        this.pregunta = pregunta;
        update();
    }

    public void armarVistaPropia(){
        //Agregado de la info del jugador
        this.getChildren().add(infoJugador);
        //Agregado de la pregunta
        String pregunta = this.pregunta.getPregunta();
        labelPregunta = new Label("Multiple Choice Clasico: " + pregunta);
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
    }

    public void update(){
        try {
            respuesta.clear();
            Jugador jugadorActual = rondaObservada.obtenerJugadorActual();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntos = jugadorActual.obtenerPuntajeTotal();
            String puntosString = String.valueOf(puntos);
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntosString);
            vistaOpciones.update();
            botonExclusividad.actualizar(jugadorActual);
        } catch(NoSuchElementException e) {
            Juego.getInstance().darPuntosAJugadores(Juego.getInstance().obtenerJugadores());
            vistaGeneral.jugarSiguienteRonda();
        }
    }
}
