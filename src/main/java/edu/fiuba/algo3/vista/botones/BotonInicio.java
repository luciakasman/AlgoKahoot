package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.IniciarJuegoHandler;
import edu.fiuba.algo3.controlador.SonidoHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotonInicio extends Button {

    public BotonInicio(Stage stage, SonidoHandler sonido) {
        this.setStyle("-fx-background-radius: 25");
        this.setText("Iniciar juego");
        this.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        this.setOnAction(new IniciarJuegoHandler(stage, sonido));
        this.setMaxSize(300,100);
        this.setTranslateX(10);
        this.setTranslateY(220);
    }
}
