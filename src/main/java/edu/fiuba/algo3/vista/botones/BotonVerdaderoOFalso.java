package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarVerdaderoOFalsoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;

public class BotonVerdaderoOFalso extends Button {

    public BotonVerdaderoOFalso(String respuesta, Juego juego) {
        this.setText(respuesta);
        EnviarVerdaderoOFalsoEventHandler eventHandler = new EnviarVerdaderoOFalsoEventHandler(respuesta, juego);
        this.setOnAction(eventHandler);
    }

}
