package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarTriplicadorEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;

public class BotonTriplicador extends Button {

    public void actualizar(BotonDuplicador botonDuplicador) {
        int triplicadorJugador;
        if (Juego.getInstance().esTriplicadorActivable()) {
            triplicadorJugador = 1;
        } else {
            triplicadorJugador = 0;
        }
        String text = "Aplicar triplicador (" + triplicadorJugador + ")";
        this.setText(text);
        AplicarTriplicadorEventHandler botonTriplicadorEventHandler = new AplicarTriplicadorEventHandler(this, botonDuplicador);
        this.setOnAction(botonTriplicadorEventHandler);
        this.setDisable(triplicadorJugador == 0);
    }
}
