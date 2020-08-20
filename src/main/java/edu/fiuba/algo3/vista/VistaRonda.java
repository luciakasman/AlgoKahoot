package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.preguntas.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaRonda extends VBox {

    private final Stage stage;
    private final Juego juego;

    public VistaRonda(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }

    public void armarVistaDeRonda(ImageView imagenVista, SonidoHandler sonido) {
        Pregunta preguntaRonda = juego.obtenerPreguntaNueva();
        if (preguntaRonda.getClass().equals(PreguntaVerdaderoOFalso.class)) {
            VistaVerdaderoOFalso vista = new VistaVerdaderoOFalso(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaVerdaderoOFalsoConPenalidad.class)) {
            VistaVerdaderoOFalsoConPenalidad vista = new VistaVerdaderoOFalsoConPenalidad(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceClasico.class)) {
            VistaMultipleChoiceClasico vista = new VistaMultipleChoiceClasico(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceConPenalidad.class)) {
            edu.fiuba.algo3.vista.VistaMultipleChoiceConPenalidadOParcial vista = new edu.fiuba.algo3.vista.VistaMultipleChoiceConPenalidadOParcial(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia("con Penalidad");
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceParcial.class)) {
            edu.fiuba.algo3.vista.VistaMultipleChoiceConPenalidadOParcial vista = new edu.fiuba.algo3.vista.VistaMultipleChoiceConPenalidadOParcial(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia("con Puntaje parcial");
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaOrderedChoice.class)) {
            VistaOrderedChoice vista = new VistaOrderedChoice(preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaGroupChoice.class)) {
            VistaGroupChoice vista = new VistaGroupChoice((PreguntaGroupChoice) preguntaRonda, stage, imagenVista, sonido, juego);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
    }
}
