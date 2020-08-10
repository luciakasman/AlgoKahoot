package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVerdaderoOFalso;
import javafx.scene.layout.VBox;

public class VistaRonda extends VBox {

    public VistaRonda(Ronda ronda, VistaGeneral vistaGeneral){
        armarVistaDeRonda(ronda, vistaGeneral);
    }

    private void armarVistaDeRonda(Ronda ronda, VistaGeneral vistaGeneral){
        Pregunta preguntaRonda = ronda.obtenerPregunta();
        if (preguntaRonda instanceof PreguntaVerdaderoOFalso){
            VistaVerdaderoOFalso vista = new VistaVerdaderoOFalso(ronda, vistaGeneral);
            this.getChildren().add(vista);
        }
        if (preguntaRonda instanceof PreguntaMultipleChoiceClasico){
            VistaMultipleChoiceClasico vista = new VistaMultipleChoiceClasico(ronda, vistaGeneral);
            this.getChildren().add(vista);
        }
    }
}
