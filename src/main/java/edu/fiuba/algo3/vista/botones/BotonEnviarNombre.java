package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.enviadores.BotonEnviarNombresEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonEnviarNombre extends Button {

    public BotonEnviarNombre(TextField nombreJugador, Label labelAdvertencia, Juego juego) {
        BotonEnviarNombresEventHandler eventHandler = new BotonEnviarNombresEventHandler(nombreJugador, labelAdvertencia, juego);
        this.setOnAction(eventHandler);
        this.setText("Enviar nombre");
        this.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        this.setTranslateY(80);
    }
}
