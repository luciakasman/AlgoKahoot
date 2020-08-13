package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonVerdaderoOFalso;
import javafx.scene.layout.HBox;

public class VistaOpcionesVerdaderoOFalso extends HBox {

    public VistaOpcionesVerdaderoOFalso(){
        this.setSpacing(20);
        this.getChildren().add(new BotonVerdaderoOFalso("verdadero"));
        this.getChildren().add(new BotonVerdaderoOFalso("falso"));
    }

}
