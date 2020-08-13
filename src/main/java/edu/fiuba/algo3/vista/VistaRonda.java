package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVerdaderoOFalso;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaRonda extends VBox {

    private final Stage stage;

    public VistaRonda(Stage stage) {
        this.stage = stage;
    }

    public void armarVistaDeRonda() {
        Pregunta preguntaRonda = Juego.getInstance().obtenerPreguntaNueva();
        if (preguntaRonda.getClass().equals(PreguntaVerdaderoOFalso.class)) {
            VistaVerdaderoOFalso vista = new VistaVerdaderoOFalso(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
        if (preguntaRonda.getClass().equals(PreguntaMultipleChoiceClasico.class)) {
            VistaMultipleChoiceClasico vista = new VistaMultipleChoiceClasico(preguntaRonda, stage);
            vista.armarVistaPropia();
            this.getChildren().add(vista);
        }
    }
}
