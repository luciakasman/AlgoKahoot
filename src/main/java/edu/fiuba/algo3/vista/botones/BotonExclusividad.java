package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarExclusividadEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Button;

public class BotonExclusividad extends Button {

    public void actualizar(Jugador jugadorActual) {
        int exclusividadJugador = jugadorActual.obtenerExclusividadDisponible();
        if(exclusividadJugador != 0){
            AplicarExclusividadEventHandler botonExclusividadEventHandler = new AplicarExclusividadEventHandler(this);
            this.setOnAction(botonExclusividadEventHandler);
        } else {
            this.setDisable(true);
        }
        String text = "Aplicar exclusividad (" + exclusividadJugador + ")";
        this.setText(text);
    }
}