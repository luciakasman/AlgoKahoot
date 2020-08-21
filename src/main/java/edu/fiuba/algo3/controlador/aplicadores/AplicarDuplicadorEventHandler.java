package edu.fiuba.algo3.controlador.aplicadores;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarDuplicadorEventHandler implements EventHandler<ActionEvent> {

    private final BotonTriplicador botonTriplicador;
    private final Button botonDuplicador;
    private Juego juego;

    public AplicarDuplicadorEventHandler(BotonDuplicador botonDuplicador, BotonTriplicador botonTriplicador, Juego juego) {
        this.botonDuplicador = botonDuplicador;
        this.botonTriplicador = botonTriplicador;
        this.juego = juego;
    }

    public void handle(ActionEvent actionEvent) {
        juego.activarDuplicadorDePuntos();
        botonDuplicador.setText("Aplicar duplicador (0)");
        botonDuplicador.setDisable(true);
        botonTriplicador.setDisable(true);
    }
}
