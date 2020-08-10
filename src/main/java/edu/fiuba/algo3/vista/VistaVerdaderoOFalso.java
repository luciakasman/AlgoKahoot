package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.botonhandler.AplicarExclusividadEventHandler;
import edu.fiuba.algo3.controladores.botonhandler.EnviarVerdaderoOFalsoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vista.VistaGeneral;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.NoSuchElementException;

public class VistaVerdaderoOFalso extends VBox implements Observador {

    Ronda rondaObservada;
    VistaGeneral vistaGeneral;
    BotonExclusividad botonExclusividad = new BotonExclusividad();
    Label infoJugador = new Label();
    Label labelPregunta;

    public VistaVerdaderoOFalso(Ronda rondaObservada, VistaGeneral vistaGeneral){
        this.setSpacing(20);
        this.rondaObservada = rondaObservada;
        rondaObservada.agregarObservador(this);
        this.vistaGeneral = vistaGeneral;
        armarVistaPropia();
        update();

    }

    private void armarVistaPropia(){
        this.getChildren().add(infoJugador);
        String pregunta = rondaObservada.obtenerPregunta().getPregunta();
        labelPregunta = new Label(pregunta);
        this.getChildren().add(labelPregunta);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso(rondaObservada);
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
