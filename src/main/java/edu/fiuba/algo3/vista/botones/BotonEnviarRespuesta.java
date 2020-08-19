package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarRespuestaEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.scene.control.Button;

import java.util.List;

public class BotonEnviarRespuesta extends Button {

    public BotonEnviarRespuesta(List<Opcion> respuestas, Juego juego){
        this.setText("Enviar respuesta");
        EnviarRespuestaEventHandler eventHandler = new EnviarRespuestaEventHandler(respuestas, juego);
        this.setOnAction(eventHandler);
    }

}
