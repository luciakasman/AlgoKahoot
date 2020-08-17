package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaGeneral extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        //stage.setFullScreen(true);
        VistaRegistroDeJugadores vistaRegistroDeJugadores = new VistaRegistroDeJugadores(stage);
        stage.setTitle("El mejor Kahoot del mundo");
        Scene escena = new Scene(vistaRegistroDeJugadores);
        stage.setScene(escena);
        stage.show();
    }
}
