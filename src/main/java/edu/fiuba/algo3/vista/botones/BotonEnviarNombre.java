package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarNombresEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonEnviarNombre extends Button {

    public BotonEnviarNombre(TextField nombreJugador, Label labelAdvertencia) {
        EnviarNombresEventHandler eventHandler = new EnviarNombresEventHandler(nombreJugador, labelAdvertencia);
        this.setOnAction(eventHandler);
        this.setText("Enviar nombre");
    }
}
