package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;
import java.util.List;

public class EnviarVerdaderoOFalsoEventHandler implements EventHandler<ActionEvent> {

    private final String respuestaElegida;
    private final Juego juego;

    public EnviarVerdaderoOFalsoEventHandler(String respuesta, Juego juego) {
        this.respuestaElegida = respuesta;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Opcion respuesta = new Opcion(this.respuestaElegida);
        List<Opcion> listaRespuesta = new LinkedList<>();
        listaRespuesta.add(respuesta);
        juego.jugarTurno(listaRespuesta);
    }

}
