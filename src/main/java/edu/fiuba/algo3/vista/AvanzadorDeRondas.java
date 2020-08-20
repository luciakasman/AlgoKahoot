package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.LinkedList;

public class AvanzadorDeRondas {

    public void avanzarRonda(Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego){
        juego.darPuntosAJugadores(new LinkedList<>(juego.obtenerJugadores()));
        if (juego.noQuedanPreguntas()) {
            VistaMostrarGanador vistaFinal = new VistaMostrarGanador(stage);
            vistaFinal.mostrarGanador(juego.obtenerJugadores());
        } else {
            VistaRonda vistaRonda = new VistaRonda(stage, juego);
            vistaRonda.armarVistaDeRonda(imagenVista, sonido);
            Scene scene = new Scene(vistaRonda);
            stage.setScene(scene);
        }
    }

    public void avanzarRonda(Stage stage, Juego juego) {
    }
}
