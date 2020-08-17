package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class EnviarRespuestaEventHandler implements EventHandler<ActionEvent> {

    //Se usaria en to do menos en los verdadero/falso

    private List<Opcion> respuestas;

    public EnviarRespuestaEventHandler(List<Opcion> respuestas){
        this.respuestas = respuestas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().jugarTurno(this.respuestas);
    }
}
