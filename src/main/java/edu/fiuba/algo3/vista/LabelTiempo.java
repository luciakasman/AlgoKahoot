package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeTiempo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import static javafx.animation.Animation.INDEFINITE;

public class LabelTiempo extends Label {

    private final int tiempoInicio;
    private Timeline timeline = new Timeline();

    public LabelTiempo(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public void start() {
        this.setText("Tiempo: " + tiempoInicio);
        timeline = new Timeline();
        timeline.setCycleCount(INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new ControladorDeTiempo(tiempoInicio, this)));
        timeline.playFromStart();
    }

    public void stop() {
        timeline.stop();
    }
}
