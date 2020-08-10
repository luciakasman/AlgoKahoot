package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.botonhandler.EnviarRespuestaEventHandler;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.scene.control.Button;

import java.util.List;

public class BotonEnviarRespuesta extends Button {

    public BotonEnviarRespuesta(List<Opcion> respuesta, Ronda ronda){
        this.setText("Enviar respuesta");
        EnviarRespuestaEventHandler eventHandler = new EnviarRespuestaEventHandler(respuesta, ronda);
        this.setOnAction(eventHandler);
    }

}
