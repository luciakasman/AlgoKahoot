package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.botonhandler.EnviarVerdaderoOFalsoEventHandler;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.scene.control.Button;

public class BotonVerdaderoOFalso extends Button {

    public BotonVerdaderoOFalso(Ronda ronda, String respuesta){
        this.setText(respuesta);
        EnviarVerdaderoOFalsoEventHandler eventHandler = new EnviarVerdaderoOFalsoEventHandler(ronda, this);
        this.setOnAction(eventHandler);
    }

}
