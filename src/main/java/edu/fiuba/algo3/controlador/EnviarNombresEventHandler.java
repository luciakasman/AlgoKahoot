package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnviarNombresEventHandler implements EventHandler<ActionEvent> {

    private final TextField textFieldNombre;
    private final Label labelAdvertencia;
    private Juego juego;

    public EnviarNombresEventHandler(TextField textFieldNombre, Label labelAdvertencia, Juego juego) {
        this.labelAdvertencia = labelAdvertencia;
        this.textFieldNombre = textFieldNombre;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (textFieldNombre.getText().trim().isEmpty()) {
            labelAdvertencia.setText("Debes ingresar algo broder");
            return;
        }
        String nombreJugador = textFieldNombre.getText();
        juego.agregarJugador(nombreJugador);
        this.textFieldNombre.setText("");
        this.labelAdvertencia.setText("");
    }
}
