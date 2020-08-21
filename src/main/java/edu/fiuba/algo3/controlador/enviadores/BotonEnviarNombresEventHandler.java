package edu.fiuba.algo3.controlador.enviadores;

import edu.fiuba.algo3.controlador.enviadores.EnviarNombresHelper;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonEnviarNombresEventHandler implements EventHandler<ActionEvent> {

    private final TextField textFieldNombre;
    private final Label labelAdvertencia;
    private Juego juego;

    public BotonEnviarNombresEventHandler(TextField textFieldNombre, Label labelAdvertencia, Juego juego) {
        this.labelAdvertencia = labelAdvertencia;
        this.textFieldNombre = textFieldNombre;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        EnviarNombresHelper.enviarNombres(textFieldNombre, labelAdvertencia, juego);
    }
}
