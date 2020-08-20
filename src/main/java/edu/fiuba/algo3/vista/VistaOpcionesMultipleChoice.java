package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.CheckBoxMultipleChoice.CheckBoxMultipleChoiceEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.util.List;

public class VistaOpcionesMultipleChoice extends HBox {

    List<Opcion> opciones;
    List<Opcion> respuesta;

    public VistaOpcionesMultipleChoice(List<Opcion> opciones, List<Opcion> respuesta) {
        this.setSpacing(20);
        this.opciones = opciones;
        this.respuesta = respuesta;
        update();
    }

    private CheckBox armarCheckBox(String opcion, List<Opcion> respuesta) {
        CheckBox checkbox = new CheckBox(opcion);
        checkbox.setStyle("-fx-font-size:30;");
        CheckBoxMultipleChoiceEventHandler eventHandler = new CheckBoxMultipleChoiceEventHandler(checkbox, respuesta);
        checkbox.setOnAction(eventHandler);
        return checkbox;
    }

    public void update() {
        this.getChildren().clear();
        opciones.forEach(opcion -> {
            CheckBox checkBox = armarCheckBox(opcion.obtenerOpcion(), respuesta);
            checkBox.setMaxSize(500, 30);
            this.getChildren().add(checkBox);
        });
        this.setAlignment(Pos.CENTER);
    }
}
