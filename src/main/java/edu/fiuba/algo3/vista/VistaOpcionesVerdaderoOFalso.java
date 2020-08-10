package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vista.botones.BotonVerdaderoOFalso;
import javafx.scene.layout.HBox;

public class VistaOpcionesVerdaderoOFalso extends HBox {

    public VistaOpcionesVerdaderoOFalso(Ronda ronda){
        this.setSpacing(20);
        this.getChildren().add(new BotonVerdaderoOFalso(ronda, "verdadero"));
        this.getChildren().add(new BotonVerdaderoOFalso(ronda, "falso"));
    }

}
