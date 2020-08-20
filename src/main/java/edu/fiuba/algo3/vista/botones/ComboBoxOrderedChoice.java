package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ComboBoxOpcionHandler;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;
import java.util.Map;

public class ComboBoxOrderedChoice extends ComboBox {

    public ComboBoxOrderedChoice(Integer cantidadOpciones, Map<String, Integer> respuesta, Opcion opcion, List<Opcion> respuestaFinal, BotonEnviarRespuesta botonEnviarRespuesta, Map<Integer, String> respuestasElegidasSinRepetir) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 1; i <= cantidadOpciones; i++) {
            items.add(String.valueOf(i));
        }
        this.setItems(items);

        ComboBoxOpcionHandler handler = new ComboBoxOpcionHandler(this, cantidadOpciones, opcion.getOpcion(), respuesta, botonEnviarRespuesta, respuestasElegidasSinRepetir, respuestaFinal);
        this.setOnAction(handler);
    }
}
