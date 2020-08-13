package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.NoSuchElementException;

public class VistaVerdaderoOFalso extends VBox implements Observador {

    Ronda rondaObservada;
    VistaGeneral vistaGeneral;
    BotonExclusividad botonExclusividad = new BotonExclusividad();
    Label infoJugador = new Label();
    String preguntaLabel;

    public VistaVerdaderoOFalso(String preguntaLabel){
        this.preguntaLabel = preguntaLabel;
        this.setSpacing(20);
        update();
    }

    public void armarVistaPropia(){
        this.getChildren().add(infoJugador);
        Label label = new Label(this.preguntaLabel);
        this.getChildren().add(label);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso();
        this.getChildren().add(opciones);
        this.getChildren().add(botonExclusividad);
    }

    @Override
    public void update(){
        //Actualiza el label
        try{
            Jugador jugadorActual = rondaObservada.obtenerJugadorActual();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            String puntajeString = String.valueOf(puntaje);
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntajeString);
            botonExclusividad.actualizar(jugadorActual);
        } catch(NoSuchElementException e) {
            Juego.getInstance().darPuntosAJugadores(Juego.getInstance().obtenerJugadores());
            vistaGeneral.jugarSiguienteRonda();
        }
    }
}
