package edu.fiuba.algo3.controladores.botonhandler;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.LinkedList;
import java.util.List;

public class EnviarVerdaderoOFalsoEventHandler implements EventHandler<ActionEvent> {

    private Ronda ronda;
    private Button botonRespuesta;

    public EnviarVerdaderoOFalsoEventHandler(Ronda ronda, Button botonRespuesta){
        this.ronda = ronda;
        this.botonRespuesta = botonRespuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Opcion respuesta = new Opcion(botonRespuesta.getText());
        List<Opcion> listaRespuesta = new LinkedList<Opcion>();
        listaRespuesta.add(respuesta);
        ronda.enviarRespuesta(listaRespuesta);

    }

}
