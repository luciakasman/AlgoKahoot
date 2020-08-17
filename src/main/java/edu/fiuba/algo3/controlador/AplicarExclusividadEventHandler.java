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

    public AplicarExclusividadEventHandler(Button botonExclusividad){
        this.botonExclusividad = botonExclusividad;
    }

    public void handle(ActionEvent actionEvent){
        juego.aplicarExclusividad();
        int exclusividadDisponible = Juego.getInstance().exclusividadDisponibleJugadorActual();
        String text = "Aplicar exclusividad (" + exclusividadDisponible + ")";
        botonExclusividad.setText(text);
        botonExclusividad.setDisable(true);
    }

}
