package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaRonda extends VBox {

    private final Stage stage;
    private final SonidoHandler sonido;

    public VistaRonda(Stage stage, SonidoHandler sonido) {
        this.stage = stage;
        this.sonido = sonido;
    }

    public void armarVistaDeRonda(ImageView imagenVista) {
        Pregunta preguntaRonda = Juego.getInstance().obtenerPreguntaNueva();
        if (preguntaRonda.getClass().equals(PreguntaVerdaderoOFalso.class)) {
            VistaVerdaderoOFalso vista = new VistaVerdaderoOFalso(preguntaRonda, stage, imagenVista, sonido);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaVerdaderoOFalsoConPenalidad.class)) {
            VistaVerdaderoOFalsoConPenalidad vista = new VistaVerdaderoOFalsoConPenalidad(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceClasico.class)) {
            VistaMultipleChoiceClasico vista = new VistaMultipleChoiceClasico(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceConPenalidad.class)) {
            VistaMultipleChoiceConPenalidadOParcial vista = new VistaMultipleChoiceConPenalidadOParcial(preguntaRonda, stage);
            vista.armarVistaPropia("con Penalidad");
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceParcial.class)) {
            VistaMultipleChoiceConPenalidadOParcial vista = new VistaMultipleChoiceConPenalidadOParcial(preguntaRonda, stage);
            vista.armarVistaPropia("con Puntaje parcial");
            this.getChildren().add(vista);
        }
        /*
        if (preguntaRonda.getClass().equals(PreguntaOrderedChoice.class)) {
            VistaOrderedChoice vista = new VistaOrderedChoice(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaGroupChoice.class)) {
            VistaGroupChoice vista = new VistaGroupChoice(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }*/
    }
}
