package edu.fiuba.algo3.vista.CheckBoxMultipleChoice;

import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.List;

public class CheckBoxMultipleChoiceEventHandler implements EventHandler<ActionEvent> {

    private final CheckBox checkbox;
    private final List<Opcion> respuesta;
    EstadoCheckBoxMultipleChoice estado = new EstadoNoAgregado();

    public CheckBoxMultipleChoiceEventHandler(CheckBox checkbox, List<Opcion> respuesta){
        this.checkbox = checkbox;
        this.respuesta = respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        estado = estado.modificarRespuesta(respuesta, checkbox.getText());
    }


}
