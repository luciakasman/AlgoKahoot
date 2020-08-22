package edu.fiuba.algo3.controlador.enviadores;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EnterEnviarNombresEventHandler implements EventHandler<KeyEvent> {

    private TextField nombreJugador;
    private Label labelAdvertencia;
    private Juego juego;

    public EnterEnviarNombresEventHandler(TextField nombreJugador, Label labelAdvertencia, Juego juego){
        this.nombreJugador = nombreJugador;
        this.labelAdvertencia = labelAdvertencia;
        this.juego = juego;
    }

    @Override
    public void handle(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER){
            EnviarNombresHelper.enviarNombres(nombreJugador, labelAdvertencia, juego);
        }
    }

}
