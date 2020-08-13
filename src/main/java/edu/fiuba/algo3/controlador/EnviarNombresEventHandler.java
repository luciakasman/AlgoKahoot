package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnviarNombresEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldNombre;
    private Label labelAdvertencia;

    public EnviarNombresEventHandler(TextField textFieldNombre, Label labelAdvertencia){
        this.labelAdvertencia = labelAdvertencia;
        this.textFieldNombre = textFieldNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if (textFieldNombre.getText().trim().isEmpty()){
            labelAdvertencia.setText("Debes ingresar algo broder");
            return;
        }
        String nombreJugador = textFieldNombre.getText();
        Juego.getInstance().agregarJugador(nombreJugador);
        this.textFieldNombre.setText("");
        this.labelAdvertencia.setText("");
    }

}
