package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarExclusividadEventHandler implements EventHandler<ActionEvent> {

    private Button botonExclusividad;
    private Juego juego = Juego.getInstance();
    private Jugador jugadorActual;

    public AplicarExclusividadEventHandler(Button botonExclusividad, Jugador jugadorActual){
        this.botonExclusividad = botonExclusividad;
        this.jugadorActual = jugadorActual;
    }

    public void handle(ActionEvent actionEvent){
        juego.aplicarExclusividad();
        jugadorActual.usarExclusividad();
        int exclusividadDisponible = jugadorActual.getExclusividadDisponible();
        String text = "Aplicar exclusividad (" + String.valueOf(exclusividadDisponible) + ")";
        botonExclusividad.setText(text);
        botonExclusividad.setDisable(true);
    }

}
