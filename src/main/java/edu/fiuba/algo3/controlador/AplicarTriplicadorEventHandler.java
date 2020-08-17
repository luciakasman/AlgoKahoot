package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AplicarTriplicadorEventHandler implements EventHandler<ActionEvent> {
    private final BotonDuplicador botonDuplicador;
    private Button botonTriplicador;
    private Juego juego = Juego.getInstance();

    public AplicarTriplicadorEventHandler(BotonTriplicador botonTriplicador, BotonDuplicador botonDuplicador){
        this.botonTriplicador = botonTriplicador;
        this.botonDuplicador = botonDuplicador;
    }

    public void handle(ActionEvent actionEvent){
        juego.activarTriplicadorDePuntos();
        botonTriplicador.setText("Aplicar Triplicador (0)");
        botonTriplicador.setDisable(true);
        botonDuplicador.setDisable(true);
    }
}
