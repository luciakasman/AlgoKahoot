package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarRespuestaEventHandler;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.scene.control.Button;

import java.util.List;

public class BotonEnviarRespuesta extends Button {

    public BotonEnviarRespuesta(List<Opcion> respuestas){
        this.setText("Enviar respuesta");
        EnviarRespuestaEventHandler eventHandler = new EnviarRespuestaEventHandler(respuestas);
        this.setOnAction(eventHandler);
    }

}
