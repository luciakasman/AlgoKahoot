package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.vista.VistaRegistroDeJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IniciarJuegoHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final SonidoHandler sonido;

    public IniciarJuegoHandler(Stage stage, SonidoHandler sonido) {
        super();
        this.stage = stage;
        this.sonido = sonido;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego = new Juego(new GeneradorDePreguntas());
        VistaRegistroDeJugadores vistaRegistroDeJugadores = new VistaRegistroDeJugadores(stage, sonido, juego);
        stage.setTitle("El mejor Kahoot del mundo");
        Scene escena = new Scene(vistaRegistroDeJugadores, 1000, 800);
        stage.setScene(escena);
        stage.show();
    }
}
