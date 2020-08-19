package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarExclusividadEventHandler implements EventHandler<ActionEvent> {

    private final Button botonExclusividad;
    private final Jugador jugadorActual;

    public AplicarExclusividadEventHandler(Button botonExclusividad, Jugador jugadorActual) {
        this.botonExclusividad = botonExclusividad;
        this.jugadorActual = jugadorActual;
    }

    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().aplicarExclusividad();
        int exclusividadDisponible = jugadorActual.obtenerExclusividadDisponible();
        String text = "Aplicar exclusividad (" + exclusividadDisponible + ")";
        botonExclusividad.setText(text);
        botonExclusividad.setDisable(true);
    }
}
