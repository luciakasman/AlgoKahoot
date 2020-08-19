package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarExclusividadEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Button;

public class BotonExclusividad extends Button {

    private Juego juego;

    public BotonExclusividad(Juego juego){
        this.juego = juego;
    }

    public void actualizar(Jugador jugadorActual) {
        int exclusividadJugador = jugadorActual.obtenerExclusividadDisponible();
        if(exclusividadJugador != 0){
            AplicarExclusividadEventHandler botonExclusividadEventHandler = new AplicarExclusividadEventHandler(this, juego);
            this.setOnAction(botonExclusividadEventHandler);
            this.setDisable(false);
        } else {
            this.setDisable(true);
        }
        String text = "Aplicar exclusividad (" + exclusividadJugador + ")";
        this.setText(text);
    }
}