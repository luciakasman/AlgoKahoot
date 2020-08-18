package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.LinkedList;

public class AvanzadorDeRondas {
    public void avanzarRonda(Stage stage){
        Juego.getInstance().darPuntosAJugadores(new LinkedList<>(Juego.getInstance().obtenerJugadores()));
        if (Juego.getInstance().noQuedanPreguntas()) {
            VistaMostrarGanador vistaFinal = new VistaMostrarGanador(stage);
            vistaFinal.mostrarGanador(Juego.getInstance().obtenerJugadores());
        } else {
            VistaRonda vistaRonda = new VistaRonda(stage);
            vistaRonda.armarVistaDeRonda();
            Scene scene = new Scene(vistaRonda);
            stage.setScene(scene);
        }
    }
}
