package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarExclusividadEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Button;

public class BotonExclusividad extends Button {

    public void actualizar(Jugador jugadorActual) {
        int exclusividadJugador = jugadorActual.getExclusividadDisponible();
        String text = "Aplicar exclusividad (" + exclusividadJugador + ")";
        this.setText(text);
        AplicarExclusividadEventHandler botonExclusividadEventHandler = new AplicarExclusividadEventHandler(this);
        this.setOnAction(botonExclusividadEventHandler);
        this.setDisable(exclusividadJugador == 0);
    }
}
