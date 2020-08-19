package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class EnviarRespuestaEventHandler implements EventHandler<ActionEvent> {

    //Se usaria en to do menos en los verdadero/falso

    private List<Opcion> respuestas;
    private Juego juego;

    public EnviarRespuestaEventHandler(List<Opcion> respuestas, Juego juego){
        this.respuestas = respuestas;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.jugarTurno(this.respuestas);
    }
}
