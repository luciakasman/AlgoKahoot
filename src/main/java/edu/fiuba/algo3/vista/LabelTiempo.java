package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeTiempo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class LabelTiempo extends Label {

    private int tiempoInicio;
    private Timeline timeline = new Timeline(); /* hago este new porque sino
    se rompe en el stop cuando no se llamo anteriormente a un start ( cosa que pasa )
    se podria evitar con un if pero no se no me gustaba qcyoxdxdxxxdxdxd*/

    public LabelTiempo(int tiempoInicio){
        this.tiempoInicio = tiempoInicio;
    }

    public void start(){
        this.setText("Tiempo: " + tiempoInicio);
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new ControladorDeTiempo(tiempoInicio, this)));
        timeline.playFromStart();
    }

    public void stop(){
        timeline.stop();
    }
}
