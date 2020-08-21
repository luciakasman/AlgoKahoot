package edu.fiuba.algo3.controlador.enviadores;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnviarNombresHelper {

    public static void enviarNombres(TextField nombreJugador, Label labelAdvertencia, Juego juego){
        if (nombreJugador.getText().trim().isEmpty()) {
            labelAdvertencia.setText("Debes ingresar algo broder");
            return;
        }
        juego.agregarJugador(nombreJugador.getText());
        labelAdvertencia.setText("");
        nombreJugador.setText("");
    }

}
