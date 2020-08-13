package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarVerdaderoOFalsoEventHandler;
import javafx.scene.control.Button;

public class BotonVerdaderoOFalso extends Button {

    public BotonVerdaderoOFalso(String respuesta) {
        this.setText(respuesta);
        EnviarVerdaderoOFalsoEventHandler eventHandler = new EnviarVerdaderoOFalsoEventHandler(respuesta);
        this.setOnAction(eventHandler);
    }

}
