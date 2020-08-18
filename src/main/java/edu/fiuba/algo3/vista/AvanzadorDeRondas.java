package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.LinkedList;

public class AvanzadorDeRondas {
    public void avanzarRonda(Stage stage){
        Juego.getInstance().darPuntosAJugadores(new LinkedList<>(Juego.getInstance().obtenerJugadores()));
        if (Juego.getInstance().noQuedanPreguntas()) {
            VistaMostrarGanador vistaFinal = new VistaMostrarGanador(stage);
            vistaFinal.mostrarGanador(Juego.getInstance().obtenerJugadores());
        } else {
            VistaRonda vistaRonda = new VistaRonda(stage, new SonidoHandler());
            vistaRonda.armarVistaDeRonda(new ImageView());
            Scene scene = new Scene(vistaRonda);
            stage.setScene(scene);
        }
    }
}
