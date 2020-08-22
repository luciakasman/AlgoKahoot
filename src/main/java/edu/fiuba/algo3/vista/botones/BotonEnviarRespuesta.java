package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.enviadores.EnviarRespuestaEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class BotonEnviarRespuesta extends HBox {

    public BotonEnviarRespuesta(List<Opcion> respuestas, Juego juego){
        Button boton = new Button();
        boton.setText("Enviar respuesta");
        boton.setMaxSize(300,40);
        boton.setStyle("-fx-font-size:30; -fx-background-radius: 25;");
        EnviarRespuestaEventHandler eventHandler = new EnviarRespuestaEventHandler(respuestas, juego);
        boton.setOnAction(eventHandler);
        this.getChildren().add(boton);
        this.setAlignment(Pos.CENTER);
    }
}
