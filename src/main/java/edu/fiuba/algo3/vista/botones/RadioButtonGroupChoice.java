package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.RadioButtonOpcionGroupChoiceEventHandler;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.scene.control.RadioButton;

import java.util.HashMap;
import java.util.List;

public class RadioButtonGroupChoice extends RadioButton {

    public RadioButtonGroupChoice(String opcionCorrecta, String respuestaLabel, HashMap<String, String> respuesta, String opcion, List<Opcion> respuestaFinal) {
        this.setText(respuestaLabel);
        RadioButtonOpcionGroupChoiceEventHandler eventHandler = new RadioButtonOpcionGroupChoiceEventHandler(opcionCorrecta, this, respuesta, opcion, respuestaFinal);
        this.setOnAction(eventHandler);
    }
}
