package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;

public class VistaMostrasGanador{
    private Stage stage;

    public VistaMostrasGanador(Stage stage) {
        this.stage = stage;
    }

    public void mostrarGanador(List<Jugador> jugadores){
        Jugador jugadorGanador = jugadores.stream().max(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        Jugador jugadorPerdedor = jugadores.stream().min(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        String textoGanador = "El ganador es " + jugadorGanador.obtenerNombre() + " con " + jugadorGanador.obtenerPuntajeTotal() + " puntos.";
        String textoPerdedor = "El perdedor es " + jugadorPerdedor.obtenerNombre() + " con " + jugadorPerdedor.obtenerPuntajeTotal() + " puntos.";
        Label labelGanador = new Label(textoGanador);
        Label labelPerdedor = new Label(textoPerdedor);
        VBox vboxFinal = new VBox(labelGanador, labelPerdedor);
        Scene escenaGanador = new Scene(vboxFinal);
        stage.setScene(escenaGanador);
    }
}
