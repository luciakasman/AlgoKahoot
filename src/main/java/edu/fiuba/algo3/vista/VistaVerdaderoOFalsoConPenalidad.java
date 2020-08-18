package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class VistaVerdaderoOFalsoConPenalidad extends VBox implements Observador {
    private final Label infoJugador = new Label();
    private final String preguntaLabel;
    private final Stage stage;
    private final Queue<Jugador> jugadores;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores();

    public VistaVerdaderoOFalsoConPenalidad(Pregunta pregunta, Stage stage) {
        this.preguntaLabel = pregunta.getPregunta();
        this.stage = stage;
        this.jugadores = new LinkedList<>(Juego.getInstance().obtenerJugadores());
        this.setSpacing(20);
    }

    public void armarVistaPropia() {
        Juego.getInstance().guardarObservador(this);
        this.getChildren().add(infoJugador);
        Label label = new Label(this.preguntaLabel);
        this.getChildren().add(label);
        VistaOpcionesVerdaderoOFalso opciones = new VistaOpcionesVerdaderoOFalso();
        this.getChildren().add(opciones);
        this.getChildren().add(this.vistaBotonesMultiplicadores);
        update();
    }

    @Override
    public void update() {
        // este if es igual en todas las vistas, difiere el else
        // todo : extraer comportamiento del if en un metodo
        if (jugadores.isEmpty()) {
            Juego.getInstance().darPuntosAJugadores(new LinkedList<>(Juego.getInstance().obtenerJugadores()));
            if (Juego.getInstance().noQuedanPreguntas()) {
                VistaMostrarGanador vistaFinal = new VistaMostrarGanador(this.stage);
                vistaFinal.mostrarGanador(Juego.getInstance().obtenerJugadores());
            } else {
                VistaRonda vistaRonda = new VistaRonda(this.stage);
                vistaRonda.armarVistaDeRonda();
                Scene scene = new Scene(vistaRonda, 900, 600);
                this.stage.setScene(scene);
            }
        } else {
            Jugador jugadorActual = jugadores.remove();
            String nombreJugadorActual = jugadorActual.obtenerNombre();
            int puntaje = jugadorActual.obtenerPuntajeTotal();
            infoJugador.setText("Turno del jugador: " + nombreJugadorActual + ", puntos: " + puntaje);
            this.vistaBotonesMultiplicadores.actualizar();
        }
    }
}
