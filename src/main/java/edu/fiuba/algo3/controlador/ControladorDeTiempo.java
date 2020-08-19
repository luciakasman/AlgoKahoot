package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.List;

public class ControladorDeTiempo implements EventHandler<ActionEvent> {

    private int tiempo;
    private Label labelTiempo;
    private Juego juego;

    public ControladorDeTiempo(int tiempo, Label labelTiempo, Juego juego){
        this.tiempo = tiempo;
        this.labelTiempo = labelTiempo;
        this.juego = juego;
    }

    public void handle(ActionEvent actionEvent){
        tiempo--;
        labelTiempo.setText("Tiempo: " + tiempo);
        if(tiempo == 0){
            Opcion opcionVacia = new Opcion("");
            List<Opcion> listaOpcionVacia = new LinkedList<Opcion>();
            listaOpcionVacia.add(opcionVacia);
            juego.jugarTurno(listaOpcionVacia);
        }
    }

}
