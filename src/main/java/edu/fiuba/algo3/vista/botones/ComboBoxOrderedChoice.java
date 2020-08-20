package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ComboBoxOpcionHandler;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.List;

public class ComboBoxOrderedChoice extends ComboBox {

    public ComboBoxOrderedChoice(Integer cantidadOpciones, HashMap<Integer,String> respuesta, Opcion opcion, List<Opcion> respuestaFinal) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 1; i <= cantidadOpciones; i++) {
            items.add(String.valueOf(i));
        }
        this.setItems(items);
        System.out.println(opcion.getOpcion());
        ComboBoxOpcionHandler handler = new ComboBoxOpcionHandler(this, cantidadOpciones, opcion.getOpcion(), respuestaFinal);
        this.setOnAction(handler);
    }
}
