package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarDuplicadorEventHandler implements EventHandler<ActionEvent> {

    private final BotonTriplicador botonTriplicador;
    private final Button botonDuplicador;
    private final Juego juego = Juego.getInstance();

    public AplicarDuplicadorEventHandler(BotonDuplicador botonDuplicador, BotonTriplicador botonTriplicador) {
        this.botonDuplicador = botonDuplicador;
        this.botonTriplicador = botonTriplicador;
    }

    public void handle(ActionEvent actionEvent) {
        juego.activarDuplicadorDePuntos();
        botonDuplicador.setText("Aplicar duplicador (0)");
        botonDuplicador.setDisable(true);
        botonTriplicador.setDisable(true);
    }
}
