package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonVerdaderoOFalso;
import javafx.scene.layout.HBox;

public class VistaOpcionesVerdaderoOFalso extends HBox {

    public VistaOpcionesVerdaderoOFalso() {
        this.setSpacing(20);
        BotonVerdaderoOFalso botonVerdadero = new BotonVerdaderoOFalso("verdadero");
        botonVerdadero.setMaxSize(350,40);
        botonVerdadero.setStyle("-fx-font-size:30; -fx-background-radius: 25;");
        botonVerdadero.setTranslateX(200);
        botonVerdadero.setTranslateY(450);
        this.getChildren().add(botonVerdadero);
        BotonVerdaderoOFalso botonFalso = new BotonVerdaderoOFalso("falso");
        botonFalso.setMaxSize(300,40);
        botonFalso.setStyle("-fx-font-size:30; -fx-background-radius: 25;");
        botonFalso.setTranslateX(400);
        botonFalso.setTranslateY(450);
        this.getChildren().add(botonFalso);
    }

}
