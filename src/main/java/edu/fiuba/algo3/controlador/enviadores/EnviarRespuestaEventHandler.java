package edu.fiuba.algo3.controlador.enviadores;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class EnviarRespuestaEventHandler implements EventHandler<ActionEvent> {
    private final List<Opcion> respuestas;
    private final Juego juego;

    public EnviarRespuestaEventHandler(List<Opcion> respuestas, Juego juego){
        this.respuestas = respuestas;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.jugarTurno(this.respuestas);
    }
}
