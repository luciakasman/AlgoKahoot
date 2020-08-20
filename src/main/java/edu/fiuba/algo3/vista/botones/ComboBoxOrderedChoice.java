package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ComboBoxOpcionHandler;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.List;

public class ComboBoxOrderedChoice extends ComboBox {

    public ComboBoxOrderedChoice(Integer cantidadOpciones, HashMap<String, Integer> respuesta, Opcion opcion, List<Opcion> respuestaFinal) {
        for (Integer i = 1; i <= cantidadOpciones; i++) {
            this.getItems().add(i.toString());
        }
        ComboBoxOpcionHandler handler = new ComboBoxOpcionHandler(this, cantidadOpciones, opcion.getOpcion(), respuestaFinal);
        this.setOnAction(handler);
    }
}
