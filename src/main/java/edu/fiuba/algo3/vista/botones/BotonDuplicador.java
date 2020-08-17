package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarDuplicadorEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;

public class BotonDuplicador extends Button {

    public void actualizar(BotonTriplicador botonTriplicador) {
        int duplicadorJugador;
        if (Juego.getInstance().esDuplicadorActivable()) {
            duplicadorJugador = 1;
            AplicarDuplicadorEventHandler botonDuplicadorEventHandler = new AplicarDuplicadorEventHandler(this, botonTriplicador);
            this.setOnAction(botonDuplicadorEventHandler);
        } else {
            duplicadorJugador = 0;
            this.setDisable(true);
        }
        String text = "Aplicar Duplicador (" + duplicadorJugador + ")";
        this.setText(text);
    }
}
