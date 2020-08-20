package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.EnviarRespuestaEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.scene.control.Button;

import java.util.List;

public class BotonEnviarRespuesta extends Button {

    public BotonEnviarRespuesta(List<Opcion> respuestas, Juego juego){
        this.setText("Enviar respuesta");
        this.setMaxSize(300,40);
        this.setStyle("-fx-font-size:30; -fx-background-radius: 25;");
        EnviarRespuestaEventHandler eventHandler = new EnviarRespuestaEventHandler(respuestas, juego);
        this.setOnAction(eventHandler);
    }

}
