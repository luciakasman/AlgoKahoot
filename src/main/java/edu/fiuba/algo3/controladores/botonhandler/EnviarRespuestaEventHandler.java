package edu.fiuba.algo3.controladores.botonhandler;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class EnviarRespuestaEventHandler implements EventHandler<ActionEvent> {

    //Se usaria en to do menos en los verdadero/falso

    private List<Opcion> respuesta;
    private Ronda ronda;

    public EnviarRespuestaEventHandler(List<Opcion> respuesta, Ronda ronda){
        this.respuesta = respuesta;
        this.ronda = ronda;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        ronda.enviarRespuesta(respuesta);
    }
}
