package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarExclusividadEventHandler implements EventHandler<ActionEvent> {

    private final Button botonExclusividad;
    private final Juego juego;

    public AplicarExclusividadEventHandler(Button botonExclusividad, Juego juego) {
        this.botonExclusividad = botonExclusividad;
        this.juego = juego;
    }

    public void handle(ActionEvent actionEvent) {
        juego.aplicarExclusividad();
        int exclusividadDisponible = juego.exclusividadDisponibleJugadorActual();
        String text = "Aplicar exclusividad (" + exclusividadDisponible + ")";
        botonExclusividad.setText(text);
        botonExclusividad.setDisable(true);
    }
}
